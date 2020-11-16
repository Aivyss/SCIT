// 
// Decompiled by Procyon v0.5.36
// 

package org.apache.log4j.jmx;

import org.apache.log4j.Priority;
import javax.management.MBeanServer;
import javax.management.InvalidAttributeValueException;
import org.apache.log4j.Level;
import javax.management.Attribute;
import javax.management.AttributeNotFoundException;
import javax.management.RuntimeOperationsException;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.MBeanException;
import org.apache.log4j.helpers.OptionConverter;
import org.apache.log4j.Layout;
import org.apache.log4j.spi.OptionHandler;
import javax.management.MBeanNotificationInfo;
import javax.management.MBeanInfo;
import java.lang.reflect.Method;
import java.beans.PropertyDescriptor;
import javax.management.MBeanParameterInfo;
import javax.management.MBeanAttributeInfo;
import java.beans.Introspector;
import java.beans.IntrospectionException;
import org.apache.log4j.Appender;
import org.apache.log4j.Logger;
import javax.management.MBeanOperationInfo;
import java.util.Hashtable;
import java.util.Vector;
import javax.management.MBeanConstructorInfo;

public class AppenderDynamicMBean extends AbstractDynamicMBean
{
    private MBeanConstructorInfo[] dConstructors;
    private Vector dAttributes;
    private String dClassName;
    private Hashtable dynamicProps;
    private MBeanOperationInfo[] dOperations;
    private String dDescription;
    private static Logger cat;
    private Appender appender;
    
    public AppenderDynamicMBean(final Appender appender) throws IntrospectionException {
        this.dConstructors = new MBeanConstructorInfo[1];
        this.dAttributes = new Vector();
        this.dClassName = this.getClass().getName();
        this.dynamicProps = new Hashtable(5);
        this.dOperations = new MBeanOperationInfo[2];
        this.dDescription = "This MBean acts as a management facade for log4j appenders.";
        this.appender = appender;
        this.buildDynamicMBeanInfo();
    }
    
    private void buildDynamicMBeanInfo() throws IntrospectionException {
        this.dConstructors[0] = new MBeanConstructorInfo("AppenderDynamicMBean(): Constructs a AppenderDynamicMBean instance", this.getClass().getConstructors()[0]);
        final PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(this.appender.getClass()).getPropertyDescriptors();
        for (int length = propertyDescriptors.length, i = 0; i < length; ++i) {
            final String name = propertyDescriptors[i].getName();
            final Method readMethod = propertyDescriptors[i].getReadMethod();
            final Method writeMethod = propertyDescriptors[i].getWriteMethod();
            if (readMethod != null) {
                final Class<?> returnType = readMethod.getReturnType();
                if (this.isSupportedType(returnType)) {
                    String name2;
                    if (returnType.isAssignableFrom(Priority.class)) {
                        name2 = "java.lang.String";
                    }
                    else {
                        name2 = returnType.getName();
                    }
                    this.dAttributes.add(new MBeanAttributeInfo(name, name2, "Dynamic", true, writeMethod != null, false));
                    this.dynamicProps.put(name, new MethodUnion(readMethod, writeMethod));
                }
            }
        }
        this.dOperations[0] = new MBeanOperationInfo("activateOptions", "activateOptions(): add an appender", new MBeanParameterInfo[0], "void", 1);
        this.dOperations[1] = new MBeanOperationInfo("setLayout", "setLayout(): add a layout", new MBeanParameterInfo[] { new MBeanParameterInfo("layout class", "java.lang.String", "layout class") }, "void", 1);
    }
    
    private boolean isSupportedType(final Class clazz) {
        return clazz.isPrimitive() || clazz == String.class || clazz.isAssignableFrom(Priority.class);
    }
    
    public MBeanInfo getMBeanInfo() {
        AppenderDynamicMBean.cat.debug("getMBeanInfo called.");
        final MBeanAttributeInfo[] array = new MBeanAttributeInfo[this.dAttributes.size()];
        this.dAttributes.toArray(array);
        return new MBeanInfo(this.dClassName, this.dDescription, array, this.dConstructors, this.dOperations, new MBeanNotificationInfo[0]);
    }
    
    public Object invoke(final String s, final Object[] array, final String[] array2) throws MBeanException, ReflectionException {
        if (s.equals("activateOptions") && this.appender instanceof OptionHandler) {
            ((OptionHandler)this.appender).activateOptions();
            return "Options activated.";
        }
        if (s.equals("setLayout")) {
            final Layout layout = (Layout)OptionConverter.instantiateByClassName((String)array[0], Layout.class, null);
            this.appender.setLayout(layout);
            this.registerLayoutMBean(layout);
        }
        return null;
    }
    
    void registerLayoutMBean(final Layout layout) {
        if (layout == null) {
            return;
        }
        final String string = this.appender.getName() + ",layout=" + layout.getClass().getName();
        AppenderDynamicMBean.cat.debug("Adding LayoutMBean:" + string);
        try {
            super.server.registerMBean(new LayoutDynamicMBean(layout), new ObjectName("log4j:appender=" + string));
            this.dAttributes.add(new MBeanAttributeInfo("appender=" + string, "javax.management.ObjectName", "The " + string + " layout.", true, true, false));
        }
        catch (Exception t) {
            AppenderDynamicMBean.cat.error("Could not add DynamicLayoutMBean for [" + string + "].", t);
        }
    }
    
    protected Logger getLogger() {
        return AppenderDynamicMBean.cat;
    }
    
    public Object getAttribute(final String s) throws AttributeNotFoundException, MBeanException, ReflectionException {
        if (s == null) {
            throw new RuntimeOperationsException(new IllegalArgumentException("Attribute name cannot be null"), "Cannot invoke a getter of " + this.dClassName + " with null attribute name");
        }
        AppenderDynamicMBean.cat.debug("getAttribute called with [" + s + "].");
        if (s.startsWith("appender=" + this.appender.getName() + ",layout")) {
            try {
                return new ObjectName("log4j:" + s);
            }
            catch (Exception t) {
                AppenderDynamicMBean.cat.error("attributeName", t);
            }
        }
        final MethodUnion methodUnion = this.dynamicProps.get(s);
        if (methodUnion != null && methodUnion.readMethod != null) {
            try {
                return methodUnion.readMethod.invoke(this.appender, (Object[])null);
            }
            catch (Exception ex) {
                return null;
            }
        }
        throw new AttributeNotFoundException("Cannot find " + s + " attribute in " + this.dClassName);
    }
    
    public void setAttribute(final Attribute attribute) throws AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException {
        if (attribute == null) {
            throw new RuntimeOperationsException(new IllegalArgumentException("Attribute cannot be null"), "Cannot invoke a setter of " + this.dClassName + " with null attribute");
        }
        final String name = attribute.getName();
        Object o = attribute.getValue();
        if (name == null) {
            throw new RuntimeOperationsException(new IllegalArgumentException("Attribute name cannot be null"), "Cannot invoke the setter of " + this.dClassName + " with null attribute name");
        }
        final MethodUnion methodUnion = this.dynamicProps.get(name);
        if (methodUnion != null && methodUnion.writeMethod != null) {
            final Object[] args = { null };
            if (methodUnion.writeMethod.getParameterTypes()[0] == Priority.class) {
                o = OptionConverter.toLevel((String)o, (Level)this.getAttribute(name));
            }
            args[0] = o;
            try {
                methodUnion.writeMethod.invoke(this.appender, args);
            }
            catch (Exception t) {
                AppenderDynamicMBean.cat.error("FIXME", t);
            }
        }
        else if (!name.endsWith(".layout")) {
            throw new AttributeNotFoundException("Attribute " + name + " not found in " + this.getClass().getName());
        }
    }
    
    public ObjectName preRegister(final MBeanServer mBeanServer, final ObjectName obj) {
        AppenderDynamicMBean.cat.debug("preRegister called. Server=" + mBeanServer + ", name=" + obj);
        super.server = mBeanServer;
        this.registerLayoutMBean(this.appender.getLayout());
        return obj;
    }
    
    static {
        AppenderDynamicMBean.cat = Logger.getLogger(AppenderDynamicMBean.class);
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package org.apache.log4j.jmx;

import org.apache.log4j.Priority;
import javax.management.InvalidAttributeValueException;
import org.apache.log4j.helpers.OptionConverter;
import org.apache.log4j.Level;
import javax.management.Attribute;
import javax.management.AttributeNotFoundException;
import javax.management.RuntimeOperationsException;
import javax.management.ReflectionException;
import javax.management.MBeanException;
import org.apache.log4j.spi.OptionHandler;
import javax.management.MBeanNotificationInfo;
import javax.management.MBeanInfo;
import java.lang.reflect.Method;
import java.beans.PropertyDescriptor;
import javax.management.MBeanParameterInfo;
import javax.management.MBeanAttributeInfo;
import java.beans.Introspector;
import java.beans.IntrospectionException;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import javax.management.MBeanOperationInfo;
import java.util.Hashtable;
import java.util.Vector;
import javax.management.MBeanConstructorInfo;

public class LayoutDynamicMBean extends AbstractDynamicMBean
{
    private MBeanConstructorInfo[] dConstructors;
    private Vector dAttributes;
    private String dClassName;
    private Hashtable dynamicProps;
    private MBeanOperationInfo[] dOperations;
    private String dDescription;
    private static Logger cat;
    private Layout layout;
    
    public LayoutDynamicMBean(final Layout layout) throws IntrospectionException {
        this.dConstructors = new MBeanConstructorInfo[1];
        this.dAttributes = new Vector();
        this.dClassName = this.getClass().getName();
        this.dynamicProps = new Hashtable(5);
        this.dOperations = new MBeanOperationInfo[1];
        this.dDescription = "This MBean acts as a management facade for log4j layouts.";
        this.layout = layout;
        this.buildDynamicMBeanInfo();
    }
    
    private void buildDynamicMBeanInfo() throws IntrospectionException {
        this.dConstructors[0] = new MBeanConstructorInfo("LayoutDynamicMBean(): Constructs a LayoutDynamicMBean instance", this.getClass().getConstructors()[0]);
        final PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(this.layout.getClass()).getPropertyDescriptors();
        for (int length = propertyDescriptors.length, i = 0; i < length; ++i) {
            final String name = propertyDescriptors[i].getName();
            final Method readMethod = propertyDescriptors[i].getReadMethod();
            final Method writeMethod = propertyDescriptors[i].getWriteMethod();
            if (readMethod != null) {
                final Class<?> returnType = readMethod.getReturnType();
                if (this.isSupportedType(returnType)) {
                    String name2;
                    if (returnType.isAssignableFrom(Level.class)) {
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
        this.dOperations[0] = new MBeanOperationInfo("activateOptions", "activateOptions(): add an layout", new MBeanParameterInfo[0], "void", 1);
    }
    
    private boolean isSupportedType(final Class clazz) {
        return clazz.isPrimitive() || clazz == String.class || clazz.isAssignableFrom(Level.class);
    }
    
    public MBeanInfo getMBeanInfo() {
        LayoutDynamicMBean.cat.debug("getMBeanInfo called.");
        final MBeanAttributeInfo[] array = new MBeanAttributeInfo[this.dAttributes.size()];
        this.dAttributes.toArray(array);
        return new MBeanInfo(this.dClassName, this.dDescription, array, this.dConstructors, this.dOperations, new MBeanNotificationInfo[0]);
    }
    
    public Object invoke(final String s, final Object[] array, final String[] array2) throws MBeanException, ReflectionException {
        if (s.equals("activateOptions") && this.layout instanceof OptionHandler) {
            this.layout.activateOptions();
            return "Options activated.";
        }
        return null;
    }
    
    protected Logger getLogger() {
        return LayoutDynamicMBean.cat;
    }
    
    public Object getAttribute(final String str) throws AttributeNotFoundException, MBeanException, ReflectionException {
        if (str == null) {
            throw new RuntimeOperationsException(new IllegalArgumentException("Attribute name cannot be null"), "Cannot invoke a getter of " + this.dClassName + " with null attribute name");
        }
        final MethodUnion obj = this.dynamicProps.get(str);
        LayoutDynamicMBean.cat.debug("----name=" + str + ", mu=" + obj);
        if (obj != null && obj.readMethod != null) {
            try {
                return obj.readMethod.invoke(this.layout, (Object[])null);
            }
            catch (Exception ex) {
                return null;
            }
        }
        throw new AttributeNotFoundException("Cannot find " + str + " attribute in " + this.dClassName);
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
                methodUnion.writeMethod.invoke(this.layout, args);
            }
            catch (Exception t) {
                LayoutDynamicMBean.cat.error("FIXME", t);
            }
            return;
        }
        throw new AttributeNotFoundException("Attribute " + name + " not found in " + this.getClass().getName());
    }
    
    static {
        LayoutDynamicMBean.cat = Logger.getLogger(LayoutDynamicMBean.class);
    }
}

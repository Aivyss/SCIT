// 
// Decompiled by Procyon v0.5.36
// 

package org.apache.log4j.jmx;

import java.util.Enumeration;
import javax.management.InvalidAttributeValueException;
import javax.management.Attribute;
import org.apache.log4j.helpers.OptionConverter;
import org.apache.log4j.Level;
import javax.management.AttributeNotFoundException;
import javax.management.ObjectName;
import javax.management.RuntimeOperationsException;
import javax.management.ReflectionException;
import javax.management.MBeanException;
import javax.management.MBeanNotificationInfo;
import javax.management.MBeanInfo;
import javax.management.MBeanParameterInfo;
import javax.management.MBeanAttributeInfo;
import org.apache.log4j.Appender;
import javax.management.Notification;
import org.apache.log4j.Logger;
import java.util.Vector;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanConstructorInfo;
import javax.management.NotificationListener;

public class LoggerDynamicMBean extends AbstractDynamicMBean implements NotificationListener
{
    private MBeanConstructorInfo[] dConstructors;
    private MBeanOperationInfo[] dOperations;
    private Vector dAttributes;
    private String dClassName;
    private String dDescription;
    private static Logger cat;
    private Logger logger;
    
    public LoggerDynamicMBean(final Logger logger) {
        this.dConstructors = new MBeanConstructorInfo[1];
        this.dOperations = new MBeanOperationInfo[1];
        this.dAttributes = new Vector();
        this.dClassName = this.getClass().getName();
        this.dDescription = "This MBean acts as a management facade for a org.apache.log4j.Logger instance.";
        this.logger = logger;
        this.buildDynamicMBeanInfo();
    }
    
    public void handleNotification(final Notification notification, final Object o) {
        LoggerDynamicMBean.cat.debug("Received notification: " + notification.getType());
        this.registerAppenderMBean((Appender)notification.getUserData());
    }
    
    private void buildDynamicMBeanInfo() {
        this.dConstructors[0] = new MBeanConstructorInfo("HierarchyDynamicMBean(): Constructs a HierarchyDynamicMBean instance", this.getClass().getConstructors()[0]);
        this.dAttributes.add(new MBeanAttributeInfo("name", "java.lang.String", "The name of this Logger.", true, false, false));
        this.dAttributes.add(new MBeanAttributeInfo("priority", "java.lang.String", "The priority of this logger.", true, true, false));
        this.dOperations[0] = new MBeanOperationInfo("addAppender", "addAppender(): add an appender", new MBeanParameterInfo[] { new MBeanParameterInfo("class name", "java.lang.String", "add an appender to this logger"), new MBeanParameterInfo("appender name", "java.lang.String", "name of the appender") }, "void", 1);
    }
    
    protected Logger getLogger() {
        return this.logger;
    }
    
    public MBeanInfo getMBeanInfo() {
        final MBeanAttributeInfo[] array = new MBeanAttributeInfo[this.dAttributes.size()];
        this.dAttributes.toArray(array);
        return new MBeanInfo(this.dClassName, this.dDescription, array, this.dConstructors, this.dOperations, new MBeanNotificationInfo[0]);
    }
    
    public Object invoke(final String s, final Object[] array, final String[] array2) throws MBeanException, ReflectionException {
        if (s.equals("addAppender")) {
            this.addAppender((String)array[0], (String)array[1]);
            return "Hello world.";
        }
        return null;
    }
    
    public Object getAttribute(final String str) throws AttributeNotFoundException, MBeanException, ReflectionException {
        if (str == null) {
            throw new RuntimeOperationsException(new IllegalArgumentException("Attribute name cannot be null"), "Cannot invoke a getter of " + this.dClassName + " with null attribute name");
        }
        if (str.equals("name")) {
            return this.logger.getName();
        }
        if (!str.equals("priority")) {
            if (str.startsWith("appender=")) {
                try {
                    return new ObjectName("log4j:" + str);
                }
                catch (Exception ex) {
                    LoggerDynamicMBean.cat.error("Could not create ObjectName" + str);
                }
            }
            throw new AttributeNotFoundException("Cannot find " + str + " attribute in " + this.dClassName);
        }
        final Level level = this.logger.getLevel();
        if (level == null) {
            return null;
        }
        return level.toString();
    }
    
    void addAppender(final String s, final String s2) {
        LoggerDynamicMBean.cat.debug("addAppender called with " + s + ", " + s2);
        final Appender newAppender = (Appender)OptionConverter.instantiateByClassName(s, Appender.class, null);
        newAppender.setName(s2);
        this.logger.addAppender(newAppender);
    }
    
    public void setAttribute(final Attribute attribute) throws AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException {
        if (attribute == null) {
            throw new RuntimeOperationsException(new IllegalArgumentException("Attribute cannot be null"), "Cannot invoke a setter of " + this.dClassName + " with null attribute");
        }
        final String name = attribute.getName();
        final Object value = attribute.getValue();
        if (name == null) {
            throw new RuntimeOperationsException(new IllegalArgumentException("Attribute name cannot be null"), "Cannot invoke the setter of " + this.dClassName + " with null attribute name");
        }
        if (name.equals("priority")) {
            if (value instanceof String) {
                final String value2 = (String)value;
                final Level level = this.logger.getLevel();
                Level level2;
                if (value2.equalsIgnoreCase("NULL")) {
                    level2 = null;
                }
                else {
                    level2 = OptionConverter.toLevel(value2, level);
                }
                this.logger.setLevel(level2);
            }
            return;
        }
        throw new AttributeNotFoundException("Attribute " + name + " not found in " + this.getClass().getName());
    }
    
    void appenderMBeanRegistration() {
        final Enumeration allAppenders = this.logger.getAllAppenders();
        while (allAppenders.hasMoreElements()) {
            this.registerAppenderMBean(allAppenders.nextElement());
        }
    }
    
    void registerAppenderMBean(final Appender appender) {
        final String name = appender.getName();
        LoggerDynamicMBean.cat.debug("Adding AppenderMBean for appender named " + name);
        try {
            super.server.registerMBean(new AppenderDynamicMBean(appender), new ObjectName("log4j", "appender", name));
            this.dAttributes.add(new MBeanAttributeInfo("appender=" + name, "javax.management.ObjectName", "The " + name + " appender.", true, true, false));
        }
        catch (Exception t) {
            LoggerDynamicMBean.cat.error("Could not add appenderMBean for [" + name + "].", t);
        }
    }
    
    public void postRegister(final Boolean b) {
        this.appenderMBeanRegistration();
    }
    
    static {
        LoggerDynamicMBean.cat = Logger.getLogger(LoggerDynamicMBean.class);
    }
}

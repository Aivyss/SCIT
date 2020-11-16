// 
// Decompiled by Procyon v0.5.36
// 

package org.apache.log4j.jmx;

import com.sun.jdmk.comm.CommunicatorServer;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import com.sun.jdmk.comm.HtmlAdaptorServer;
import javax.management.MBeanServerFactory;
import org.apache.log4j.Logger;

public class Agent
{
    static Logger log;
    
    public void start() {
        final MBeanServer mBeanServer = MBeanServerFactory.createMBeanServer();
        final HtmlAdaptorServer htmlAdaptorServer = new HtmlAdaptorServer();
        try {
            Agent.log.info("Registering HtmlAdaptorServer instance.");
            mBeanServer.registerMBean(htmlAdaptorServer, new ObjectName("Adaptor:name=html,port=8082"));
            Agent.log.info("Registering HierarchyDynamicMBean instance.");
            mBeanServer.registerMBean(new HierarchyDynamicMBean(), new ObjectName("log4j:hiearchy=default"));
        }
        catch (Exception t) {
            Agent.log.error("Problem while regitering MBeans instances.", t);
            return;
        }
        ((CommunicatorServer)htmlAdaptorServer).start();
    }
    
    static {
        Agent.log = Logger.getLogger(Agent.class);
    }
}

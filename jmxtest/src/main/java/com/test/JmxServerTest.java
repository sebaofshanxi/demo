package com.test;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import javax.naming.Context;
import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by seba on 16/5/5.
 */
public class JmxServerTest {

    private static final String DOMAIN    = "suren";
    //用jconsole连接的话，会在“MBean”选项卡中多出来下面包名定义的一个节点
    private static final String PACKAGE = "org.suren.littlebird:type=";

    public static void main(String args[]) throws Exception
    {
        LocateRegistry.createRegistry(5006); //用于远程连接的端口
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();

        //注册一个可供调用的Bean对象
        TestHello testHello = new TestHello();
        ObjectName testHelloObjName = new ObjectName(PACKAGE + "TestHello");
        server.registerMBean(testHello, testHelloObjName);

        //注册一个可供远程连接的Bean对象
        JMXServiceURL serverUrl = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://127.0.0.1:5006/"+DOMAIN);
        Map<String, String> env = new HashMap<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
        JMXConnectorServer connectorServer = JMXConnectorServerFactory.newJMXConnectorServer(serverUrl,env, server);
        server.registerMBean(connectorServer, new ObjectName(PACKAGE + "JMXConnectorServer"));

        //启动服务，这个start动作也可以通过jconsole来调用
        connectorServer.start();
    }
}
package com.test;

import javax.management.MBeanInfo;
import javax.management.MBeanServerConnection;
import javax.management.ObjectInstance;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by seba on 16/5/5.
 */
public class JmxClientTest
{

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception
    {
        String hostName = "127.0.0.1"; //发布JMX服务的地址
        int portNum = 5006; //发布服务的端口

        JMXServiceURL u = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://"
                + hostName + ":" + portNum + "/suren");

        Map<String, Object> auth = new HashMap<String, Object>();
        //认证所需要的用户信息
        auth.put(JMXConnector.CREDENTIALS, new String[]{ "controlRole", "123" });

        JMXConnector jmxConnector = JMXConnectorFactory.connect(u, auth);
        MBeanServerConnection connection = jmxConnector.getMBeanServerConnection();

        Set<ObjectInstance> beans = connection.queryMBeans(null, null);
        for(ObjectInstance objInstance : beans)
        {
            ObjectName mBeanName = objInstance.getObjectName();
            MBeanInfo mbeanInfo = connection.getMBeanInfo(mBeanName);

            System.out.println(Arrays.toString(mbeanInfo.getOperations()));
        }
    }
}
package com.test;

import javafx.beans.property.Property;
import org.springframework.core.env.Environment;
import org.springframework.web.context.support.StandardServletEnvironment;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * Created by seba on 16/4/28.
 */
public class TestContextLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        System.out.println("*****************************");
        Properties pro = System.getProperties();
        Iterator it=pro.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry entry=(Map.Entry)it.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key +":"+value);
        }
        System.out.println("*****************************");


        System.out.println("env begin*****************************");
        Map<String,String> m = System.getenv();
        it=m.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry entry=(Map.Entry)it.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key +":"+value);
        }
        System.out.println("env end*****************************");

        System.out.println("senv begin*****************************");

        for(Enumeration e = sce.getServletContext().getInitParameterNames(); e.hasMoreElements();){

            String key=(String)e.nextElement();

            String value=sce.getServletContext().getInitParameter(key);

            System.out.println(key +":"+value);
        }
        System.out.println("senv end*****************************");



        StandardServletEnvironment environment = new StandardServletEnvironment();
        environment.getSystemEnvironment();
        environment.getSystemProperties();

        String defaultRunEnvValue = "qa";


        String runEnvValue = environment.getProperty("test_wxf3");
//        String evnValue = environment.getProperty(evnName);

//        ServletContext sc = sce.getServletContext();
//        String scRunEnvValue = sc.getInitParameter(runEnvName);
//        String scEvnValue = sc.getInitParameter(evnName);




        String evn = System.getProperty("evn");
        if(evn == null || evn.equals("")) {
            evn = sce.getServletContext().getInitParameter("evn");
            //System.out.println("ffffffff:"+evn);
            if (evn == null) {
                evn = "qa";
            }
            System.setProperty("evn", evn);
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // TODO Auto-generated method stub

    }
}

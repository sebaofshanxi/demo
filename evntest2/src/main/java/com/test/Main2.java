package com.test;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * Created by seba on 16/5/5.
 */
public class Main2 {
    public static void main(String[] args) {
        System.out.println("property end*****************************");
        Properties pro = System.getProperties();
        Iterator it = pro.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + ":" + value);
        }
        System.out.println("property end*****************************");


        System.out.println("arg begin*****************************");
        for (String arg : args) {
            System.out.println("arg:" + arg);
        }
        System.out.println("arg end*****************************");
    }
}

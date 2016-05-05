package com.test;

/**
 * Created by seba on 16/5/5.
 */
/**
 * @author ChenGang 2005-12-3
 */
public class Hello implements HelloMBean {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void printHello() {
        System.out.println("Hello World, " + name);
    }
    public void printHello(String whoName) {
        System.out.println("Hello , " + whoName);
    }
}
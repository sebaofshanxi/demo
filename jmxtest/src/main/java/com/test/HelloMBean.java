package com.test;

/**
 * Created by seba on 16/5/5.
 */
/**
 * @author ChenGang 2005-12-3
 */
public interface HelloMBean {
    public String getName();
    public void setName(String name);
    public void printHello();
    public void printHello(String whoName);
}
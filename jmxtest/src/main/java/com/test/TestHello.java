package com.test;

/**
 * Created by seba on 16/5/5.
 */
public class TestHello implements ITestHelloMXBean {

    @Override
    public void hello() {
        System.out.println("impl hello");
    }

    @Override
    public String getName() {
        return "test get name";
    }
}

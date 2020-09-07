package com.example.demo.factoryPattern.abstractFactory;

/**
 * @author liguo
 * @Description ad帽子  具体产品
 * @date 2020/9/1/001 16:49
 */
public class AdHat implements Hat{
    @Override
    public void withLog() {
        System.out.println("hat trademark is Ad");
    }
}

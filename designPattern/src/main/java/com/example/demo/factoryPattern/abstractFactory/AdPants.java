package com.example.demo.factoryPattern.abstractFactory;

/**
 * @author liguo
 * @Description ad裤子 具体产品
 * @date 2020/9/1/001 16:50
 */
public class AdPants implements Pants{
    @Override
    public void withLog() {
        System.out.println("pants trademark is Ad");
    }
}

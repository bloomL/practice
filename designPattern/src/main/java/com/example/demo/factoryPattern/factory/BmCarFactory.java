package com.example.demo.factoryPattern.factory;

/**
 * @author liguo
 * @Description
 * @date 2020/9/1/001 16:21
 */
public class BmCarFactory implements CarFactory{
    @Override
    public Performance creatCar() {
        return new BmCarPerformance();
    }
}

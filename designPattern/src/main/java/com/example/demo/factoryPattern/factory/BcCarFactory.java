package com.example.demo.factoryPattern.factory;

/**
 * @author liguo
 * @Description
 * @date 2020/9/1/001 16:22
 */
public class BcCarFactory implements CarFactory{
    @Override
    public Performance creatCar() {
        return new BcCarPerformance();
    }
}

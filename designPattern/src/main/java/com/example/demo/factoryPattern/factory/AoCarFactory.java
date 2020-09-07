package com.example.demo.factoryPattern.factory;

/**
 * @author liguo
 * @Description
 * @date 2020/9/1/001 16:15
 */
public class AoCarFactory implements CarFactory{
    @Override
    public Performance creatCar() {
        return new AoCarPerformance();
    }
}

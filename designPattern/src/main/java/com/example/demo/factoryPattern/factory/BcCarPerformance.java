package com.example.demo.factoryPattern.factory;

/**
 * @author liguo
 * @Description
 * @date 2020/9/1/001 16:23
 */
public class BcCarPerformance implements Performance{
    @Override
    public void aboutAcceleration() {
        System.out.println("BcCar百米加速3.5s");
    }
}

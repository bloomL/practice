package com.example.demo.factoryPattern.factory;

/**
 * @author liguo
 * @Description
 * @date 2020/9/1/001 16:21
 */
public class BmCarPerformance implements Performance{
    @Override
    public void aboutAcceleration() {
        System.out.println("BmCar百米加速4.5s");
    }
}

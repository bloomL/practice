package com.example.demo.factoryPattern.factory;

/**
 * @author liguo
 * @Description
 * @date 2020/9/1/001 16:17
 */
public class AoCarPerformance implements Performance{
    @Override
    public void aboutAcceleration() {
        System.out.println("AoCar百米加速2.5s");
    }
}

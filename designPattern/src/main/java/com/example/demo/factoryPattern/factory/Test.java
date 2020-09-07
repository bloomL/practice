package com.example.demo.factoryPattern.factory;

/**
 * @author liguo
 * @Description
 * @date 2020/9/1/001 16:24
 */
public class Test {
    public static void main(String[] args) {
        //工厂
        CarFactory aoCarFactory = new AoCarFactory();
        //性能
        Performance aoCarPerformance = aoCarFactory.creatCar();
        aoCarPerformance.aboutAcceleration();
    }
}

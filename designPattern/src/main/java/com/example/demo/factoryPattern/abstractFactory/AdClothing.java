package com.example.demo.factoryPattern.abstractFactory;

/**
 * @author liguo
 * @Description ad服装工厂  具体工厂
 * @date 2020/9/1/001 16:45
 */
public class AdClothing implements ClothingFactory{
    @Override
    public Hat produceHat() {
        return new AdHat();
    }

    @Override
    public Pants producePants() {
        return new AdPants();
    }
}

package com.example.demo.factoryPattern.abstractFactory;

/**
 * @author liguo
 * @Description 服装工厂  抽象工厂
 * @date 2020/9/1/001 16:39
 */
public interface ClothingFactory {
    Hat produceHat();
    Pants producePants();
}

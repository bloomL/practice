package com.example.demo.factoryPattern.abstractFactory;

/**
 * @author liguo
 * @Description
 * @date 2020/9/1/001 16:56
 */
public class Test {
    public static void main(String[] args) {
        ClothingFactory adClothing = new AdClothing();
        Hat adHat = adClothing.produceHat();
        adHat.withLog();
        Pants adPants = adClothing.producePants();
        adPants.withLog();
    }
}

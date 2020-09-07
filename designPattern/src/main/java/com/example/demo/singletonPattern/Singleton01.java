package com.example.demo.singletonPattern;

/**
 * @author liguo
 * @Description 饿汉模式,加载类时，就创建该实例
 * @date 2020/9/1/001 11:45
 */
public class Singleton01 {
    //静态初始化器（只执行一次）中创建单例实例，保证线程安全
    private static Singleton01 unique = new Singleton01();
    private Singleton01(){}
    public static Singleton01 getInstance(){
        return unique;
    }
}

package com.example.demo.singletonPattern;

/**
 * @author liguo
 * @Description 静态内部类
 *              类加载机制来保证只创建一个instance实例。它与饿汉模式一样，也是利用了类加载机制，因此不存在多线程并发的问题
 * @date 2020/9/1/001 14:42
 */
public class Singleton03 {
    private static class SingletonHolder{
        public static Singleton03 unique = new Singleton03();
    }
    private Singleton03(){}
    public static Singleton03 getInstance(){
        return SingletonHolder.unique;
    }
}

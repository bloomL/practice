package com.example.demo.singletonPattern;

/**
 * @author liguo
 * @Description 懒汉模式 使用时才创建
 *              最常用：双重锁检验
 * @date 2020/9/1/001 14:24
 */
public class Singleton02 {
    private volatile static Singleton02 unique = null;
    private Singleton02(){}
    public static Singleton02 getInstance(){
        if (unique == null){
            synchronized (Singleton02.class){
                if (unique == null){
                    //volatile,防止JVM指令重排序,new()可分为三步
                    //1.unique分配空间
                    //2.unique初始化
                    //3.unique指向内存空间
                    //JVM可进行指令重排序。执行顺序可变为1，3，2，导致返回的uniqueInstance 未初始化
                    unique = new Singleton02();
                }
            }
        }
        return unique;
    }
}

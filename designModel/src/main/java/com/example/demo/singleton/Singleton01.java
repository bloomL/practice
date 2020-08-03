package com.example.demo.singleton;

/**
 * @author liguo
 * @Description 双重校验
 * @date 2020/7/28/028 10:47
 */
public class Singleton01 {
    /**
     * volatile 禁止指令重排序
     */
    private volatile static Singleton01 uniqueInstance;

    private Singleton01(){

    }

    public static Singleton01 getUniqueInstance(){
        if (uniqueInstance == null){
            synchronized (Singleton01.class){
                if (uniqueInstance == null){
                    uniqueInstance = new Singleton01();
                }
            }
        }
        return uniqueInstance;
    }
}

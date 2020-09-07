package com.example.demo.singletonPattern;

/**
 * @author liguo
 * @Description
 * @date 2020/9/1/001 14:48
 */
public enum Singleton04 {
    /**
     * 单例
     */
    SINGLETON;

    public void doThings(){
        System.out.println("枚举类单例");
    }
}

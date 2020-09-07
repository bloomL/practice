package com.example.demo.singletonPattern;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liguo
 * @Description
 * @date 2020/9/1/001 13:49
 */
public class SingletonTest {
    /**
     * Singleton01
     */
    private static final int AMOUNT = 10;
    public static ThreadFactory nameFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
    static ThreadPoolExecutor executor = new ThreadPoolExecutor(AMOUNT, AMOUNT, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(), nameFactory, new ThreadPoolExecutor.AbortPolicy());
    /*public static void main(String[] args) {
        for (int i = 0; i < AMOUNT; i++) {
            executor.execute(() -> System.out.println(Thread.currentThread().getName()+":"+Singleton01.getInstance()));
        }
        executor.shutdown();
    }*/

    /**
     *  Singleton04
     * @param args
     */
    public static void main(String[] args) {
        Singleton04 singleton = Singleton04.SINGLETON;
        singleton.doThings();
    }
}

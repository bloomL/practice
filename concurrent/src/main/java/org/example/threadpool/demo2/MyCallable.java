package org.example.threadpool.demo2;

import java.util.concurrent.Callable;

/**
 * @author liguo
 * @Description
 * @date 2020/7/30/030 11:47
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        //返回执行当前 Callable 的线程名字
        return Thread.currentThread().getName();
    }
}

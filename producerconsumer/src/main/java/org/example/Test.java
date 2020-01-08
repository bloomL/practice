package org.example;

import org.example.consumer.Consumer;
import org.example.producer.Producer;

import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        //内存缓存区
        Vector sharedQueue = new Vector();
        int size = 4;
        //建立线程池及线程
        ExecutorService executorService = new ThreadPoolExecutor(0,Integer.MAX_VALUE,60L, TimeUnit.SECONDS,new SynchronousQueue<Runnable>());
        Producer producerA = new Producer(sharedQueue,size);
        Producer producerB = new Producer(sharedQueue,size);
        Producer producerC = new Producer(sharedQueue,size);
        Consumer consumerA = new Consumer(sharedQueue);
        Consumer consumerB = new Consumer(sharedQueue);
        Consumer consumerC = new Consumer(sharedQueue);
        executorService.execute(producerA);
        executorService.execute(producerB);
        executorService.execute(producerC);
        executorService.execute(consumerA);
        executorService.execute(consumerB);
        executorService.execute(consumerC);

        // 3.睡一会儿然后尝试停止生产者(结束循环)
        Thread.sleep(10 * 1000);
        producerA.stop();
        producerB.stop();
        producerC.stop();

        // 4.再睡一会儿关闭线程池
        Thread.sleep(3000);

        // 5.shutdown()等待任务执行完才中断线程(因为消费者一直在运行的，所以会发现程序无法结束)
        executorService.shutdown();

    }
}

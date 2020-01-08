package org.example.producer;

import java.util.Random;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable{
    private volatile boolean isRunning = true;
    //公共资源
    private final Vector sharedQueue;

    //公共资源最大数量
    private final int SIZE;

    //生产数据
    private static AtomicInteger count = new AtomicInteger();

    public Producer(Vector sharedQueue,int SIZE){
        this.sharedQueue = sharedQueue;
        this.SIZE = SIZE;
    }

    @Override
    public void run() {
        int data;
        Random random = new Random();
        System.out.println("start producer id="+Thread.currentThread().getId());
        try {
            while(isRunning){
                //模拟延迟
                Thread.sleep(random.nextInt(1000));
                //队列满时阻塞等待
                while(sharedQueue.size() == SIZE){
                    synchronized (sharedQueue){
                        System.out.println("Queue is full, producer " + Thread.currentThread().getId()
                                + " is waiting, size：" + sharedQueue.size());
                        sharedQueue.wait();
                    }
                }
                //队列不满时持续生产对象
                synchronized (sharedQueue){
                    //生产数据
                    data = count.incrementAndGet();
                    sharedQueue.add(data);
                    System.out.println("producer create data:" + data + ", size：" + sharedQueue.size());
                    sharedQueue.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public void stop(){
        isRunning = false;
    }
}

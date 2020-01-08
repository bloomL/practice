package org.example.consumer;

import java.util.Random;
import java.util.Vector;

public class Consumer implements Runnable {
    //公共资源
    private final Vector sharedQueue;

    public Consumer(Vector sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        Random random = new Random();
        System.out.println("start consumer id = " + Thread.currentThread().getId());
        try {
            while (true) {
                //模拟延时
                Thread.sleep(random.nextInt(1000));
                //当队列为空阻塞等待
                while (sharedQueue.isEmpty()) {
                    synchronized (sharedQueue) {
                        System.out.println("Queue is empty, consumer " + Thread.currentThread().getId()
                                + " is waiting, size：" + sharedQueue.size());
                        sharedQueue.wait();
                    }
                }
                //队列不为空持续消费
                synchronized (sharedQueue){
                    System.out.println("consumer consume data：" + sharedQueue.remove(0) + ", size：" + sharedQueue.size());
                    sharedQueue.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}

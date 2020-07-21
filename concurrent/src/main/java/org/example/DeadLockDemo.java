package org.example;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liguo
 * @Description 死锁
 * 线程 A 通过 synchronized (resource1) 获得 resource1 的监视器锁，然后通过Thread.sleep(1000);
 * 让线程 A 休眠 1s 为的是让线程 B 得到执行然后获取到 resource2 的监视器锁。
 * 线程 A 和线程 B 休眠结束了都开始企图请求获取对方的资源，然后这两个线程就会陷入互相等待的状态，这也就产生了死锁
 * @date 2020/7/21/021 11:33
 */
public class DeadLockDemo {
    /** 资源1 */
    private static Object resource1 = new Object();
    /** 资源2 */
    private static Object resource2 = new Object();

    static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
    public static ThreadPoolExecutor threadPoolOne = new ThreadPoolExecutor(1, 1,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
    public static ThreadPoolExecutor threadPoolTwo = new ThreadPoolExecutor(1, 1,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        threadPoolOne.execute(() -> {
            synchronized (resource1){
                System.out.println(Thread.currentThread() + "get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource2");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "get resource2");
                }
            }
            System.out.println(Thread.currentThread().getName());
        });
        threadPoolTwo.execute(() -> {
            synchronized (resource2) {
                System.out.println(Thread.currentThread() + "get resource2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource1");
                synchronized (resource1) {
                    System.out.println(Thread.currentThread() + "get resource1");
                }
            }
            System.out.println(Thread.currentThread().getName());
        });
        threadPoolOne.shutdown();
        threadPoolTwo.shutdown();
    }
}

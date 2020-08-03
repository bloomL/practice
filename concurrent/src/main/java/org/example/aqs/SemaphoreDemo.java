package org.example.aqs;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author liguo
 * @Description
 * @date 2020/7/31/031 13:43
 */
public class SemaphoreDemo {
    private static final int THREAD_COUNT = 600;
    private static final int CORE_POOL_SIZE = 300;
    private static final int MAX_POOL_SIZE = 300;
    private static final Long KEEP_ALIVE_TIME = 0L;
    private static ThreadFactory nameFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();


    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),
                nameFactory,
                new ThreadPoolExecutor.CallerRunsPolicy());

        //一次只允许执行的线程数
        Semaphore semaphore = new Semaphore(20);
        for (int i = 0; i < THREAD_COUNT; i++) {
            final int fi = i;
            executor.execute(()->{
                try{
                    //获取一个许可,可运行线程数量为20/1=20
                    semaphore.acquire();
                    test(fi);
                    // 释放一个许可
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executor.shutdown();
        System.out.println("finish");
    }

    public static void test(int threadnum) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("threadName:"+ Thread.currentThread().getName() + "threadnum:" + threadnum);
        Thread.sleep(1000);
        System.out.println("----------------------------------------------------------------------------");
    }
}

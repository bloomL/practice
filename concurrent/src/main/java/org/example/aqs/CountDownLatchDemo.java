package org.example.aqs;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author liguo
 * @Description
 * @date 2020/7/31/031 14:39
 */
public class CountDownLatchDemo {
    private static final int THREAD_COUNT = 600;
    private static final int CORE_POOL_SIZE = 300;
    private static final int MAX_POOL_SIZE = 300;
    private static final Long KEEP_ALIVE_TIME = 0L;
    private static ThreadFactory NAME_FACTORY = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),
                NAME_FACTORY,
                new ThreadPoolExecutor.AbortPolicy());
        CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT);
        for (int i = 0; i < THREAD_COUNT; i++) {
            final int finalI = i;
            executor.execute(()->{
                try{
                    test(finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
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

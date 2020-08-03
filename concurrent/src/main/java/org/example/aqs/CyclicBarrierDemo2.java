package org.example.aqs;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author liguo
 * @Description
 * @date 2020/7/31/031 15:50
 */
public class CyclicBarrierDemo2 {
    private static final int THREAD_COUNT = 180;
    private static final int CORE_POOL_SIZE = 10;
    private static final int MAX_POOL_SIZE = 10;
    private static final Long KEEP_ALIVE_TIME = 0L;
    private static ThreadFactory NAME_FACTORY = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
    private static final CyclicBarrier CYCLIC_BARRIER = new CyclicBarrier(5,()->{
        System.out.println("------当线程数达到之后，优先执行------");
    });

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),
                NAME_FACTORY,
                new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < THREAD_COUNT; i++) {
            final int finalI = i;
            Thread.sleep(1000);
            executor.execute(()->{
                try {
                    test(finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executor.shutdown();
    }

    public static void test(int threadnum) throws InterruptedException {
        System.out.println("threadName:"+ Thread.currentThread().getName() + " threadnum:" + threadnum +" is ready");
        try{
            CYCLIC_BARRIER.await(30,TimeUnit.SECONDS);
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println("threadName:"+ Thread.currentThread().getName() + " threadnum:" + threadnum +" is finish");
    }
}

package org.example.threadpool.demo1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liguo
 * @Description
 * @date 2020/7/28/028 17:56
 */
public class ThreadPoolExecutorDemo1 {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 10; i++) {
            Runnable work = new MyRunnable("" + i);
            threadPoolExecutor.execute(work);
        }
        threadPoolExecutor.shutdown();
        while(!threadPoolExecutor.isTerminated()){
        }
        System.out.println("Finished all threads");
    }
}

package org.example.aboutthreadlocal;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @author liguo
 * @Description
 * @date 2020/7/28/028 15:33
 */
public class ThreadLocalDemo1 {
    public static ThreadFactory NAME_FACTORY =  new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
    public static ExecutorService THREAD_POOL = new ThreadPoolExecutor(10,10,0L,
            TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1024),
            NAME_FACTORY,new ThreadPoolExecutor.AbortPolicy());
    private static final ThreadLocal<SimpleDateFormat> FORMAT = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm"));
    private static final int CYCLE_TIME = 100;
    public static void main(String[] args) {
        for (int i = 0; i < CYCLE_TIME; i++) {
            int finalI = i;
            THREAD_POOL.submit(() -> {
                String date = FORMAT.get().format(new Date(finalI * 1000));
                System.out.println(date);
            });
        }
        THREAD_POOL.shutdown();
    }
}

package org.example.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liguo
 * @Description
 * @date 2020/7/24/024 17:46
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger num = new AtomicInteger(6);
        System.out.println(num.compareAndSet(6, 7) + "\t + current num:" + num);
    }
}

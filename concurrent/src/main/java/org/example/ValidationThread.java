package org.example;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;

/**
 * @author liguo
 * @Description 验证天生多线程，JMX查看，Java Management Extensions,是管理Java的一种扩展
 *              ManagementFactory：获取JVM信息的工厂类
 *
 * @date 2020/7/1/001 9:55
 */
public class ValidationThread {
    public static void main(String[] args) {
        // 获取 java 线程管理 MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的 monitor 和 synchronizer 信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        // 打印线程ID和线程名
        Arrays.stream(threadInfos).forEach(t -> System.out.println("[" + t.getThreadId() + "] " + t.getThreadName()));
    }
}

package org.example;

/**
 * @author liguo
 * @Description  静态内部类实现单例
 *               不仅具有延迟初始化，而且由JVM提供了对线程安全支持
 * @date 2020/6/28/028 16:05
 */
public class Singleton {

    /**
     * private 避免调用默认构造方法创建对象
     */
    private Singleton(){};

    /**
     * private 表明静态内部该类只能在该类中被访问
     */
    private static class SingletonHolder{
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getUniqueInstance(){
        return SingletonHolder.INSTANCE;
    }
}

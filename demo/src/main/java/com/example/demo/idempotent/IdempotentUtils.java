package com.example.demo.idempotent;

import org.apache.commons.collections4.map.LRUMap;

/**
 * @author liguo
 * @Description 幂等性判断
 * @date 2020/7/24/024 16:41
 */
public class IdempotentUtils {

    /**
     * 根据 LRU(Least Recently Used，最近最少使用)算法淘汰数据的 Map 集合，最大容量 100 个
     */
    private static LRUMap<String,Integer> lruCache = new LRUMap<>(100);

    public static boolean judge(String id, Object lock){
        synchronized (lock){
            //重复请求判断
            if (lruCache.containsKey(id)){
                //重复请求
                System.out.println("请勿重复提交！！！" + id);
                return false;
            }
            //非重复请求
            lruCache.put(id,1);
            return true;
        }
    }
}

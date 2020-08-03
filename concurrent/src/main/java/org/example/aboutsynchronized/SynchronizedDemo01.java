package org.example.aboutsynchronized;

/**
 * @author liguo
 * @Description 修饰代码块
 * @date 2020/7/28/028 11:36
 */
public class SynchronizedDemo01 {
    public void show(){
        synchronized (this){
            System.out.println("synchronized修饰代码块");
        }
    }
}

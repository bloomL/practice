package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AchieveByLock {
    private  int CYCLEINDEX;
    private volatile int state;
    private Lock lock = new ReentrantLock();

    public AchieveByLock(int times){
        this.CYCLEINDEX = times;
    }

    public static void main(String[] args) {
        AchieveByLock achieveByLock = new AchieveByLock(10);
        new Thread(achieveByLock::printA).start();
        new Thread(achieveByLock::printB).start();
        new Thread(achieveByLock::printC).start();
    }

    private void printA(){
        print("A",0);
    }

    private void printB(){
        print("B",1);
    }

    private void printC(){
        print("C",2);
    }

    private void print(String name,Integer target){
        for (int i = 0; i < CYCLEINDEX;) {
            lock.lock();
            if (state % 3 == target){
                state++;
                i++;
                System.out.println(name);
            }
            lock.unlock();
        }
    }

}

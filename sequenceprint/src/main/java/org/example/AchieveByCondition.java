package org.example;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AchieveByCondition {
    private  int CYCLEINDEX;
    private volatile int state;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public AchieveByCondition(int times){
        this.CYCLEINDEX = times;
    }

    public static void main(String[] args) {
        AchieveByCondition achieveByCondition = new AchieveByCondition(10);
        new Thread(achieveByCondition::printA).start();
        new Thread(achieveByCondition::printB).start();
        new Thread(achieveByCondition::printC).start();
    }

    private void printA(){
        try {
            print("A",0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void printB(){
        try {
            print("B",1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void printC(){
        try {
            print("C",2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void print (String name ,int target) throws InterruptedException {
        for (int i = 0; i < CYCLEINDEX; i++) {
            lock.lock();
            try {
                while(state % 3 != target){
                    condition.await();
                }
                state++;
                System.out.println(name);
                condition.signalAll();
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}

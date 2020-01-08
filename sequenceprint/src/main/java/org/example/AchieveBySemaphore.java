package org.example;

import java.util.concurrent.Semaphore;

public class AchieveBySemaphore {
    private int CYCLEINDEX;
    private Semaphore semaphoreA = new Semaphore(1);
    private Semaphore semaphoreB = new Semaphore(0);
    private Semaphore semaphoreC = new Semaphore(0);

    public AchieveBySemaphore(int times){
        this.CYCLEINDEX = times;
    }

    public static void main(String[] args) {
        AchieveBySemaphore achieveBySemaphore = new AchieveBySemaphore(10);
        new Thread(achieveBySemaphore::printA).start();
        new Thread(achieveBySemaphore::printB).start();
        new Thread(achieveBySemaphore::printC).start();
    }

    private void printA(){
        try {
            print("A",semaphoreA,semaphoreB);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void printB(){
        try {
            print("B",semaphoreB,semaphoreC);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void printC(){
        try {
            print("C",semaphoreC,semaphoreA);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void print(String name,Semaphore current,Semaphore next) throws InterruptedException {
        for (int i = 0; i <CYCLEINDEX ; i++) {
            current.acquire();
            System.out.println(name);
            next.release();
        }
    }
}

package org.example;

public class AchieveBySync {
    private  int CYCLEINDEX;
    private volatile int state;
    private static final Object lock = new Object();

    public AchieveBySync(int times){
        this.CYCLEINDEX = times;
    }

    public static void main(String[] args) {
        AchieveBySync achieveBySync = new AchieveBySync(10);
        new Thread(achieveBySync::printA).start();
        new Thread(achieveBySync::printB).start();
        new Thread(achieveBySync::printC).start();
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
            synchronized (lock){
                while(state % 3 != target){
                    lock.wait();
                }
                state++;
                System.out.println(name);
                lock.notifyAll();
            }
        }
    }
}

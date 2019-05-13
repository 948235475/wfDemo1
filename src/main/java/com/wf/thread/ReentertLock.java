package com.wf.thread;


import java.util.concurrent.locks.ReentrantLock;

public class ReentertLock implements Runnable{

    public static ReentrantLock reentrantLock = new ReentrantLock();

    public static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 10; j++){
            reentrantLock.lock();
            System.out.println("开始");
            try {
                i++;
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                System.out.println("结束");
                reentrantLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentertLock reentertLock = new ReentertLock();
        Thread thread = new Thread(reentertLock);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(i);
    }
}

package com.wf.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {

    private static Lock lock1 = new ReentrantLock();

    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private static Lock reaLock = lock.readLock();

    private static Lock writeLock = lock.writeLock();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    public void readLock(Lock lock){
        try {
            lock.lock();
            Date date = new Date();
            System.out.println("read开始"+format.format(date));
            Thread.sleep(1000);
            Date date2 = new Date();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            Date date1 = new Date();
            System.out.println("read结束"+format.format(date1));
            lock.unlock();
        }
    }
    public void writeLock(Lock lock){
        try {
            lock.lock();
            Date date = new Date();
            System.out.println("write开始"+format.format(date));
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            Date date1 = new Date();
            System.out.println("write结束"+format.format(date1));
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final ReadWriteLock readWriteLock = new ReadWriteLock();
        Runnable readRunnable = new Runnable() {
            @Override
            public void run() {
                readWriteLock.readLock(reaLock);
            }
        };
        Runnable writeRunnable = new Runnable() {
            @Override
            public void run() {
                readWriteLock.writeLock(writeLock);
            }
        };
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        System.out.println("readwrite"+format.format(date));
        for (int i = 0;i < 3;i++) {
            //new Thread(writeRunnable).start();
            new Thread(readRunnable).start();
        }
        Date date1 = new Date();
        System.out.println("readwrite"+format.format(date1));
    }
}

package com.enjoy.lock;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.add("dd");
        copyOnWriteArrayList.get(0);
        Semaphore semaphore = new Semaphore(4);
        AtomicInteger atomicInteger = new AtomicInteger(1);
        atomicInteger.addAndGet(1);
        Lock lock = new ReentrantLock(true);
        Thread t1 = new Thread(()->{
            lock.lock();
            System.out.println("t1----");
            try {
                sleep(2000000);
            } catch (InterruptedException e) {
            }
            lock.unlock();
        });
        Thread t2 = new Thread(()->{
            lock.lock();
            System.out.println("t2----");
            lock.unlock();
        });
        t1.setName("t1");
        t1.start();
        sleep(100);
        t2.setName("t2");
        t2.start();
    }
}

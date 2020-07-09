package com.enjoy.thread;

import java.util.concurrent.Semaphore;

/**
模拟6个车抢3个车位
 **/
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i=1; i<6; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢到车位");
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName()+"停车3秒后离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            },"线程"+i).start();
        }
    }
}

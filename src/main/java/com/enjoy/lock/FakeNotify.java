package com.enjoy.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * @Author wangjiteng
 * @Description //如果超过两个线程，用if循环会导致虚假唤醒
 * @Date 23:02 2020/5/31
 * @Param
 * @return
 **/
public class FakeNotify {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        new Thread(()->{
            for (int i = 1; i <= 5; i++){
                shareData.incre();
            }
        },"t1").start();

        new Thread(()->{
            for (int i = 1; i <= 5; i++){
                shareData.decre();
            }
        },"t2").start();

        new Thread(()->{
            for (int i = 1; i <= 5; i++){
                shareData.incre();
            }
        },"t3").start();

        new Thread(()->{
            for (int i = 1; i <= 5; i++){
                shareData.decre();
            }
        },"t4").start();
    }
}


class ShareData {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void incre(){
        lock.lock();
        try {
            while (number != 0) {
                System.out.println(Thread.currentThread().getName() +"incre await \t" + number);
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decre(){
        lock.lock();
        try {
            while (number == 0) { //if (number == 0)
                System.out.println(Thread.currentThread().getName() +"decre await \t" + number);
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

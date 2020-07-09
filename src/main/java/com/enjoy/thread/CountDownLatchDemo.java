package com.enjoy.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 CountDownLatch典型用法：1、某一线程在开始运行前等待n个线程执行完毕。将CountDownLatch的计数器初始化为new CountDownLatch(n)，
 每当一个任务线程执行完毕，就将计数器减1 countdownLatch.countDown()，当计数器的值变为0时，在CountDownLatch上await()的线程
 就会被唤醒。一个典型应用场景就是启动一个服务时，主线程需要等待多个组件加载完毕，之后再继续执行。

 CountDownLatch典型用法：2、实现多个线程开始执行任务的最大并行性。注意是并行性，不是并发，强调的是多个线程在某一时刻同时开始
 执行。类似于赛跑，将多个线程放到起点，等待发令枪响，然后同时开跑。做法是初始化一个共享的CountDownLatch(1)，将其计算器初始化
 为1，多个线程在开始执行任务前首先countdownlatch.await()，当主线程调用countDown()时，计数器变为0，多个线程同时被唤醒。
 **/
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        //type1();
        type2();
    }

    private static void type2() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i=1; i<6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "开始执行");
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                }
            },"线程"+i).start();
        }
        countDownLatch.countDown();
    }

    private static void type1() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i=1; i<6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"执行了");
                countDownLatch.countDown();
            },"线程"+i).start();
        }

        countDownLatch.await();
        System.out.println("都执行完了，主线程执行");
    }
}

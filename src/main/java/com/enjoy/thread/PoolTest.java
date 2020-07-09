package com.enjoy.thread;

import java.util.concurrent.*;

public class PoolTest {
    public static void main(String[] args) {
        Executor executor; //线程池顶级核心接口
        Executors executors = null; //是一个工具类，类似于 Collections。提供工厂方法来创建不同类型的线程池
        ExecutorService executorService; //ExecutorService 接口 对 Executor 接口进行了扩展，提供了返回 Future 对象，终止，关闭线程池等方法。

        ExecutorService executorService1 = executors.newCachedThreadPool();
        executorService1.submit(()->{
            System.out.println("thread ===");
        });

        BlockingQueue blockingQueue = new ArrayBlockingQueue(3);
        new ThreadPoolExecutor(2, 5, 100, TimeUnit.SECONDS,blockingQueue);

    }
}

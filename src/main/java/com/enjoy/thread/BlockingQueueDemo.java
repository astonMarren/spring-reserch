package com.enjoy.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
    1:抛出异常：插入add，移除remove，检查：element
    2：返回Boolean值：插入offer，移除poll，检查：peek
    3：阻塞：插入put，移除take，检查：不可用
    4：超时：offer(e,time,unit)，移除poll(time,unit)，检查：不可用
 **/
public class BlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);
        blockingQueue.add("a");
        blockingQueue.add("b");
        blockingQueue.add("c");
        //blockingQueue.add("d");
        System.out.println(blockingQueue.offer("e"));
    }
}

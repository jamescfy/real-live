package com.study.demo.learn.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author cfy
 * @Date 2021-4-6 下午 4:09
 * @Version 1.0
 *
 * 队列  先进先出
 * 阻塞队列
 * Collection -- Queue -- BlockingQueue
 *
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws Exception{
//        List list = null;
//        Queue queue = new ArrayBlockingQueue(10);
//        BlockingQueue blockingQueue = null;
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);
//        System.out.println(blockingQueue.add("a"));
//        System.out.println(blockingQueue.add("b"));
//        System.out.println(blockingQueue.add("c"));
//
//        System.out.println(blockingQueue.element());
//
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());

//        System.out.println(blockingQueue.offer("a"));
//        System.out.println(blockingQueue.offer("b"));
//        System.out.println(blockingQueue.offer("c"));
//        System.out.println(blockingQueue.offer("d"));
//
//        System.out.println(blockingQueue.peek());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());

//        blockingQueue.put("a");
//        blockingQueue.put("a");
//        blockingQueue.put("a");
////        blockingQueue.put("a");
//        System.out.println("------------------");
//
//        blockingQueue.take();
//        blockingQueue.take();
//        blockingQueue.take();
        System.out.println(blockingQueue.offer("a",2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a",2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a",2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a",2L, TimeUnit.SECONDS));

        BlockingQueue<String> blockingQueue1 = new SynchronousQueue<>();
    }
}

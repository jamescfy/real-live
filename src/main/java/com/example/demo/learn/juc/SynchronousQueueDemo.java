package com.example.demo.learn.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author cfy
 * @Date 2021-4-7 下午 4:42
 * @Version 1.0
 *
 * 同步队列
 */
public class SynchronousQueueDemo {

    public static void main(String[] args) throws InterruptedException{
        BlockingQueue<String> blockingQueue = new SynchronousQueue<String>();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName()+"\t put 1");
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName()+"\t put 2");
                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName()+"\t put 3");
                blockingQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();

        new Thread(() -> {
            try {
                try {
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println(Thread.currentThread().getName()+"\t "+blockingQueue.take());
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println(Thread.currentThread().getName()+"\t "+blockingQueue.take());
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println(Thread.currentThread().getName()+"\t "+blockingQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t2").start();
    }
}

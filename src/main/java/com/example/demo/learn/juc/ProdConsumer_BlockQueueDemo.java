package com.example.demo.learn.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author cfy
 * @Date 2021-4-29 下午 5:00
 * @Version 1.0
 */
class MySource{
    private volatile boolean flag = true;
    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;

    public MySource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProd() throws Exception{
        String data = null;
        boolean returnValue;
        while (flag){
            data = atomicInteger.incrementAndGet()+"";
            returnValue = blockingQueue.offer(data,2L, TimeUnit.SECONDS);
            if(returnValue){
                System.out.println(Thread.currentThread().getName()+"\t 插入队列"+data+"成功");
            } else {
                System.out.println(Thread.currentThread().getName()+"\t 插入队列"+data+"失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"\t 叫停，表示flag=false，生产结束");
    }

    public void stop() throws Exception{
        this.flag = false;
    }

    public void myConsumer() throws Exception{
        String result = null;
        while (flag){
            result = blockingQueue.poll(2L,TimeUnit.SECONDS);
            if(null == result || result.equalsIgnoreCase("")){
                flag = false;
                System.out.println(Thread.currentThread().getName()+"\t 超过两秒没取到，消费退出");
                System.out.println();
                System.out.println();
                return;
            }
            System.out.println(Thread.currentThread().getName()+"\t 消费队列"+result+"成功");
        }
    }
}
public class ProdConsumer_BlockQueueDemo {
    public static void main(String[] args) throws Exception{
        MySource mySource = new MySource(new ArrayBlockingQueue<>(10));
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"\t 生产线程启动");
            try {
                mySource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"prod").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"\t 消费线程启动");
            System.out.println();
            System.out.println();
            try {
                mySource.myConsumer();
                System.out.println();
                System.out.println();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"consumer").start();

        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("5秒钟后，线程叫停");
        mySource.stop();
    }
}

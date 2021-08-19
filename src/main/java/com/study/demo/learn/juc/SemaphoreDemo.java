package com.study.demo.learn.juc;

import java.sql.SQLOutput;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Author cfy
 * @Date 2021-4-6 下午 3:56
 * @Version 1.0
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i <= 5; i++){
                new Thread(() -> {
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName()+"\t 抢到车位");
                        try {
                            TimeUnit.SECONDS.sleep(3);
                            System.out.println(Thread.currentThread().getName()+"\t 停三秒后离开车位");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        semaphore.release();
                    }
                },String.valueOf(i)).start();

        }
    }
}

package com.example.demo.learn.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @Author cfy
 * @Date 2021-4-6 下午 2:30
 * @Version 1.0
 */
public class CountDownLatchDemo {

    public static void closeDoor(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i <= 5; i++){
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"\t 上完晚自习回了");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"\t 班长最后关门");
    }

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i <= 5; i++){
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"\t 国，别灭");
                countDownLatch.countDown();
            },CountryEnum.forEachContry(i).getRetMessage()).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"\t 秦帝国一统华夏");
    }
}

package com.study.demo.learn.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author cfy
 * @Date 2021-4-7 下午 5:05
 * @Version 1.0
 *
 * 一个初始值为0的变量，两个线程对其交替操作，一个加1一个减1，来6轮
 *
 * 线程         操作（方法）         资源类
 * 判断         干活                 通知
 * 防止虚假唤醒机制 (用while 不用if)
 *
 * synchronized                 和               Lock ReentrantLock区别？
 *  JVM层面 关键字                                 api层面的 类
 *  不需要主动释放锁                               需要手动释放锁
 *  等待不可中断                                   等待可以中断
 *  非公平锁                                       默认非公平  也可以公平
 *  没有                                           可以绑定多个条件的condition 可以精确唤醒
 *  针对对象                                       针对线程
 */
class ShareData{
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws Exception{
        lock.lock();
        try {
            // 判断
            while (number != 0){
                // 等待 不生产
                condition.await();
            }
            // 干活
            number++;
            System.out.println(Thread.currentThread().getName()+"\t "+number);
            System.out.println("----------------------------------------");
            // 通知唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() throws Exception{
        lock.lock();
        try {
            // 判断
            while (number == 0){
                // 等待 不生产
                condition.await();
            }
            // 干活
            number--;
            System.out.println(Thread.currentThread().getName()+"\t "+number);
            // 通知唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
public class Produtor_Consumer_TraditionDemo {

    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(() -> {
            for (int i = 0; i <= 5; i++){
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();

        new Thread(() -> {
            for (int i = 0; i <= 5; i++){
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"t2").start();

    }
}

package com.study.demo.learn.juc;

import java.util.concurrent.TimeUnit;

/**
 * @Author cfy
 * @Date 2021-5-8 下午 5:09
 * @Version 1.0
 * 死锁是指两个或两个以上的进程在执行过程中，因争夺资源而造成的一种互相等待的现象，若无外力干涉那他们都将无法推进下去
 */

class HoldLockThread implements Runnable{
    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"\t 自己持有"+lockA+"尝试获得"+lockB);
            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"\t 自己持有"+lockB+"尝试获得"+lockA);
            }
        }
    }
}
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new HoldLockThread(lockA,lockB),"threadA").start();
        new Thread(new HoldLockThread(lockB,lockA),"threadB").start();

        /**
         * linux ps -ef|grep java
         * windows 下的java运行程序 查看进程命令
         *          jps: jps -l
         *          jstack: jstack ****
         */
    }
}

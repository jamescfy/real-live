package com.example.demo.learn.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author cfy
 * @Date 2021-4-29 下午 4:51
 * @Version 1.0
 */
class shareResource{
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    public void print(){
        lock.lock();
        try {
            while (number!=1){
                condition1.await();
            }
            for (int i = 0; i <= 5; i++){
                System.out.println(Thread.currentThread().getName()+"\t "+i);
            }
            // 通知
            number = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
public class SynAndReentrantLockDemo {
}

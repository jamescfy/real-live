package com.example.demo.learn.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author cfy
 * @Date 2021-5-7 下午 3:45
 * @Version 1.0
 *
 * 并发 异步
 */

class MyThread1 implements Runnable{

    @Override
    public void run() {

    }
}

class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"\t "+"---------------callable");
        return 1024;
    }
}

public class CallableDemo {
    public static void main(String[] args) throws Exception{
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());

        new Thread(futureTask,"AAA").start();
        new Thread(futureTask,"BBB").start();

//        while (!futureTask.isDone()){
//        }

        int result = futureTask.get(); // 建议放大到最后，以免未跑完强求结果，会造成阻塞

        System.out.println(futureTask.get());

    }
}

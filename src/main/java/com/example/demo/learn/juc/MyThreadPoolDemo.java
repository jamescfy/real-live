package com.example.demo.learn.juc;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author cfy
 * @Date 2021-5-7 下午 4:55
 * @Version 1.0
 *
 * 线程池特点：
 * 线程复用
 * 控制最大并发数
 * 管理线程
 * 通过Executor框架实现
 * 第四种获得java多线程的方式
 *
 * 7大参数：
 * corePoolSize：线程池中的常驻核心线程数
 * maximumPoolSize: 线程池能容纳最大的同时线程执行数
 * keepAliveTime: 多余空闲线程的存活时间，当空闲时间达到存活时间时，销毁多余空闲线程直到黑心线程数
 * unit: keepAliveTime的单位
 * workQueue: 阻塞队列 任务队列
 * threadFactory: 生成线程池中工作线程的线程工厂  一般用默认即可
 * handler: 饱和拒绝策略  回退给调用者.CallerRunsPolicy()
 * 合理配置线程池数量：CPU密集型：一般公式：核数+1
 *                    IO密集型：一般：核数*2
 *                                  核数/（1-0.9）
 */
public class MyThreadPoolDemo {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2,5,
                1L,TimeUnit.SECONDS,new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardPolicy());
        try {
            for (int i = 0; i <= 10; i++){
                threadPool.execute(() ->{
                    System.out.println(Thread.currentThread().getName()+"\t "+"gan xiiiiiiiiiiii");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

    }

    public void threadPoolJDK(){
        System.out.println(Runtime.getRuntime().availableProcessors());
        List<String> list = Arrays.asList("a","b","c");
        // 不推荐使用
        ExecutorService executorService = Executors.newCachedThreadPool();
        try {
            for (int i = 0; i <= 5; i++){
                executorService.execute(() ->{
                    System.out.println(Thread.currentThread().getName()+"\t "+"gan xiiiiiiiiiiii");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

    }
}

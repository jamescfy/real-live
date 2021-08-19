package com.example.demo.learn.jvm;

import java.util.concurrent.TimeUnit;

/**
 * @Author cfy
 * @Date 2021-5-8 下午 5:32
 * @Version 1.0
 *
 * JVM体系
 * 类装载器
 * 线程私有
 * 线程公有 方法区 堆 -->GC
 * 引用计数法
 * 枚举根节点做可达性分析（根搜索路径）  GC Root
 *
 * JVM调优 参数设置
 * 标配参数 eg: java -version
 * X参数 eg: java -Xint -version
 * XX参数（重点）
 *   分 Boolean类型
 *              +表示开启
 *              -表示关闭
 *    KV设值类型
 *              -XX：属性key=属性值value
 *
 * 如何查看一个正在运行汇总的java程序，以及他的某个JVM是否开启，具体值是多少？
 * jps -l
 * jinfo -flag PrintGCDetails ***
 *
 * 盘点JVM参数
 * -XX：+PrintFlagsInitial
 */
public class JvmDemo {
    public static void main(String[] args) {
        System.out.println("xiiiiiiii");
        try {
            TimeUnit.MILLISECONDS.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

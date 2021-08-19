package com.example.demo.learn.jvm;

/**
 * @Author cfy
 * @Date 2021-5-10 下午 4:58
 * @Version 1.0
 *
 * 在java中，可作为GC Roots的对象：
 *
 * 1、虚拟机栈中引用的对象
 * 2、方法区中的类静态属性引用的对象
 * 3、方法区中常量引用的对象
 * 4、本地方法栈中JNI中引用的对象
 */
public class GCRootDemo {

    private byte[] bytes = new byte[100*1024*1024];

    public static void m1(){
        GCRootDemo t1 = new GCRootDemo();
        System.gc();
        System.out.println("第一次GC完成");
    }

    public static void main(String[] args) {
        m1();
    }
}

package com.example.demo.learn.jvm;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @Author cfy
 * @Date 2021-6-16 下午 3:37
 * @Version 1.0
 *
 * 引用
 * 强引用  出现了OOM也不会回收
 * 软引用  内存足够的时候不回收，内存不足的时候回收
 * 弱引用  不管内存是否够用，只要有gc，一律回收
 * 虚引用
 */
public class ReferenceDemo {

    public static void main(String[] args) {
//        strongReference();
//        softReference_Memory_Enough();
//        softReference_Memory_Not_Enough();
        weakReference();
    }

    private static void strongReference(){
        // 如此定义默认就是强引用
        Object obj1 = new Object();
        Object obj2 = obj1;
        obj1 = null;
        System.gc();
        System.out.println(obj2);
    }

    private static void softReference_Memory_Enough(){
        Object obj1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(obj1);
        System.out.println(obj1);
        System.out.println(softReference.get());

        obj1 =null;
        System.gc();;
        System.out.println(obj1);
        System.out.println(softReference.get());
    }

    /**
     * JVM配置,故意产生大对象并配置小的内存，让他内存不够用门，看软引用的回收情况
     */
    private static void softReference_Memory_Not_Enough(){
        Object obj1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(obj1);
        System.out.println(obj1);
        System.out.println(softReference.get());

        obj1 =null;

        try {
           byte[] bytes = new byte[30*1024*1024];
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(obj1);
            System.out.println(softReference.get());
        }
    }

    private static void weakReference(){
        Object obj1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(obj1);
        System.out.println(obj1);
        System.out.println(weakReference.get());

        obj1 = null;
        System.gc();
        System.out.println(obj1);
        System.out.println(weakReference.get());
    }
}

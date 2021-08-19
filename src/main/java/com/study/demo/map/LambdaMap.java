package com.study.demo.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author cfy
 * @Date 2021-8-19 下午 1:32
 * @Version 1.0
 */
public class LambdaMap {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap();
        map.put("k1","v1");
        map.put("k2","v2");
        map.put("k3","v3");
        map.put("k4","v4");
        map.put("k5","v5");
        map.put("k6","v6");
       // 1、keySet()
        System.out.println("-----------------FIRST----------------------");
        for (Object key : map.keySet()){
            System.out.println("map.get("+key+") = "+map.get(key));
        }
        System.out.println("-----------------JAVA8----------------------");
        map.keySet().forEach(key -> System.out.println(key + "=" + map.get(key)));
        // 2、 entrySet()的iterator
        System.out.println("-----------------SECOND----------------------");
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey() +"="+entry.getValue() );
        }
        System.out.println("-----------------JAVA8----------------------");
        map.entrySet().iterator().forEachRemaining(item -> System.out.println(item.getKey() + "=" + item.getValue()));
        // 3、entrySet()
        System.out.println("-----------------THIRD----------------------");
        for(Map.Entry entry : map.entrySet()){
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
        System.out.println("-----------------JAVA8----------------------");
        map.entrySet().forEach(entry -> System.out.println(entry.getKey()+"="+entry.getValue()));
        // 4、values() 只能遍历value 不能遍历key
        System.out.println("-----------------FORTH----------------------");
        for (String value: map.values()){
            System.out.println(value);
        }
        System.out.println("-----------------JAVA8----------------------");
        map.values().forEach(System.out::println);
        // 5、java8独有
        System.out.println("-----------------FIFTH----------------------");
        map.forEach((k,v)-> System.out.println(k + "=" + v));

    }
}

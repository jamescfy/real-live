package com.example.demo.learn.juc;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @Author cfy
 * @Date 2021-4-15 下午 4:32
 * @Version 1.0
 */
public class StreamDemo {

    public static void main(String[] args) {
        Random random = new Random();
//        random.ints().limit(10).sorted().forEach(System.out::println);
        List<Integer> numbers = Arrays.asList(2,6,9,9,8,5,666,888,2333);
        IntSummaryStatistics summaryStatistics = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println(summaryStatistics.getMax());
        System.out.println(summaryStatistics.getAverage());
        System.out.println(summaryStatistics.getCount());
        System.out.println(summaryStatistics.getMin());
        System.out.println(summaryStatistics.getSum());
        System.out.println(summaryStatistics.toString());

        List<String> strings = Arrays.asList("abc","","bc","efg","abcd","","jkl");
        System.out.println("列表："+strings);
        System.out.println("--------------------------java8---------------------------");
        Long count = strings.stream().filter(s -> s.isEmpty()).count();
        System.out.println("空串数量："+count);
        count = strings.stream().filter(s -> s.length()==3).count();
        System.out.println("字符串长度为3的数量："+count);
        List<String> list = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        System.out.println("去除掉空串之后的集合："+list);
        String collect = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining("+ "));
        System.out.println("合并后的字符串："+collect);
        System.out.println("----------------------------------------------");
        List<Integer> integers = Arrays.asList(3,6,6,9,6,8,2,3,7,6,1,9);
        List<Integer> integerList = integers.stream().map(integer -> integer * integer).distinct().collect(Collectors.toList());
        System.out.println("平方后的集合："+integerList);
        long count1 = strings.parallelStream().filter(s -> s.isEmpty()).count();
        System.out.println("空串的数量："+ count1);
    }
}

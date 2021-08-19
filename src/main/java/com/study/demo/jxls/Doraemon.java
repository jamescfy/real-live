package com.study.demo.jxls;

import lombok.Data;

import java.util.List;

/**
 * @Author cfy
 * @Date 2021-5-27 下午 4:41
 * @Version 1.0
 */
@Data
public class Doraemon {
    private String name; // 哆啦A梦的名字
    private List<Tool> tools; // 拥有的道具，这是一个链表，存放的是Tool类

    public Doraemon(String name, List<Tool> tools) {
        super();
        this.name = name;
        this.tools = tools;
    }

    public Doraemon() {
    }
}

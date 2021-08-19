package com.study.demo.jxls;

import lombok.Data;

/**
 * @Author cfy
 * @Date 2021-5-27 下午 4:30
 * @Version 1.0
 */
@Data
public class Tool {
    private String toolName; // 道具名
    private String toolFunction; // 道具功能

    public Tool(String toolName, String toolFunction) {
        super();
        this.toolName = toolName;
        this.toolFunction = toolFunction;
    }

    public Tool() {
    }
}

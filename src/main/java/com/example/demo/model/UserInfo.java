package com.example.demo.model;

import com.terran4j.commons.api2doc.annotations.ApiComment;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author cfy
 * @Date 2021-8-6 下午 3:40
 * @Version 1.0
 */
@Data
@ApiComment(value = "用户信息实体类")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiComment(value = "用户id",sample = "1")
    private String userId;

    @ApiComment(value = "用户姓名",sample = "三三")
    private String userName;
}

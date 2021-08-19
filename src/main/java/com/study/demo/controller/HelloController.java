package com.study.demo.controller;

import com.study.demo.model.UserInfo;
import com.study.demo.service.HelloService;
import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author cfy
 * @Date 2021-8-6 下午 2:39
 * @Version 1.0
 */

@Api2Doc(id = "UserController", name = "用户处理接口")
@ApiComment(seeClass = UserInfo.class)
@RestController
@RequestMapping(value = "/user")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @Api2Doc(order = 1)
    @ApiComment("查询用户列表")
    @RequestMapping(name="查询用户列表",value = "/users",method = RequestMethod.GET)
    public List<UserInfo> helloSpringBoot() {
        return helloService.sayHello();
    }

}

package com.example.demo.service.impl;

import com.example.demo.mapper.UserInfoMapper;
import com.example.demo.model.UserInfo;
import com.example.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author cfy
 * @Date 2021-8-6 下午 2:42
 * @Version 1.0
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> sayHello() {
        return userInfoMapper.selectUserInfo();
    }
}

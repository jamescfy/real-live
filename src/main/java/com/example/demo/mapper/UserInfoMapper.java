package com.example.demo.mapper;


import com.example.demo.model.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author cfy
 * @Date 2021-8-6 下午 4:54
 * @Version 1.0
 */
@Repository
public interface UserInfoMapper {
    /**
     * 查询用户信息
     * @return
     */
    List<UserInfo> selectUserInfo();
}

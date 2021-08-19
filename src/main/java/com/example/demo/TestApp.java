package com.example.demo;

/**
 * @Author cfy
 * @Date 2021-8-5 下午 5:09
 * @Version 1.0
 */

import com.terran4j.commons.api2doc.config.EnableApi2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 应用启动入口
 *
 * @author cfy
 * @date 2018/4/26
 */
@MapperScan("com.example.demo.mapper")
@EnableApi2Doc
@SpringBootApplication
public class TestApp {
    public static void main(String[] args) {
        SpringApplication.run(TestApp.class, args);
    }
}

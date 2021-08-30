package com.study.demo;

/**
 * @Author cfy
 * @Date 2021-8-5 下午 5:09
 * @Version 1.0
 */

import com.terran4j.commons.api2doc.config.EnableApi2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 应用启动入口
 * @author cfy
 * @date 2018/4/26
 */
@MapperScan("com.study.demo.mapper")
@EnableApi2Doc
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan("com.study.demo")
@SpringBootApplication
public class TestApp {

    public static void main(String[] args) {

        // 返回我们的IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(TestApp.class, args);

        //查看容器里面的组件
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for(String name : beanDefinitionNames){
//            System.out.println(name);
        }
    }
}

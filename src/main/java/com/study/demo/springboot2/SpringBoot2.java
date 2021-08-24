package com.study.demo.springboot2;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationImportSelector;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * @Author cfy
 * @Date 2021-8-19 下午 5:06
 * @Version 1.0
 * 逻辑线 原理
 * 第二季：响应式编程
 * 版本帝
 */
public class SpringBoot2 {
    // https://www.yuque.com/atguigu/springboot
    // java8 maven3.3以上
    // 默认接口实现
    // stater依赖、自动配置spring
    // 官方文档
    // 入门---------------------------------------------------------------
    // 依赖管理
        // 1、父项目parent 几乎声明了所有常用的jar的版本号，自动版本仲裁机制，也可以自定义版本 ->重写版本
        // 2、starter场景启动器
        // 3、版本仲裁
    //  自动配置
        // 1、引入依赖之后，会自动配好常用的组件，引入了的场景才会自动配置
        // 2、主程序所在的包及其下所有的子包的组件都会扫描进去
        // 3、spring-boot-autoconfigure
    // 组件 给容器中添加组件  @Configuration  默认单实例  ProxyBeanMethods= true/false   组件依赖
    // @Import  自动创建出指定的组件，默认组件名称为全类名
    // @Conditional 条件装配注解
    // @ImportResource  导入spring的配置文件
    // 配置绑定
       // @ConfigurationProperties(prefix = "")  + @Component  只有在容器里的组件，才能拥有springBoot提供的功能
       // @EnableConfigurationProperties() + @ConfigurationProperties
    // 自动配置原理
        // 启动类注解 -> @SpringBootConfiguration @EnableAutoConfiguration  @ComponentScan
        // @SpringBootConfiguration -->  代表当前是一个配置类
        // @ComponentScan           -->  指定扫描哪些包
        // @EnableAutoConfiguration -->   @AutoConfigurationPackage  + @Import(AutoConfigurationImportSelector.class)  127
                                        //按照条件装配规则按需配置
    //


}

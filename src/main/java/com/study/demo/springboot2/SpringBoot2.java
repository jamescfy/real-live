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
    //  默认会在底层配置所有的组件，但是用户配置了就以用户配的优先
    // 总结：
        // 1、SpringBoot会先加载所有有的自动配置类  ***AutoConfiguration
        // 2、每个自动配置类按照条件选择生效
        // 3、生效的配置类就会给容器中装配很多的组件
        // 4、只要容器中有这些组件，相当于这些功能就有了
        // 5、只要用户有自己配置的，就以用户配置的优先 || 用户修改配置文件的值
    // 引入场景依赖 ---> 查看自动配置了哪些（选） debug=true ---> 修改配置或者自定义组件或者自定义器***Customizer---> --->
    //======================================================================================================
    // 开发小技巧
        // lombok  @ToString  @ToString
                    //@Data
                    //@NoArgsConstructor
                    //@AllArgsConstructor
                    //@EqualsAndHashCode
                    //@Slf4j
        // devtools 热部署 ctrl+F9 重新编译
        // spring Initailizr 向导
        // StringUtils.hasLength()
   // 核心  ------------------------------------------------------------------------------------------
    // 配置文件
    // web开发
        // SpringMVC
            //支持webjars
        /*
         *  欢迎页
         *  图标
         *  静态资源配置原理： WebMvcAutoConfiguration生效  spring.mvc  spring.resource handlerMapping处理器映射
         *  请求参数处理：
         *      1、请求映射  hiddenHttpMethod
         *      2、请求映射原理 dispatcherServlet  handlerMapping
         *              doGet -> doService -. doDispatch
         *          所有的请求映射都在handlerMapping中，请求进来，挨个尝试所有的handlerMapping看是否有请求信息，如果有
         *          就找到了请求对应handler，如果没有就继续下一个循环handlerMapping，我们需要自定义的映射处理也可以自己给
         *          容器中放handlerMapping
         *      3、参数
         *          基本注解：
         *              @PathVariable(" ")  @PathVariable Map<String，String>
         *              @RequestHeader(" ")
         *              @RequestParam(" ")
         *              @CookieValue(" ")
         *              @RequestBody(" ") ---POST 请求体的数据
         *              @RequestAttribute(" ") ---获取request域属性
         *              @MatrixVariable(" ") ------矩阵变量
        */

}

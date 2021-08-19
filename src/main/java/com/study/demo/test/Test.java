package com.study.demo.test;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author cfy
 * @Date 2021-8-11 下午 3:59
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("title", "关于生成word的步骤介绍");
        List<Map<String, Object>> versionList = new ArrayList<>();
        //这只是一个demo，不必较真
        for (int i = 0; i < 5; i++) {
            Map<String, Object> version = new HashMap<>();
            version.put("author", "作者" + (i + 1));
            version.put("date", "2020-06-0" + (i + 1));
            version.put("version", "v1." + i);
            versionList.add(version);
        }
        dataMap.put("versionList", versionList);
        dataMap.put("firstStep", "完成word模板");
//        dataMap.put("secondStep", "将word另存为xml");
//        dataMap.put("thirdStep", "打开xml将其格式化，调整删除过程中错乱的参数");
//        dataMap.put("fourthStep", "将xml文件后缀修改为ftl");
//        dataMap.put("fifthStep", "组织数据");
//        dataMap.put("sixthStep", "生成word");


        try {

            Configuration configure = new Configuration();
            configure.setDefaultEncoding("utf-8");

            //加载需要装填的模板
            Template template=null;

            //设置模板装置方法和路径，
            String path = Thread.currentThread().getContextClassLoader().getResource("word模板.ftl").getPath();
//            configure.setDirectoryForTemplateLoading(new File("D:\\workspace\\swagger-doc\\swagger-doc\\src\\main\\resources\\templates"));
            configure.setDirectoryForTemplateLoading(new File("D:\\workspace\\swagger-doc\\swagger-doc\\src\\main\\resources\\templates"));


            //设置异常处理器
            configure.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);

            //定义Template对象，注意模板类型名字与downloadType要一致
            template=configure.getTemplate("word模板.ftl");

            File outFile=new File("D:\\workspace\\swagger-doc\\swagger-doc\\src\\main\\resources\\templates\\word模板生成demo.doc");
            Writer out=null;
            //指定编码表需使用转换流，转换流对象要接收一个字节输出流
            out=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"));
            template.process(dataMap, out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }


    }

}

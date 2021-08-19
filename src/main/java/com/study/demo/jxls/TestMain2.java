package com.study.demo.jxls;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author cfy
 * @Date 2021-5-27 下午 4:38
 * @Version 1.0
 */
public class TestMain2 {
    public static void main(String[] args) throws Exception {
        String templatePath = "D:\\workspace\\test\\demo\\src\\main\\resources\\template3.xlsx";
        OutputStream os = new FileOutputStream("D:\\workspace\\test\\demo\\src\\main\\resources\\output3.xlsx");

        Tool tool1 = new Tool("任意门","想去哪就去哪");
        Tool tool2 = new Tool("竹蜻蜓","想飞哪就飞哪");
        Tool tool3 = new Tool("空气炮","空气炮");
        Tool tool4 = new Tool("翻译饼干","翻译饼干");

        List<Doraemon> list = new ArrayList<Doraemon>();

        //制作一个哆啦A梦
        Doraemon doraemon1 = new Doraemon();
        //制作一号哆啦A梦的道具
        List<Tool> toolList1 = new ArrayList<Tool>();
        toolList1.add(tool1);
        toolList1.add(tool2);
        //设定一号哆啦A梦信息
        doraemon1.setName("哆啦A梦一号");
        doraemon1.setTools(toolList1);

        //制作一个哆啦A梦
        Doraemon doraemon2 = new Doraemon();
        //制作二号哆啦A梦的道具
        List<Tool> toolList2 = new ArrayList<Tool>();
        toolList2.add(tool3);
        toolList2.add(tool4);
        toolList2.add(tool1);
        //设定二号哆啦A梦信息
        doraemon2.setName("哆啦A梦二号");
        doraemon2.setTools(toolList2);

        list.add(doraemon1);
        list.add(doraemon2);

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("data", list);

        JxlsUtils.exportExcel(templatePath, os, model);
        os.close();
        System.out.println("完成");
    }
}

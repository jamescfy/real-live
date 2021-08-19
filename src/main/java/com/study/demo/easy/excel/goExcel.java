package com.study.demo.easy.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cfy
 * @Date 2021-5-19 下午 4:43
 * @Version 1.0
 */
public class goExcel {
    public static void main(String[] args) {
        // 模板注意 用{} 来表示你要用的变量 如果本来就有"{","}" 特殊字符 用"\{","\}"代替
//        String templateFileName = "D:\\workspace\\test\\demo\\src\\main\\resources\\template.xlsx";
//        // 结果输出路径
//        String fileName = "D:\\workspace\\test\\demo\\src\\main\\resources\\output.xlsx";
////        String templateFileName =
////                templatePath + "demo" + File.separator + "fill" + File.separator + "simple.xlsx";
////
////        // 方案1 根据对象填充
////        String fileName = outputPath + "simpleFill" + System.currentTimeMillis() + ".xlsx";
//        // 这里 会填充到第一个sheet， 然后文件流会自动关闭
//        FillData fillData = new FillData();
//        fillData.setName("张三");
//        fillData.setNumber(5.2);
//        EasyExcel.write(fileName).withTemplate(templateFileName).sheet().doFill(fillData);

//        // 方案2 根据Map填充
//        fileName = TestFileUtil.getPath() + "simpleFill" + System.currentTimeMillis() + ".xlsx";
//        // 这里 会填充到第一个sheet， 然后文件流会自动关闭
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("name", "张三");
//        map.put("number", 5.2);
//        EasyExcel.write(fileName).withTemplate(templateFileName).sheet().doFill(map);
        // 模板注意 用{} 来表示你要用的变量 如果本来就有"{","}" 特殊字符 用"\{","\}"代替
        // 填充list 的时候还要注意 模板中{.} 多了个点 表示list
        String templateFileName = "D:\\workspace\\test\\demo\\src\\main\\resources\\template2.xlsx";
//        // 结果输出路径
        String fileName = "D:\\workspace\\test\\demo\\src\\main\\resources\\output2.xlsx";

        // 方案1 一下子全部放到内存里面 并填充
//        String fileName = TestFileUtil.getPath() + "listFill" + System.currentTimeMillis() + ".xlsx";
        // 这里 会填充到第一个sheet， 然后文件流会自动关闭
//        EasyExcel.write(fileName).withTemplate(templateFileName).sheet().doFill(data());

        // 方案2 分多次 填充 会使用文件缓存（省内存）
//        fileName = TestFileUtil.getPath() + "listFill" + System.currentTimeMillis() + ".xlsx";
        ExcelWriter excelWriter = EasyExcel.write(fileName).withTemplate(templateFileName).build();
        WriteSheet writeSheet = EasyExcel.writerSheet().build();
        List<FillData> list = new ArrayList<>();
        for (int i = 0; i <= 5; i++){
            FillData fillData = new FillData();
            fillData.setName("张三");
            fillData.setNumber(5.2);
            list.add(fillData);
        }
        excelWriter.fill(list, writeSheet);
//        excelWriter.fill(data(), writeSheet);
        // 千万别忘记关闭流
        excelWriter.finish();
        // 模板注意 用{} 来表示你要用的变量 如果本来就有"{","}" 特殊字符 用"\{","\}"代替
        // {} 代表普通变量 {.} 代表是list的变量 {前缀.} 前缀可以区分不同的list
//        String templateFileName =
//                TestFileUtil.getPath() + "demo" + File.separator + "fill" + File.separator + "composite.xlsx";
//
//        String fileName = TestFileUtil.getPath() + "compositeFill" + System.currentTimeMillis() + ".xlsx";
//        ExcelWriter excelWriter = EasyExcel.write(fileName).withTemplate(templateFileName).build();
//        WriteSheet writeSheet = EasyExcel.writerSheet().build();
//        FillConfig fillConfig = FillConfig.builder().direction(WriteDirectionEnum.HORIZONTAL).build();
////         如果有多个list 模板上必须有{前缀.} 这里的前缀就是 data1，然后多个list必须用 FillWrapper包裹
//        ExcelWriter list1 = excelWriter.fill(new FillWrapper("list1", list), fillConfig, writeSheet);
////        excelWriter.fill(new FillWrapper("list", list), fillConfig, writeSheet);
//        excelWriter.fill(new FillWrapper("list2", list), writeSheet);
////        excelWriter.fill(new FillWrapper("list", list), writeSheet);
//        excelWriter.fill(new FillWrapper("list3", list), writeSheet);
//        excelWriter.fill(new FillWrapper("list3", list), writeSheet);

//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("date", "2019年10月9日13:28:28");
//        excelWriter.fill(map, writeSheet);
//
//        // 别忘记关闭流
//        excelWriter.finish();
    }

    private static List<FillData> data() {
        List<FillData> list = new ArrayList<>();
        for (int i = 0; i <= 5; i++){
            FillData fillData = new FillData();
            fillData.setName("张三");
            fillData.setNumber(5.2);
            list.add(fillData);
        }
        return list;
    }
}

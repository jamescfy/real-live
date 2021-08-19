package com.example.demo.easy.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author cfy
 * @Date 2021-5-19 下午 4:37
 * @Version 1.0
 */
public class fuckExcel {
    public static void main(String[] args) {
        // 模板注意 用{} 来表示你要用的变量 如果本来就有"{","}" 特殊字符 用"\{","\}"代替
        // {} 代表普通变量 {.} 代表是list的变量
        String templatePath = "D:\\workspace\\test\\demo\\src\\main\\resources\\dd.xlsx";
        // 结果输出路径
        String outputPath = "D:\\workspace\\test\\demo\\src\\main\\resources\\output.xlsx";
        String templateFileName =
                "111";

        String fileName = "222";
//        ExcelWriter excelWriter = EasyExcel.write(fileName).withTemplate(templateFileName).build();
        ExcelWriter excelWriter = EasyExcel.write(new File(outputPath)).withTemplate(new File(templatePath)).build();
        WriteSheet writeSheet = EasyExcel.writerSheet().build();
        // 这里注意 入参用了forceNewRow 代表在写入list的时候不管list下面有没有空行 都会创建一行，然后下面的数据往后移动。默认 是false，会直接使用下一行，如果没有则创建。
        // forceNewRow 如果设置了true,有个缺点 就是他会把所有的数据都放到内存了，所以慎用
        // 简单的说 如果你的模板有list,且list不是最后一行，下面还有数据需要填充 就必须设置 forceNewRow=true 但是这个就会把所有数据放到内存 会很耗内存
        // 如果数据量大 list不是最后一行 参照下一个
        FillConfig fillConfig = FillConfig.builder().forceNewRow(Boolean.TRUE).build();
//        excelWriter.fill(data(), fillConfig, writeSheet);
//        excelWriter.fill(data(), fillConfig, writeSheet);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("date", "2019年10月9日13:28:28");
        map.put("total", 1000);
        excelWriter.fill(map, writeSheet);
        excelWriter.finish();
    }
}

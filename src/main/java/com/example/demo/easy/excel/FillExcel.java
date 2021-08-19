package com.example.demo.easy.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author cfy
 * @Date 2021-5-17 下午 5:50
 * @Version 1.0
 */
public class FillExcel {


public static void main(String[] args) {
    List<String> header = new ArrayList<>(1);
    header.add("站点");
    String templatePath = "dd.xlsx";
    // 结果输出路径
    String outputPath = "D:\\workspace\\test\\demo\\src\\main\\resources\\output.xlsx";
    try {
//        ExcelWriter writer = EasyExcel.write(new File(outputPath)).withTemplate(new File(templatePath)).build();
        ClassPathResource classPathResource = new ClassPathResource(templatePath);
        ExcelWriter excelWriter = null;
        try {
            excelWriter = EasyExcel.write(new File(outputPath))
                    .withTemplate(classPathResource.getInputStream())
                    .build();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        WriteSheet writeSheet = EasyExcel.writerSheet().build();
        List<String> data = Arrays.asList("aa", "bb");
        excelWriter.fill(data, writeSheet);
        excelWriter.fill(header, writeSheet);
        excelWriter.finish();
    } catch (Exception e) {
//        log.error("", e);
        throw new RuntimeException("环境风险放射性数据导出异常");
    }
}
public void fillExcel() {
//    Map<String, String> header = new HashMap<>(4);
//    List<RadioactivityVO> data = new ArrayList<>();
//    // 这里代码在准备需要填充的数据 list 和 header, 这里不做展示了
//    // 模板读取
//    String tempFileName = "环境风险放射性数据导出表_" + System.currentTimeMillis() + ".xlsx";
//    String exportName = "环境风险放射性数据导出表.xlsx";
//
//    try {
//        ClassPathResource classPathResource = new ClassPathResource("templates/radioactivity_template.xlsx");
//        ExcelWriter excelWriter = null;
//        try {
//            excelWriter = EasyExcel.write(tempFileName)
//                    .withTemplate(classPathResource.getInputStream())
//                    .build();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        WriteSheet writeSheet = EasyExcel.writerSheet().build();
//        excelWriter.fill(data, writeSheet);
//        excelWriter.fill(header, writeSheet);
//        excelWriter.finish();
//        return FileUtil.buildResponse(new File(tempFileName), exportName); // 返回一个ResponseEntity<byte[]>
//    } catch (Exception e) {
////        log.error("", e);
//        throw new RuntimeException("环境风险放射性数据导出异常");
//    }
}

}

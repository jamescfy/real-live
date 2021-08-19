package com.example.demo.easy.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.*;

/**
 * @Author cfy
 * @Date 2021-5-17 下午 6:04
 * @Version 1.0
 */
public class MainExcel {

        public static void main(String[] args)
        {
            // 1. 路径定义
            // 输入模板路径
            String templatePath = "D:\\workspace\\test\\demo\\src\\main\\resources\\dd.xlsx";
            // 结果输出路径
            String outputPath = "D:\\workspace\\test\\demo\\src\\main\\resources\\output.xlsx";

            // 2. 真实的模拟数据
            List<RadioactivityVO> list = dataList();

            // 3. 数据写出
            ExcelWriter writer = EasyExcel.write(new File(outputPath)).withTemplate(new File(templatePath)).build();
            // 3.1 操作第一个sheet(记得注册自定义的CellWriteHandler)
            WriteSheet sheet = EasyExcel.writerSheet(0).registerWriteHandler(new CustomCellWriteHandler()).build();
            // 3.2 填充列表数据
            writer.fill(list, FillConfig.builder().forceNewRow(Boolean.TRUE).build(), sheet);
            // 3.3 填充其它动态信息
            Map<String, Object> extra = new LinkedHashMap<>();
            // 单位：10%
            extra.put("taxRate", 10);

            //3.4 设置强制计算公式：不然公式会以字符串的形式显示在excel中
            Workbook workbook = writer.writeContext().writeWorkbookHolder().getWorkbook();
            workbook.setForceFormulaRecalculation(true);

            // 3.5 数据刷新
            writer.fill(extra, sheet).finish();

            System.out.println("over");

        }

        /**
         * 模拟的数据列表
         * @return 列表
         */
        private static List<RadioactivityVO> dataList()
        {
            ArrayList<RadioactivityVO> list = new ArrayList<>();Arrays.asList("aa","bb");
//            for (int i = 1; i <= 20; i++)
//            {
//                RadioactivityVO demoData = new RadioactivityVO();
//                demoData.setAValue("202001180000" + i);
////                demoData.setGoodName("商品名称" + i);
////                demoData.setGoodPrice(new BigDecimal(i));
////                demoData.setNum(i);
//
//                list.add(demoData);
//            }
            return list;
        }

        static class CustomCellWriteHandler implements CellWriteHandler
        {
            private static final Logger LOGGER = LoggerFactory.getLogger(CustomCellWriteHandler.class);

            @Override
            public void beforeCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row,
                                         Head head, Integer columnIndex, Integer relativeRowIndex, Boolean isHead)
            {

            }

            @Override
            public void afterCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Cell cell,
                                        Head head, Integer relativeRowIndex, Boolean isHead)
            {

            }

            public void afterCellDataConverted(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, CellData cellData, Cell cell, Head head, Integer integer, Boolean aBoolean)
            {

            }

            @Override
            public void afterCellDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder,
                                         List<CellData> cellDataList, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead)
            {
                // 这里可以对cell进行任何操作
                System.out.println("进入第" +  cell.getRowIndex() + "行,第" + cell.getColumnIndex() + "列数据...");
                if (cell.getRowIndex() >= 4 && 4 == cell.getColumnIndex())
                {
                    // 税价 = 含税单价 * 数量 * 税率
                    // 以第4行数据为例：税价 = C5*D5*$C$1
                    int actualCellRowNum = cell.getRowIndex() + 1;
                    cell.setCellFormula("C" + actualCellRowNum +"*D" + actualCellRowNum + "*$C$1");
                    System.out.println("第" +  cell.getRowIndex() + "行,第" + cell.getColumnIndex() + "税价写入公式完成");

                }

                if (cell.getRowIndex() >= 4 && 5 == cell.getColumnIndex())
                {
                    // 总价 = 含税单价 * 数量
                    // 以第4行数据为例：税价 = C5*D5
                    int actualCellRowNum = cell.getRowIndex() + 1;
                    cell.setCellFormula("C" + actualCellRowNum + "*D" + actualCellRowNum);
                    System.out.println("第" +  cell.getRowIndex() + "行,第" + cell.getColumnIndex() + "总价写入公式完成");
                }
            }
        }

    }

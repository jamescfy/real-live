package com.example.demo.easy.excel;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author cfy
 * @Date 2021-4-1 下午 4:21
 * @Version 1.0
 */
public class ExcelUtil {

    private static Sheet initSheet;

    static {
        initSheet = new Sheet(1, 0);
        initSheet.setSheetName("sheet");
    }

    /**
     *
     * @param response
     * @param data
     * @param fileName
     * @param <T>
     */
    public static <T> void createExcelStreamMutilByEaysExcel(HttpServletResponse response, List<T> data,
                                                             String fileName) {
        try {
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            ServletOutputStream out = response.getOutputStream();
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
            initSheet.setClazz((Class<? extends BaseRowModel>) data.get(0).getClass());
            writer.write(data, initSheet);
            writer.finish();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<OrderExcelModel> data = new ArrayList<>();
        OrderExcelModel excelModel = new OrderExcelModel();
        excelModel.setOrderSerialNo("orderSerialNo");
        excelModel.setTransferType("22");
        excelModel.setEffective("33");
        excelModel.setPayStatus("66");
        data.add(excelModel);
//        createExcelStreamMutilByEaysExcel(new HttpServletResponse, data, "订单列表");
    }
}

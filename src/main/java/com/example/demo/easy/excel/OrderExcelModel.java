package com.example.demo.easy.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderExcelModel extends BaseRowModel {

	@ExcelProperty(value = "订单编号", index = 0)
	@ColumnWidth(15)
	private String orderSerialNo;

	@ColumnWidth(15)
	@ExcelProperty(value = "订单类型", index = 1)
	private String transferType;

	@ColumnWidth(15)
	@ExcelProperty(value = "订单状态", index = 2)
	private String effective;

	@ColumnWidth(15)
	@ExcelProperty(value = "交易状态", index = 3)
	private String payStatus;

	@ColumnWidth(15)
	@ExcelProperty(value = "金额(元)", index = 4)
	private BigDecimal priceAmount;

	@ColumnWidth(20)
	@DateTimeFormat("yyyy-MM-dd HH:mm:ss")
	@ExcelProperty(value = "服务日期", index = 5)
	private Date predictArriveTime;

}

//package com.example.demo.easy.excel;
//
//import com.alibaba.excel.EasyExcel;
//import lombok.val;
//import org.apache.poi.ss.formula.functions.T;
//
//import java.util.List;
//
///**
// * @Author cfy
// * @Date 2021-5-28 上午 9:29
// * @Version 1.0
// */
//public class TrueFillExcel {
//    public static void main(String[] args) {
//        fun<T:Any> fillExcel(response: HttpServletResponse, data:List<T>, fileName: String?){
//            response.setContentType("application/vnd.ms-excel")
//            response.setCharacterEncoding("utf-8")
//            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"))
//            val templateFileName = Thread.currentThread().getContextClassLoader().getResource("template.xlsx").getPath()
//            try {
//                var excelWriter: ExcelWriter? = null
//                val out: ServletOutputStream = response.getOutputStream()
//                excelWriter= EasyExcel.write(out).withTemplate(templateFileName).build()
//                val writeSheet = EasyExcel.writerSheet().build()
//                excelWriter!!.fill(data, writeSheet)
//                excelWriter.finish()
//            } catch (e: Exception) {
//                throw ResultException("用户导出异常")
//            }
//        }
//    }
//}

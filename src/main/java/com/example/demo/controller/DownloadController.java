//package com.example.demo.controller;
//
//import com.swagger.word.model.ApiDoc;
//import com.swagger.word.model.ApiDocSon;
//import freemarker.template.Configuration;
//import freemarker.template.Template;
//import freemarker.template.TemplateException;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.*;
//import java.net.URLEncoder;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//public class DownloadController {
//
////    @RequestMapping("down")
//    public void download(/*WeeklyTask weeklyTask, */HttpServletResponse response) {
//        try {
//            //加入模板的数据
//            Map<String, Object> data = new HashMap<>();
//            List<ApiDoc> list = new ArrayList();
//            List<ApiDocSon> listSon = new ArrayList();
//            listSon.add(new ApiDocSon("接口1-1"));
//            listSon.add(new ApiDocSon("接口1-2"));
//            listSon.add(new ApiDocSon("接口1-3"));
//            listSon.add(new ApiDocSon("接口1-4"));
//            listSon.add(new ApiDocSon("接口1-5"));
//            list.add(new ApiDoc("接口1",listSon));
//            list.add(new ApiDoc("接口2"));
//            list.add(new ApiDoc("接口3"));
//            list.add(new ApiDoc("接口4"));
//            list.add(new ApiDoc("接口5"));
//            data.put("list", list);
//            String outFileName = "title.docx";
//            //模板相对路径
//            String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
//            path = path + "templates/";
//            File outFile = createDoc(data, outFileName, path, "title.ftl");
//            if (null != outFile) {
//                response.reset();
//                response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(outFile.getName(), "UTF-8"));
//                //获取文件输入流
//                InputStream in = new FileInputStream(outFile);
//                byte[] buffer = new byte[1024];
//                OutputStream out = response.getOutputStream();
//                int len = 0;
//                while ((len = in.read(buffer)) > 0) {
//                    //将缓冲区的数据输出到客户端浏览器
//                    out.write(buffer, 0, len);
//                }
//                in.close();
//                out.close();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    public static File createDoc(Map<String, Object> dataMap, String outFileName, String templatePath, String templateFileName) throws IOException {
//        //设置模本装置方法和路径,FreeMarker支持多种模板装载方法。可以重servlet，classpath，数据库装载，
//        Configuration configuration = new Configuration();
//        //设置null转为空串
//        configuration.setClassicCompatible(true);
//
//        configuration.setDefaultEncoding("UTF-8");
//        configuration.setDirectoryForTemplateLoading(new File(templatePath));
//        Template t = null;
//        try {
//            //test.ftl为要装载的模板
//            t = configuration.getTemplate(templateFileName, "UTF-8");
//            t.setOutputEncoding("UTF-8");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //输出文档路径及名称
//        File outFile = new File(outFileName);
//        if (!outFile.exists()) {
//            outFile.createNewFile();
//        }
//        Writer out = null;
//        FileOutputStream fos = null;
//        try {
//            fos = new FileOutputStream(outFile);
//            OutputStreamWriter oWriter = new OutputStreamWriter(fos, "UTF-8");
//            //这个地方对流的编码不可或缺，使用main（）单独调用时，应该可以，但是如果是web请求导出时导出后word文档就会打不开，并且包XML文件错误。主要是编码格式不正确，无法解析。
//            // out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
//            out = new BufferedWriter(oWriter);
//        } catch (FileNotFoundException e1) {
//            e1.printStackTrace();
//        }
//        try {
//            t.process(dataMap, out);
//            out.close();
//            fos.close();
//            return outFile;
//        } catch (TemplateException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//}

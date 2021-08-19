//package com.example.demo.collection.dingding;
//
//import com.alibaba.fastjson.JSON;
//import lombok.val;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.net.MalformedURLException;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.net.URL;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @Author cfy
// * @Date 2021-4-29 下午 3:00
// * @Version 1.0
// */
//public class HttpPost {
//    public String sendPostByMap(String url, Map<String,Object> mapParam) {
//        Map<String, String> headParam = new HashMap();
//        headParam.put("Content-type","application/json;charset=UTF-8");
//        return sendPost(url, mapParam, headParam);
//    }
//
//    public String  sendPost(String url, Map<String,Object> param, Map<String, String> headParam) throws Exception {
//        PrintWriter out = null;
//        BufferedReader in = null;
//        String result = "";
//        try {
//            // val realUrl = URL(url)
//            URI realUrl = new URL(url).toURI();
//            // 打开和URL之间的连接
//            val conn = realUrl.openConnection()
//            // 设置通用的请求属性 请求头
//            conn.setRequestProperty("accept", "*/*")
//            conn.setRequestProperty("connection", "Keep-Alive")
//            conn.setRequestProperty("user-agent",
//                    "Fiddler")
//            if (headParam != null) {
//                for ((key, value) in headParam) {
//                    conn.setRequestProperty(key, value)
//                }
//            }
//            // 发送POST请求必须设置如下两行
//            conn.doOutput = true
//            conn.doInput = true
//            // 获取URLConnection对象对应的输出流
//            out = PrintWriter(conn.getOutputStream())
//            // 发送请求参数
//            out.print(JSON.toJSONString(param))
//            // flush输出流的缓冲
//            out.flush()
//            // 定义BufferedReader输入流来读取URL的响应
//            `in` = BufferedReader(
//                    InputStreamReader(conn.getInputStream()))
//            var line: String?
//            while (`in`.readLine().also { line = it } != null) {
//                result += line
//            }
//        } catch (e catch (IOException e) {
//            e.printStackTrace();
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }: Exception) {
//            log.info("发送 POST 请求出现异常！$e")
//            e.printStackTrace()
//        } //使用finally块来关闭输出流、输入流
//        finally {
//            try {
//                out?.close()
//                `in`?.close()
//            } catch (ex:IOException) {
//                ex.printStackTrace()
//            }
//        }
//        return result
//    }
//}

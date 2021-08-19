package com.example.demo.collection.dingding;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author cfy
 * @Date 2021-3-31 下午 5:14
 * @Version 1.0
 */
public class dd {

    /**

     * @Author: zhouhe

     * @Date: 2019/6/20 14:49

     */

    public static class SendHttps {
        private static Logger logger = LoggerFactory.getLogger(SendHttps.class);
        /**
         * 发送POST请求，参数是Map, contentType=x-www-form-urlencoded
         *
         * @param url
         * @param mapParam
         * @return
         */
        public static String sendPostByMap(String url, Map<String, Object> mapParam) {
            Map<String, String> headParam = new HashMap();
            headParam.put("Content-type", "application/json;charset=UTF-8");
            return sendPost(url, mapParam, headParam);
        }

        /**
         * 向指定 URL 发送POST方法的请求
         *
         * @param url  发送请求的 URL
         * @param param 请求参数，
         * @return 所代表远程资源的响应结果
         */
        public static String sendPost(String url, Map<String, Object> param, Map<String, String> headParam) {
            PrintWriter out = null;
            BufferedReader in = null;
            String result = "";
            try {
                URL realUrl = new URL(url);
                // 打开和URL之间的连接
                URLConnection conn = realUrl.openConnection();
                // 设置通用的请求属性 请求头
                conn.setRequestProperty("accept", "*/*");
                conn.setRequestProperty("connection", "Keep-Alive");
                conn.setRequestProperty("user-agent",
                        "Fiddler");

                if (headParam != null) {
                    for (Map.Entry<String, String> entry : headParam.entrySet()) {
                        conn.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                // 发送POST请求必须设置如下两行
                conn.setDoOutput(true);
                conn.setDoInput(true);
                // 获取URLConnection对象对应的输出流
                out = new PrintWriter(conn.getOutputStream());
                // 发送请求参数
                out.print(JSON.toJSONString(param));
                // flush输出流的缓冲
                out.flush();
                // 定义BufferedReader输入流来读取URL的响应
                in = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));
                String line;
                while ((line = in.readLine()) != null) {
                    result += line;
                }
            } catch (Exception e) {
                logger.info("发送 POST 请求出现异常！" + e);
                e.printStackTrace();
            }
            //使用finally块来关闭输出流、输入流
            finally {
                try {
                    if (out != null) {
                        out.close();
                    }
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        // 钉钉的webhook
        //群机器人复制到的秘钥secret
        String secret = "SECfa77a3997b6eb04f62c77ed579fdf9633ec676efa214980ca7bd1e55b1466cdb";
        //获取系统时间戳
        Long timestamp = System.currentTimeMillis();
        //拼接
        String stringToSign = timestamp + "\n" + secret;
        //使用HmacSHA256算法计算签名
        Mac mac = null;
        String sign = null;
        try {
            mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256"));
            byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
            sign = URLEncoder.encode(new String(Base64.encodeBase64(signData)), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //进行Base64 encode 得到最后的sign，可以拼接进url里
        //钉钉机器人地址（配置机器人的webhook）
        String dingUrl = "https://oapi.dingtalk.com/robot/send?access_token=0b0be33ce678f2fa77bad355ddf61fcf5d2ec64067e65566da0fdf9c5ab30d1f" +
                "&timestamp=" + timestamp + "&sign=" + sign;

        // 请求的JSON数据，这里我用map在工具类里转成json格式
        Map<String,Object> json=new HashMap();
        Map<String,Object> text=new HashMap();
        json.put("msgtype","text");
        text.put("content","未完成任务清单"+" :临涣焦化：VOCs排放浓度大于上限：61.89");
        json.put("text",text);
        // 发送post请求
        String response = dd.SendHttps.sendPostByMap(dingUrl, json);
        System.out.println("相应结果："+response);
    }
}

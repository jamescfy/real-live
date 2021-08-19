//package com.example.demo.collection.dingding;
//
//import com.ztc.xa.project.task.util.Http;
//import lombok.val;
//import org.apache.commons.codec.binary.Base64;
//
//import javax.crypto.Mac;
//import java.net.URLEncoder;
//import java.security.NoSuchAlgorithmException;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @Author cfy
// * @Date 2021-4-29 下午 2:04
// * @Version 1.0
// */
//public class SendDingDingUtil {
//
//    public void sendDingDing(String url, String secret, String accessToken, String content)throws NoSuchAlgorithmException {
//        try {
//            url = url+ "?access_token="+accessToken;
//            if(!secret.isEmpty()){
//                String singKey = singKey(secret);
//                url = url +singKey;
//            }
//            Map<String, Object> json = new HashMap();
//            Map<String, String> text = new HashMap();
//            text.put("content",content);
//            json.put("msgtype","text");
//            json.put("text",text);
//            val result = new HttpPost().sendPostByMap(url, json);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public static String singKey(String secret) throws NoSuchAlgorithmException {
//        Long  timestamp = System.currentTimeMillis();
//        String stringToSign = timestamp.toString() + "\n" + secret;
//        Mac mac = Mac.getInstance("HmacSHA256");
//        mac.init(SecretKeySpec(secret.toByteArray(charset("UTF-8")), "HmacSHA256"));
//        ByteArray signData = mac.doFinal(stringToSign.toByteArray(charset("UTF-8")));
//        val sign= URLEncoder.encode(String(Base64.encodeBase64(signData)),"UTF-8");
//        return "&timestamp="+timestamp+"&sign="+sign;
//    }
//}

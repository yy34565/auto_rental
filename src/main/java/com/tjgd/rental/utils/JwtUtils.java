package com.tjgd.rental.utils;

import cn.hutool.core.convert.NumberWithFormat;
import cn.hutool.core.date.DateTime;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//jwt header payload signature
/*
header ,json格式，指定加密算法，令牌类型，再由base64编码
payload,json格式，存放数据，再由base64编码
signature,hmac算法，对header和payload进行签名，再由base64编码
 */

@Component
public class JwtUtils {


    //jwt密钥
    public static final String SECRET_KEY = "123456";

    //过期时间
    public static final long EXPIRATION_TIME = 1000 * 60 * 30;


    public static String createToken(Map<String, Object> payload) {
        //当前时间
        DateTime now=DateTime.now();
        //过期时间
        DateTime newTime=new DateTime(now.getTime()+EXPIRATION_TIME);

        //设置过期时间
        payload.put(JWTPayload.EXPIRES_AT,newTime);

        //设置签发时间
        payload.put(JWTPayload.ISSUED_AT,now);


        //设置生效时间,确保签发后立即生效
        payload.put(JWTPayload.NOT_BEFORE,now);

        return JWTUtil.createToken( payload, SECRET_KEY.getBytes());
    }


    public static JWTPayload parseToken(String token) {
        JWT jwt= JWTUtil.parseToken(token);// 解析传入的token字符串
        if (!jwt.setKey(SECRET_KEY.getBytes()).verify()){ // 验证token的签名，确保token未被篡改
            throw new RuntimeException("token异常");
        }
        if (!jwt.validate(0)){ // 检查token是否过期
            throw new RuntimeException("token已过期");
        }
        return jwt.getPayload(); // 返回token的payload部分


    }



//     public static void main(String[] args) {
// //    Map<String, Object> payload = new HashMap<>();
////        payload.put("username","admin");
////        payload.put("id","111");
////        String token = createToken(payload);
////        System.out.println(token);
//
//        String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJuYmYiOjE3NzU4MjQ2OTksImlkIjoiMTExIiwiZXhwIjoxNzc1ODI2NDk5LCJpYXQiOjE3NzU4MjQ2OTksInVzZXJuYW1lIjoiYWRtaW4ifQ.MPlNTAwdF-kNIMn7LLxKWjq__qo_kk3sGl8Z2XpV80k";
//        JWTPayload payload = parseToken(token);
//        System.out.println(payload.getClaim("username"));
//        System.out.println(payload.getClaim("id"));
//        NumberWithFormat claim = (NumberWithFormat) payload.getClaim(JWTPayload.EXPIRES_AT);
//        DateTime convert =(DateTime) claim.convert(DateTime.class, claim);
//
//        long expireTime = convert.getTime();
//        long nowTime = DateTime.now().getTime();
//        System.out.println((expireTime-nowTime)/1000);
//
//    }


}

package com.tjgd.rental.security;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.convert.NumberWithFormat;
import cn.hutool.core.date.DateTime;
import cn.hutool.jwt.JWTPayload;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.tjgd.rental.entity.User;
import com.tjgd.rental.utils.JwtUtils;
import com.tjgd.rental.utils.RedisUtils;
import com.tjgd.rental.utils.ResultCode;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {


    @Resource
    private RedisUtils redisUtils;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {



        // 登录成功返回json数据
        response.setContentType("application/json;charset=UTF-8");
        User user=(User) authentication.getPrincipal();

        //生成token的处理
        Map<String,Object> map=new HashMap<>();

        map.put("username" ,user.getUsername());
        map.put("id",user.getId());

        String token= JwtUtils.createToken(map);
        NumberWithFormat claim=(NumberWithFormat) JwtUtils.parseToken(token).getClaim(JWTPayload.EXPIRES_AT);
        long expireTime= Convert.toDate(claim).getTime();
        AuthenticationResult authenticationResul
                = new AuthenticationResult(user.getId(), ResultCode.SUCCESS,token,expireTime);



        //获取一个结果
        String result=JSON.toJSONString(authenticationResul,
                SerializerFeature.DisableCircularReferenceDetect);


        //获取输出流
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(result.getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();

        //把token存到redis,设置过期时间
        String tokenKey="token:"+token;
        long nowTime= DateTime.now().getTime();
        redisUtils.set(tokenKey,token,(expireTime-nowTime)/1000);




    }
}

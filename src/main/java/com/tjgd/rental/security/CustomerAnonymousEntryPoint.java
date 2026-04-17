package com.tjgd.rental.security;

import com.alibaba.fastjson.JSON;
import com.tjgd.rental.utils.Result;
import com.tjgd.rental.utils.ResultCode;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 匿名用户访问无权限资源处理器
 */
@Component
public class CustomerAnonymousEntryPoint implements AuthenticationEntryPoint {

    /**
     * 当匿名用户尝试访问受保护资源时，此方法会被调用。
     * 它会向客户端返回一个 JSON 格式的错误响应，状态码为 401 Unauthorized。
     *
     * @param request       当前的 HTTP 请求
     * @param response      当前的 HTTP 响应
     * @param authException 导致的认证异常
     * @throws IOException 如果发生 I/O 错误
     * @throws ServletException 如果发生 Servlet 错误
     */
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        // 设置响应内容类型为 JSON，字符编码为 UTF-8
        response.setContentType("application/json;charset=utf-8");
        
        // 构建统一错误响应结果
        Result result = Result.error()
                .setCode(ResultCode.UNAUTHORIZED)
                .setMessage("匿名用户无权访问");
        
        // 将结果对象序列化为 JSON 字符串
        String jsonResponse = JSON.toJSONString(result);
        
        // 获取输出流并写入响应数据
        try (ServletOutputStream outputStream = response.getOutputStream()) {
            outputStream.write(jsonResponse.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
        }
    }
}
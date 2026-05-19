package com.tjgd.rental.security;

import com.alibaba.fastjson.JSON;
import com.tjgd.rental.utils.Result;
import com.tjgd.rental.utils.ResultCode;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 用户无权访问，被拒绝的处理器
 */
@Component
public class CustomerAccessDeniedHandler implements AccessDeniedHandler {

    /**
     * 处理访问被拒绝的情况
     * <p>
     * 当已认证的用户尝试访问其没有权限的资源时，Spring Security 会调用此方法。
     * 该方法负责构建统一的 JSON 错误响应返回给前端。
     *
     * @param request              当前的 HTTP 请求对象
     * @param response             当前的 HTTP 响应对象
     * @param accessDeniedException 抛出的访问 denied 异常，包含具体的错误信息
     * @throws IOException      如果发生 I/O 错误
     * @throws ServletException 如果发生 Servlet 相关错误
     */
    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {
        // 1. 设置响应内容类型为 JSON，并指定字符编码为 UTF-8，防止中文乱码
        response.setContentType("application/json;charset=utf-8");

        // 2. 获取响应输出流，用于写入响应数据
        ServletOutputStream outputStream = response.getOutputStream();

        // 3. 构建统一的结果对象
        //    - Result.error(): 创建一个表示错误的结果对象
        //    - setCode(ResultCode.UNAUTHORIZED): 设置错误代码为未授权（401 或业务定义的无权访问码）
        //    - setMessage("无权访问"): 设置具体的错误提示信息
        //    - JSON.toJSONString(): 将结果对象序列化为 JSON 字符串
        String result = JSON.toJSONString(Result.error()
                .setCode(ResultCode.UNAUTHORIZED)
                .setMessage("无权访问"));

        // 4. 将 JSON 字符串转换为 UTF-8 字节数组并写入输出流
        outputStream.write(result.getBytes(StandardCharsets.UTF_8));

        // 5. 刷新输出流，确保所有缓冲的数据都被写入客户端
        outputStream.flush();

        // 6. 关闭输出流，释放资源
        outputStream.close();
    }
}
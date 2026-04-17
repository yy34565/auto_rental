package com.tjgd.rental.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
public class CORSConfig implements WebMvcConfigurer {

    //解决跨域
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //配置跨域请求的映射
        registry.addMapping("/**")
                // ✅ 用 allowedOriginPatterns 替代 allowedOrigins
                .allowedOriginPatterns("*")
                //允许的请求方法
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                //允许的请求头
                .allowedHeaders("*")
                //允许携带凭证（如 Cookie、Authorization）
                .allowCredentials(true)
                //跨域请求的缓存时间
                .maxAge(3600);
    }




}

package com.tjgd.rental.security;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Resource
    private LoginSuccessHandler loginSucdessHandler;
    @Resource
    private LoginFailHandler loginFailHandler;
    @Resource
    private CustomerAccessDeniedHandler customerAccessDeniedHandler;
    @Resource
    private CustomerAnonymousEntryPoint customerAnonymousEntryPoint;
    @Resource
    private CustomerUserDetailsService customerUserDetailsService;

    @Resource
    private VerifyTokenFilter verifyTokenFilter;

    /**
     * 配置安全过滤链（Spring Security 6.1+ Lambda DSL 新写法）
     *
     * @param http 用于配置HttpSecurity的接口
     * @return 返回构建好的SecurityFilterChain对象
     * @throws Exception 如果配置过程中发生错误，则抛出异常
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception{

        //登入前过滤配置
        http.addFilterBefore(verifyTokenFilter,
                UsernamePasswordAuthenticationFilter.class);

        http
            // 配置表单登录
            .formLogin(form -> form
                .loginProcessingUrl("/rental/user/login") // 设置登录处理URL
                .successHandler(loginSucdessHandler) // 设置登录成功处理器
                .failureHandler(loginFailHandler) // 设置登录失败处理器
            )
            // 配置会话管理为无状态（前后端分离使用JWT，不需要Session）
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            // 配置请求授权规则
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/rental/user/login").permitAll() // 登录接口允许匿名访问
                .anyRequest().authenticated() // 其他所有请求需要认证
            )
            // 配置异常处理
            .exceptionHandling(exception -> exception
                .authenticationEntryPoint(customerAnonymousEntryPoint) // 未认证时的入口点
                .accessDeniedHandler(customerAccessDeniedHandler) // 权限不足时的处理器
            )
            // 配置跨域（使用全局CORS配置）
            .cors(cors -> {})
            // 禁用CSRF保护（前后端分离使用Token认证，不需要CSRF防护）
            .csrf(csrf -> csrf.disable())
            // 设置用户详情服务
            .userDetailsService(customerUserDetailsService);

        return http.build();
    }
}

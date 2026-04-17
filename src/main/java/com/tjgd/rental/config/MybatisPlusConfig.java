package com.tjgd.rental.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;

public class MybatisPlusConfig {


    // ... existing code ...
        /**
         * 配置MyBatis-Plus拦截器，添加分页插件
         *
         * @return MybatisPlusInterceptor 配置好分页拦截器的MyBatis-Plus拦截器实例
         */
        @Bean
        public MybatisPlusInterceptor mybatisPlusInterceptor() {
            MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
            /*
             * 添加MySQL分页拦截器
             * 注意：如果配置多个插件，分页拦截器必须最后添加
             * 对于多数据源场景可以不指定DbType，单数据源建议明确指定数据库类型
             */
            interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
            return interceptor;
        }
    // ... existing code ...



}

package com.thirteenash.config;

import com.thirteenash.filter.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置类
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private TokenInterceptor tokenInterceptor;

    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

         registry.addInterceptor(tokenInterceptor) // 添加拦截器
                .addPathPatterns("/**") // 拦截所有请求
                .excludePathPatterns("/login"); // 不拦截哪些请求
    }
}

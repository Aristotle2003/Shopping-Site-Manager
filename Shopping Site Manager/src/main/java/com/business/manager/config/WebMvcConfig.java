package com.business.manager.config;

import com.business.manager.config.interceptor.ApiInterceptor;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {


    @Resource
    private ApiInterceptor apiInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiInterceptor)
                .excludePathPatterns("/apis/login","/api/register","/api/captcha")
                .addPathPatterns("/**");
    }
}

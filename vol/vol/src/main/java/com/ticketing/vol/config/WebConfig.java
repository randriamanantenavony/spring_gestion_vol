package com.ticketing.vol.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ticketing.vol.interceptor.AuthInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor())
                .addPathPatterns("/admin/**") // Appliquer sur toutes les routes sous /admin
                .excludePathPatterns("/admin/login", "/admin/home"); // Exclure login et home
    }
}


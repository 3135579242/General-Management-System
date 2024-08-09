package com.along.generalmanagementsystemback.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

/**
 * 时间 2024年08月06日
 */

@Configuration
public class WebConfig {

    /**
     * 设置跨域允许访问后台资源Cors
     * @return
     */
    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*"); // 允许任何源
        config.addAllowedHeader("*"); // 允许任何头
        config.addAllowedMethod("*"); // 允许任何方法
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}

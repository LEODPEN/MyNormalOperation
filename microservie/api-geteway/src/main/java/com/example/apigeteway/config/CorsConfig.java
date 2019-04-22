package com.example.apigeteway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

//跨域配置 cross origin resource sharing
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter(){

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        final CorsConfiguration config = new CorsConfiguration();

        //设置是否支持cookie跨域
        config.setAllowCredentials(true);
        //原始域名，可以有几个就写几个
        config.setAllowedOrigins(Arrays.asList("*"));
        config.setAllowedHeaders(Arrays.asList("*"));
        config.setAllowedMethods(Arrays.asList("*"));
        //时间内相同跨域请求不再检查了
        config.setMaxAge(300l);

        source.registerCorsConfiguration("/**",config);

        return new CorsFilter(source);
    }
}

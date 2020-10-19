package com.itheima.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignLoggerConfig {

    /*
        NONE,不记录
        BASIC,记录基本的请求行，响应状态码数据
        HEADERS,记录基本的请求行，响应状态码数据，记录响应头信息
        FULL;记录完成的请求 响应数据
    */
    //将Feign包中内部枚举类level注入到IOC容器中
    @Bean
    public Logger.Level getInstanceLogger(){
        return Logger.Level.FULL;
    }
}

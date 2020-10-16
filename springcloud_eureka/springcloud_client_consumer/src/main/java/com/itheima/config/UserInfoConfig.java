package com.itheima.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class UserInfoConfig {
    @Bean//当web容器启动时，初始化一个实例加到ioc容器中
    public RestTemplate getTemplate(){
        return new RestTemplate();
    }
}

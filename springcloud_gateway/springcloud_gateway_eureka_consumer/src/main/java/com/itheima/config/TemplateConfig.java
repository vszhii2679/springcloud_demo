package com.itheima.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class TemplateConfig {

    @Bean
    @LoadBalanced//开启Ribbon负载均衡，默认使用轮询策略(Ribbon实现客户端负载均衡，nginx+lua实现服务端负载均衡)
    public RestTemplate getTemplate(){
        return new RestTemplate();
    }
}

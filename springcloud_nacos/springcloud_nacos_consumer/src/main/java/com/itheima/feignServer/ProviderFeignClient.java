package com.itheima.feignServer;

import com.itheima.config.FeignLoggerConfig;
import com.itheima.pojo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * ProviderFeignClient接口
 * 通过@FeignClient(name = "nacos-server-provider")关联注册中心中服务名为nacos-server-provider的服务(nacos)
 * eureka中name就是serviceId
 * 当前feign接口连接服务提供者对外暴露的接口
 */

@FeignClient(name = "nacos-server-provider",configuration = FeignLoggerConfig.class,fallback = ProviderFeignClientFallBack.class)
public interface ProviderFeignClient {
    @GetMapping("/provider/getResult/{id}")
    Result getResult(@PathVariable int id);
}
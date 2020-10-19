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

//url设置调用服务的全路径，一般用于本地测试(eureka与nacos不同，只设置name会报：java.net.UnknownHostException: springcloud-eureka-provider)
@FeignClient(url = "http://127.0.0.1:8001",name = "springcloud-eureka-provider",configuration = FeignLoggerConfig.class,fallback = ProviderFeignClientFallBack.class)
public interface ProviderFeignClient {
    @GetMapping("/provider/getResult/{id}")
    Result getResult(@PathVariable int id);
}
package com.itheima.feignServer;

import com.itheima.pojo.Result;
import org.springframework.stereotype.Component;

//@Component
public class ProviderFeignClientFallBack implements ProviderFeignClient {
    @Override
    public Result getResult(int id) {
        return new Result(false,"服务消费者降级","未连接提供者");
    }
}

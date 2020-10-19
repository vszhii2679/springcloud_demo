package com.itheima.controller;

import com.itheima.feignServer.ProviderFeignClient;
import com.itheima.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProviderFeignClient providerFeignClient;

    @GetMapping("/getResult/{id}")
    public Result getResult(@PathVariable int id) {
        //原始方式、使用restTemplate发送test请求获得数据
        //String url = "http://127.0.0.1:8888/provider/getResult/" + id;
        //Result result = restTemplate.getForObject(url, Result.class);
        //return result;

        //使用feign远程调用

        return providerFeignClient.getResult(id);
    }
}

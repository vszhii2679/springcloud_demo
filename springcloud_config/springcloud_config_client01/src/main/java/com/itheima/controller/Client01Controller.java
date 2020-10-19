package com.itheima.controller;

import com.itheima.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/client01")
@RefreshScope // 开启刷新功能
public class Client01Controller {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${test}")
    private String str;

    @RequestMapping("/getConfig")
    public Result getConfig() {

        List<ServiceInstance> instances = discoveryClient.getInstances("CONFIG-SERVER");
        if (instances == null || instances.size() == 0) {
            return null;
        }
        //发送restful请求获取的结果
        ServiceInstance serviceInstance = instances.get(0);
        String instanceId = serviceInstance.getInstanceId();
        System.out.println("instanceId = " + instanceId);
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        String url = "http://"+host+":"+port+"/master/application-dev.yml";
        System.out.println("url = " + url);
        String s = restTemplate.getForObject(url, String.class);
        System.out.println("s = " + s);

        //通过远程获取config中的数据str
        return new Result(true, "获取信息成功", str);
    }
}

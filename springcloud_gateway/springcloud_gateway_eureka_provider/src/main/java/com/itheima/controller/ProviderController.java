package com.itheima.controller;

import com.itheima.pojo.Result;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/provider")
public class ProviderController {

    @GetMapping("/getResult/{id}")
    //配置访问降级处理
    /**服务降级：
     * 1、出现异常
     * 2、服务调用超时：默认1s超时
     */
    //fallbackMethod 指定降级调用的方法
    //@HystrixProperty(name="")  name属性取自HystrixCommandProperties类
    @HystrixCommand(fallbackMethod = "getResult_fallBack",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
                    //监控时间 默认5000 毫秒
                    @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "5000"),
                    //失败次数。默认20次
                    @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),
                    //失败率 默认50%
                    @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "50")
            })
    public Result getResult(@PathVariable int id) {
        if (id == 0) {
            int i = 1 / id;//模拟服务器宕机
        }
        /*try {
            //模拟服务连接超时
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return new Result(true, "从提供者获取的日期:" + id, new Date());
    }

    //服务提供者服务降级

    /**
     * 定义降级方法：方法的参数和返回值与原方法一致
     */
    public Result getResult_fallBack(int id) {
        if (id == 0) {
            return new Result(false, "服务提供者系统维护中...", "服务器宕机");
        } else
            return new Result(false, "服务提供者系统维护中...", "服务器连接超时");
    }
}

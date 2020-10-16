package com.itheima;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ClusterApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClusterApplication.class, args);
    }
}

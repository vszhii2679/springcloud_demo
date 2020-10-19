package com.itheima.comtroller;

import com.itheima.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user-cli")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    //注入DiscoveryClient (springcloud包)对象，进行eureka的发现服务
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/getUserById/{id}")
    public UserInfo getUserById(@PathVariable Integer id){
        //String url = "http://127.0.0.1:8080/user/getUserById/"+id;
        //UserInfo userInfo = restTemplate.getForObject(url, UserInfo.class);
        //通过DiscoveryClient的getInstances方法，传入serviceId，可以通过@Value注入，获取的是List集合
        List<ServiceInstance> instanceList = discoveryClient.getInstances("SPRINGCLOUD_CLIENT-PROVIDER");
        if(instanceList==null || instanceList.size()<0){
            return null;
        }
        //serviceInstance中封装了服务提供者的ip、端口号等信息
        ServiceInstance serviceInstance = instanceList.get(0);
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        String url = "http://"+host+":"+port+"/user/getUserById/"+id;
        //getForObject方法，通过restAPI发送http请求获得结果
        UserInfo userInfo = restTemplate.getForObject(url, UserInfo.class);
        return userInfo;
    }

    @GetMapping("/getUserList")
    public List getUserList(){
        String url = "http://127.0.0.1:8080/user/getUserList";
        ResponseEntity<List> entity = restTemplate.getForEntity(url, List.class);
        return entity.getBody();
    }
}

package com.itheima.comtroller;

import com.itheima.pojo.UserInfo;
import com.itheima.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/getUserById/{id}")
    public UserInfo getUserById(@PathVariable Integer id){
        return userInfoService.getUserById(id);
    }

    @GetMapping("/getUserList")
    public List getUserList(){
        return userInfoService.getUserList();
    }
}

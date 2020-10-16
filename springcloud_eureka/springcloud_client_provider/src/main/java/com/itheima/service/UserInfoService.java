package com.itheima.service;

import com.itheima.pojo.UserInfo;

import java.util.List;

public interface UserInfoService {
    UserInfo getUserById(Integer id);

    List getUserList();
}

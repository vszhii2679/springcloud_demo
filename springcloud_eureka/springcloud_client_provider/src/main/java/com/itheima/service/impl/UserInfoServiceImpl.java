package com.itheima.service.impl;

import com.itheima.dao.UserInfoDao;
import com.itheima.pojo.UserInfo;
import com.itheima.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo getUserById(Integer id) {
        return userInfoDao.getOne(id);
    }

    @Override
    public List getUserList() {
        return userInfoDao.findAll();
    }
}

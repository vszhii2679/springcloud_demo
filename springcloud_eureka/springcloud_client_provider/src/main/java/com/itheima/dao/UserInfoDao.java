package com.itheima.dao;

import com.itheima.pojo.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface UserInfoDao extends JpaRepository<UserInfo, Integer> {
}

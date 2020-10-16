package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity//标明UserInfo为实体类
@Proxy(lazy = false)//关闭懒加载
@Table(name = "user",catalog = "springboot_test")//当前类对应的数据库的表、库
public class UserInfo {
    @Id//标记在主键位置上
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键生成策略
    private Integer id;
    private String name;
    private Integer age;
}

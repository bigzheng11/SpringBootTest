package com.example.springboottest.entity;

import lombok.Data;

import javax.persistence.*;

//@Entity注解:Book这个类就可以和数据库中的表绑定,通过表名和类名的映射关系
@Entity
@Data//lombok注解,自动生成各种get方法,exit方法
public class User {
    @Id//跟数据库中的id绑定
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String nick_name;
    private Integer age;
}

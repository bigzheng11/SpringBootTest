package com.example.springboottest;

import com.example.springboottest.entity.User;
import com.example.springboottest.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootTestApplicationTests {

    @Autowired
    private UserRepository repository;

    @Test
    void contextLoads() {
    }

    @Test
    void save(){
        User user=new User();
        user.setUsername("SpringBoot");
        user.setPassword("222");
        user.setNick_name("pBoot");
        user.setAge(33);
        User user1=repository.save(user);
        System.out.println(user1);
    }

    @Test
    void findById(){
        User user=repository.findById(1).get();
        System.out.println(user);
    }

    @Test
    void update(){
        User user=new User();
        user.setId(11);
        user.setUsername("测试");
        User user2=repository.save(user);
        System.out.println(user2);
    }

    @Test
    void delete(){
        repository.deleteById(3);
    }


}

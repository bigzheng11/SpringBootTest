package com.example.springboottest.controller;

import com.example.springboottest.entity.User;
import com.example.springboottest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.awt.print.Book;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/User")
public class UserHandler {
    @Autowired
    private UserRepository userRepository;

     @GetMapping("/UserDetail/{page}/{size}")
    public Page<User> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){

         Pageable pageable= PageRequest.of(page-1,size);
        //↑↑接口             ↑实现类        ↑查第一页的数据,取6条
         return userRepository.findAll(pageable);
     }

     @PostMapping("/save")
     public String save(@RequestBody User user){
        User result=userRepository.save(user);
        if(result!=null){
            return "成功";
        }else{
            return "失败";
        }
     }

     @GetMapping("findById/{id}")
     public User findById(@PathVariable("id") Integer id){
         return userRepository.findById(id).get();
     }

     @PutMapping("/update")
     public String update(@RequestBody User user){
         User result=userRepository.save(user);
         if(result!=null){
             return "成功";
         }else{
             return "失败";
         }
     }

     @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
         userRepository.deleteById(id);
     }

}

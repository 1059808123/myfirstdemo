package com.learningspringboot.springbootlearning.service.impl;

import com.learningspringboot.springbootlearning.mapper.UserMapper;
import com.learningspringboot.springbootlearning.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@Controller
public class UserServiceImpl {
    @Autowired(required = false)
    private UserMapper userMapper;

    @RequestMapping("/test")
    public void test(){
        userMapper.insertPick("1","5");
    }
}

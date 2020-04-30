package com.learningspringboot.springbootlearning.service.impl;

import com.learningspringboot.springbootlearning.mapper.PickMapper;
import com.learningspringboot.springbootlearning.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserServiceImpl {
    @Autowired(required = false)
    private PickMapper pickMapper;

    @RequestMapping("/test")
    public String test(){
        pickMapper.cancelPick("1","2");
        return "chenggong";
    }
}

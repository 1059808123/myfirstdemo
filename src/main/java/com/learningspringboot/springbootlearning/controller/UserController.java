package com.learningspringboot.springbootlearning.controller;

import com.learningspringboot.springbootlearning.model.WeChatLoginModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springbootlearning
 * @description: 用户登录验证操作
 * @author: LiHongyan
 * @create: 2020-05-05 22:43
 **/
@RestController
public class UserController {
    //@ResponseBody
    @PostMapping("/login")
    public void wechatLogin(@RequestBody WeChatLoginModel model){

    }
}

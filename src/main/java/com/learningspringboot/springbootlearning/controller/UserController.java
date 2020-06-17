package com.learningspringboot.springbootlearning.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.learningspringboot.springbootlearning.model.User;
import com.learningspringboot.springbootlearning.model.WeChatLoginModel;
import com.learningspringboot.springbootlearning.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: springbootlearning
 * @description: 用户登录验证操作
 * @author: LiHongyan
 * @create: 2020-05-05 22:43
 **/
@RestController
public class UserController {
    @Autowired
    private IUserService iUserService;
    @ResponseBody
    @PostMapping("/login")
    public Object wechatLogin(@RequestBody WeChatLoginModel model){
        JSONObject jsonObject = (JSONObject) JSON.toJSON(iUserService.wxLogin(model));
        return jsonObject;
    }
    @ResponseBody
    @PostMapping("/loginAdd")
    public void updateUser(@RequestBody User user){
        System.out.println(user);
        iUserService.wxAddLogin(user);
    }

    @ResponseBody
    @GetMapping("/chat")
    public User chatUser(@RequestParam(name = "id")String id){
        return iUserService.chatUserMessage(id);
    }
}

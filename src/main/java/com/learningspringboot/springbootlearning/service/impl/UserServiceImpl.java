package com.learningspringboot.springbootlearning.service.impl;

import com.learningspringboot.springbootlearning.mapper.PickMapper;
import com.learningspringboot.springbootlearning.mapper.UserMapper;
import com.learningspringboot.springbootlearning.model.WeChatLoginModel;
import com.learningspringboot.springbootlearning.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class UserServiceImpl implements IUserService {
    @Autowired(required = false)
    private PickMapper pickMapper;

    @Override
    public void wxLogin(WeChatLoginModel weChatLoginModel) {
        try{
            String urlFormat = "https://api.weixin.qq.com/sns/jscode2session?appid=wxc7a9a956c95e08a8&secret=ee2eae3b7aff8ad2352d35f701774f73&js_code=%s&grant_type=authorization_code";
            String url = String.format(urlFormat, weChatLoginModel.getCode());
            Map<String, Object> map = null;

        }catch(Exception e){

        }
    }
}

package com.learningspringboot.springbootlearning.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.learningspringboot.springbootlearning.mapper.OpenIdAndUserMapper;
import com.learningspringboot.springbootlearning.model.OpenIdAndUser;
import com.learningspringboot.springbootlearning.model.Result;
import com.learningspringboot.springbootlearning.model.User;
import com.mysql.cj.x.protobuf.MysqlxCursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: springbootlearning
 * @description: 根据openid判断是否有账号对应，有则返回user，否则创建用户并返回
 * @author: LiHongyan
 * @create: 2020-05-06 10:34
 **/

@Service
public class HasUser {

    @Autowired(required = false)
    private OpenIdAndUserMapper openIdAndUserMapper;

    public User hasAccount(String code){
        Result result = null;
        OpenIdAndUser openIdAndUser = null;
        try {
            //将微信服务器传回的字符串换成相应的包装对象
            result = JSON.parseObject(code,Result.class);
            System.out.println(result.toString());
            //拿到用户的openid
            String openId = result.getOpenId();
            //利用openid查询是否有账号对应
            openIdAndUser = openIdAndUserMapper.wechatUserId(openId);
            //若没有则注册
            if(openIdAndUser == null){
                OpenIdAndUser newUser = new OpenIdAndUser();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

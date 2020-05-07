package com.learningspringboot.springbootlearning.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.learningspringboot.springbootlearning.mapper.OpenIdAndUserMapper;
import com.learningspringboot.springbootlearning.mapper.UserMapper;
import com.learningspringboot.springbootlearning.model.OpenIdAndUser;
import com.learningspringboot.springbootlearning.model.Result;
import com.learningspringboot.springbootlearning.model.User;
import com.mysql.cj.x.protobuf.MysqlxCursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.util.Random;

/**
 * @program: springbootlearning
 * @description: 根据openid判断是否有账号对应，有则返回user，否则创建用户并返回
 * @author: LiHongyan
 * @create: 2020-05-06 10:34
 **/

@Service
@Component
public class HasUser {

    @Autowired(required = false)
    private OpenIdAndUserMapper openIdAndUserMapper;
    @Autowired(required = false)
    private UserMapper userMapper;


    public User hasAccount(String code){
        Result result = null;
        User uu = new User();
        OpenIdAndUser openIdAndUser = new OpenIdAndUser(null,null,null);
        try {
            //将微信服务器传回的字符串换成相应的包装对象
            result = JSON.parseObject(code,Result.class);
            System.out.println(result.toString());
            //拿到用户的openid
            String openId = result.getOpenId();
            //利用openid查询是否有账号对应

            openIdAndUser = openIdAndUserMapper.wechatUserId(openId);
            System.out.println(openIdAndUser);
            //若没有则注册
            if(openIdAndUser == null){
                //产生随机账号
                String Id = openId.toString().substring(6,10);
                String verifyCode = String.valueOf(new Random().nextInt(89999) + 10000);
                String userId = Id.concat(verifyCode);
                //插入到相关表中
                OpenIdAndUser newUser = new OpenIdAndUser(openId,userId,result.getSession_key());
                openIdAndUserMapper.addUser(newUser);

                uu.setUserId(userId);
                userMapper.insertUser(uu);
            }else {
                //查询到有相关账号
               String  newUserId  = openIdAndUser.getUserId();
               uu = userMapper.selectById(newUserId);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return uu;
    }
}

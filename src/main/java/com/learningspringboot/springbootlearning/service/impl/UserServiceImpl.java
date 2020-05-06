package com.learningspringboot.springbootlearning.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.learningspringboot.springbootlearning.mapper.PickMapper;
import com.learningspringboot.springbootlearning.mapper.UserMapper;
import com.learningspringboot.springbootlearning.model.User;
import com.learningspringboot.springbootlearning.model.WeChatLoginModel;
import com.learningspringboot.springbootlearning.service.IUserService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.net.www.http.HttpClient;

import java.util.*;


@RestController
public class UserServiceImpl implements IUserService {
    @Autowired(required = false)
    private UserMapper userMapper;
    @Autowired(required = false)
    private HasUser hasUser;

    @Override
    public User wxLogin(WeChatLoginModel weChatLoginModel) {


        String content = null;
        User user = new User();
        try{
            //向微信服务器发送请求获取session_key 以及openid
            String urlFormat = "https://api.weixin.qq.com/sns/jscode2session?appid=wxc7a9a956c95e08a8&secret=4aa5acb80507f8ad227c704ba7484757&js_code=%s&grant_type=authorization_code";
            String url = String.format(urlFormat, weChatLoginModel.getCode());
            CloseableHttpClient client = HttpClientBuilder.create().build();
            HttpGet get = new HttpGet(url.toString());
            CloseableHttpResponse response = client.execute(get);
            HttpEntity responseEntity = response.getEntity();
            content = EntityUtils.toString(responseEntity);

            System.out.println(content);
            user = hasUser.hasAccount(content);

        }catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void wxAddLogin(User user) {
        try{
            String i = user.getUserGender();
            if(i=="1"){
                user.setUserGender("male");
            }else {
                user.setUserGender("female");
            }
            userMapper.upadateUser(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

package com.learningspringboot.springbootlearning.service;

import com.learningspringboot.springbootlearning.dto.UserDto;
import com.learningspringboot.springbootlearning.model.WeChatLoginModel;

public interface IUserService {
    //x public UserDto queryUser(String userId);
    public String wxLogin(WeChatLoginModel weChatLoginModel);

}

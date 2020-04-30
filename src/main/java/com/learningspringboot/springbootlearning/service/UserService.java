package com.learningspringboot.springbootlearning.service;

import com.learningspringboot.springbootlearning.dto.UserDto;

public interface UserService {
    public UserDto queryUser(String userId);
}

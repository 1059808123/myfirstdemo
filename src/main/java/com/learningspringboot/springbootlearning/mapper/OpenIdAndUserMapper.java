package com.learningspringboot.springbootlearning.mapper;

import com.learningspringboot.springbootlearning.model.OpenIdAndUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OpenIdAndUserMapper {
    @Select("Select * From openidanduser Where openid=#{openId}")
    public OpenIdAndUser wechatUserId(String openId);
}

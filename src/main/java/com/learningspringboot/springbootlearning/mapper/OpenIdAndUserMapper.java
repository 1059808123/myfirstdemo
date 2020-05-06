package com.learningspringboot.springbootlearning.mapper;

import com.learningspringboot.springbootlearning.model.OpenIdAndUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OpenIdAndUserMapper {
    @Select("Select * From openidanduser Where openid=#{openId}")
    public OpenIdAndUser wechatUserId(String openId);

    @Insert("Insert into openidanduser (openId,userId,sessionKey)value(#{openId},#{userId},#{sessionKey})")
    public void addUser(OpenIdAndUser open);

}

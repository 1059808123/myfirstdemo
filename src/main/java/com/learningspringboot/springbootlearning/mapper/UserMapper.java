package com.learningspringboot.springbootlearning.mapper;

import com.learningspringboot.springbootlearning.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("Select user.userId, user.userName, user.userPhoto, user.userGender, user.userAge From user")
    public List<User> selectUser();
    @Insert("Insert into user (userId,userName,userPhoto,userGender,userAge)value(#{userId},#{userName},#{userPhoto},#{userGender},#{userAge}")
    public  void insertUser(User user);
    @Insert("Insert into pick (fromUserId,pickId)value(#{fromUserId},#{pickId})")
    public void insertPick(String fromUserId, String pickId);
}

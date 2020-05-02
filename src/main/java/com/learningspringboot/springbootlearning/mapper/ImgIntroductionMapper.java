package com.learningspringboot.springbootlearning.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ImgIntroductionMapper {
    @Select("Select imgUrl From imgintroduction Where userId=#{id}")
    public List<String> findImgIntroduction(String id);

    @Insert("Insert into imgintroduction (userId,imgUrl)value(#{userId},#{url})")
    public void addImg(String userId,String url);

    @Delete("Delete from imgintroduction Where imgId=#{id}")
    public void deleteImg(int id);

    @Delete("Delete from imgintroduction Where userId=#{id}")
    public void deleteAll(String id);
}

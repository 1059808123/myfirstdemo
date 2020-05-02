package com.learningspringboot.springbootlearning.mapper;

import com.learningspringboot.springbootlearning.model.Comments;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentsMapper {
    @Select("Select * From comments Where userId=#{userId}")
    public List<Comments> findComments(String userId);

    @Insert("Insert into comments (name,commentPhoto,comment,starComment,userId)value(#{name},#{commentPhoto},#{comment},#{starComment},#{userId})")
    public void addComment(Comments comments);

    @Delete("Delete From comments Where commentId=#{id}")
    public void deleteComment(int id);
}

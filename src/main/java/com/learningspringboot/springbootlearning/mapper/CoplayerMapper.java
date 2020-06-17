package com.learningspringboot.springbootlearning.mapper;

import com.learningspringboot.springbootlearning.model.CoPlayer;
import com.learningspringboot.springbootlearning.model.Skill;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CoplayerMapper {
    @Select("Select * From coplayer Where userId=#{id}")
    public CoPlayer findCoplayer(String id);

    @Insert("Insert into coplayer (userId,tag,textIntroduction,audioId,imgId,commentId)value(#{userId},#{tag},#{textIntroduction},#{audioId},#{imgId},#{commentId})")
    public void addCoplayer(CoPlayer coPlayer);

    @Delete("Delete From coplayer Where userId=#{id}")
    public void deleteCoplayer(String id);

    @Update("Update skill set tag=#{tag},textIntroduction=#{textIntroduction},audioId=#{audioId},imgId=#{imgId},commentId=#{commentId} Where userId=#{userId}")
    public void modifyCoplayer(CoPlayer coPlayer);

    @Select("Select * from coplayer limit #{start} , #{page}")
    public List<CoPlayer> findByIndex(int start, int page);

}

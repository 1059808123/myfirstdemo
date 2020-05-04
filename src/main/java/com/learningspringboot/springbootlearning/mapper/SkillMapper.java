package com.learningspringboot.springbootlearning.mapper;

import com.learningspringboot.springbootlearning.model.Pick;
import com.learningspringboot.springbootlearning.model.Skill;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SkillMapper {
    @Select("Select * From skill Where userId=#{id}")
    public List<Skill> findSkill(String id);

    @Update("Update skill set userId=#{userId},name=#{name},ability=#{ability},price=#{price},isWarranted=#{isWarranted},hasNum=#{hasNum},starComments=#{starComments} Where skillId=#{skillId}")
    public void modifySkill(Skill skill);

    @Delete("Delete From skill Where id=#{id}")
    public void deleteSkill(int id);

    @Insert("Insert into skill (userId,name,ability,price,isWarranted,hasNum,starComments)value(#{userId},#{name},#{ability},#{price},#{isWarranted},#{hasNum},#{starComments})")
    public void addSkill(Skill skill);
}

package com.learningspringboot.springbootlearning.mapper;


import com.learningspringboot.springbootlearning.model.AudioIntroduction;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AudioIntroductionMapper {
    @Select("Select * From audiointroduction Where id=#{id}")
    public AudioIntroduction findAudio(String id);

    @Insert("Insert into audiointroduction (id,src,bl) value(#{id},#{src},#{bl})")
    public void addAudio(AudioIntroduction audioIntroduction);

    @Delete("Delete From audiointroduction Where id=#{id}")
    public void deleteAdudio(String id);
}

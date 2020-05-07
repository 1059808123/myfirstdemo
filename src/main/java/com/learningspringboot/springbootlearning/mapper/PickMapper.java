package com.learningspringboot.springbootlearning.mapper;

import com.learningspringboot.springbootlearning.model.Pick;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PickMapper {
    @Insert("Insert into pick (fromUserId,pickId)value(#{fromUserId},#{pickId})")
    public void insertPick(String fromUserId, String pickId);

    @Select("Select * From pick Where fromUserId=#{id}")
    public List<Pick> findPick(String id);

    @Delete("Delete from pick Where fromUserId=#{id} And pickId=#{pickId}")
    public void cancelPick(String id, String pickId);
}

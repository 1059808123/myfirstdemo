package com.learningspringboot.springbootlearning.mapper;


import com.learningspringboot.springbootlearning.model.Order;

import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface OrderMapper {

    @Insert("Insert into orders (coPlayer,customer,orderId,price,time,allPrice,gameType,active,coPlayerName,coPlayerImg)value(#{coPlayer},#{customer},#{orderId},#{price},#{time},#{allPrice},#{gameType},#{active},#{coPlayerName},#{coPlayerImg})")
    public void createOrder(Order order);

    @Select("Select * From orders Where customer=#{id}")
    public List<Order> orderQuery(String id);

    @Select("Select * From orders Where orderId=#{orderId}")
    public Order FindOrder(String orderId);

    @Delete("Delete from orders Where orderId=#{id}")
    public void deleteOrder(String id);

    @Update("Update orders Set active=#{active} Where orderId=#{orderId}")
    public void upadateActive(String orderId, int active);
}

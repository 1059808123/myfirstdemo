package com.learningspringboot.springbootlearning.service.impl;

import com.learningspringboot.springbootlearning.mapper.OrderMapper;
import com.learningspringboot.springbootlearning.model.Order;
import com.learningspringboot.springbootlearning.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: springbootlearning
 * @description: 订单的业务类
 * @author: LiHongyan
 * @create: 2020-05-25 20:49
 **/
@Service
public class OrderService implements IOrderService {
    @Autowired(required = false)
    private OrderMapper orderMapper;

    @Override
    public void addOrder(Order order) {
        orderMapper.createOrder(order);
    }

    @Override
    public void addActive(String orderId, int active) {
        orderMapper.upadateActive(orderId,active);
    }

    @Override
    public List<Order> showOrder(String id) {
        List<Order> orders = new ArrayList<Order>();
        try{
             orders = orderMapper.orderQuery(id);
        }catch (Exception e){
            e.printStackTrace();
        }

        return orders;
    }

    @Override
    public Order findOrder(String orderId) {
        Order order = new Order();
        try{
            order = orderMapper.FindOrder(orderId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return order;
    }
}

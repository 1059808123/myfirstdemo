package com.learningspringboot.springbootlearning.service;

import com.learningspringboot.springbootlearning.model.Order;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.List;

public interface IOrderService {
    public void addOrder(Order order);
    public void addActive(String orderId, int active);
    public List<Order> showOrder(String id);
    public Order findOrder(String orderId);
}

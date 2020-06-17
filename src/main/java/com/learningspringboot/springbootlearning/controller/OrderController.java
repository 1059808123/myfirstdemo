package com.learningspringboot.springbootlearning.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.learningspringboot.springbootlearning.model.Order;
import com.learningspringboot.springbootlearning.service.ICoPlayerService;
import com.learningspringboot.springbootlearning.service.IOrderService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @program: springbootlearning
 * @description: 订单控制类
 * @author: LiHongyan
 * @create: 2020-05-25 18:04
 **/
@RestController
public class OrderController {
    @Autowired(required = false)
    private IOrderService iOrderService;
    @Autowired(required = false)
    private ICoPlayerService iCoPlayerService;

    @ResponseBody
    @PostMapping("/createOrder")
    public String createOrder(@RequestBody Order order){
        String datetime = new SimpleDateFormat("HHmmss").format(new Date());
        String verifyCode = String.valueOf(new Random().nextInt(8999) + 1000);
        String orderId = datetime.concat(verifyCode);
        order.setCoPlayerName(iCoPlayerService.findCoPlayer(order.getCoPlayer()).getUserName());
        order.setCoPlayerImg(iCoPlayerService.findCoPlayer(order.getCoPlayer()).getUserPhoto());
        order.setOrderId(orderId);
        order.setActive(1);
        try {
            iOrderService.addOrder(order);
        }catch (Exception e){
            e.printStackTrace();
        }
        return orderId;
    }

    @ResponseBody
    @GetMapping("addActive")
    public void changeStep(@RequestParam("orderId")String orderId,@RequestParam("active")int active){
        try{
            iOrderService.addActive(orderId,active);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @ResponseBody
    @GetMapping("/orderShow")
    public Object shwoOrder(@RequestParam("id") String id){
        JSONArray jsonArray = new JSONArray();
        try{
            List<Order> orderList = iOrderService.showOrder(id);
            for(Order order : orderList){
                JSONObject jsonObject = (JSONObject) JSON.toJSON(order);
                jsonArray.add( jsonObject);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonArray;
    }

    @ResponseBody
    @GetMapping("/findOrder")
    public Object findOrder(@RequestParam("orderId")String orderId){
        JSONObject jsonObject =new JSONObject();
        try{
            jsonObject = (JSONObject) JSON.toJSON(iOrderService.findOrder(orderId));
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonObject;
    }
}

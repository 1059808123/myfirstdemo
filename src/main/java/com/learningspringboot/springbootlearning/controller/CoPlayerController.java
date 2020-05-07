package com.learningspringboot.springbootlearning.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.learningspringboot.springbootlearning.mapper.PickMapper;
import com.learningspringboot.springbootlearning.model.Pick;
import com.learningspringboot.springbootlearning.service.ICoPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: springbootlearning
 * @description: 用于处理陪玩的控制层
 * @author: LiHongyan
 * @create: 2020-05-07 11:57
 **/
@RestController
public class CoPlayerController {
    @Autowired(required = false)
    private ICoPlayerService iCoPlayerService;


    @GetMapping("/coPlayer")
    @ResponseBody
    public Object findCoPlayer(@RequestParam("id")String id){

        JSONObject jsonObject = (JSONObject) JSON.toJSON(iCoPlayerService.findCoPlayer(id));
        return jsonObject;
    }

    @GetMapping("/isPick")
    @ResponseBody
    public boolean isPick(@RequestParam("id")String id, @RequestParam("pickId")String pickId){
        System.out.println("id\n"+id);
        System.out.println("pickId\n"+pickId);

       return iCoPlayerService.isPick(id,pickId);
    }

    @GetMapping("/addPick")
    @ResponseBody
    public boolean pick(@RequestParam("id")String id, @RequestParam("pickId")String pickId){

        return iCoPlayerService.pick(id,pickId);
    }

    @GetMapping("/cancelPick")
    @ResponseBody
    public boolean cancelPick(@RequestParam("id")String id, @RequestParam("pickId")String pickId){

        return iCoPlayerService.cancelPick(id,pickId);
    }
}

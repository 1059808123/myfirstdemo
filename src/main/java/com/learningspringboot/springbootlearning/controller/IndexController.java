package com.learningspringboot.springbootlearning.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.learningspringboot.springbootlearning.dto.CoPlayerDto;
import com.learningspringboot.springbootlearning.service.ICoPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class IndexController {
    @Autowired(required = false)
    private ICoPlayerService iCoPlayerService;

    /**
     * 首页获取陪玩列表
     * @param page 每页数据的数量
     * @param start 获取数据开始的下标值
     * @return
     */
    @GetMapping("/index")
    @ResponseBody
    public Object index(@RequestParam(name = "page") int page, @RequestParam(name = "start") int start){
        System.out.println("接收到了请求");
        List<CoPlayerDto> coPlayerDtoList = iCoPlayerService.showCoPlayers(page,start);
        JSONArray jsonArray = new JSONArray();
        for(CoPlayerDto coPlayerDto : coPlayerDtoList){
            JSONObject jsonObject=(JSONObject)JSON.toJSON(coPlayerDto);
            jsonArray.add(jsonObject);
        }
        return jsonArray;
        //return "asdas";
    }
}

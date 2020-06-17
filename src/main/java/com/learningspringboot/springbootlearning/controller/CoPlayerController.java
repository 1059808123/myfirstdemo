package com.learningspringboot.springbootlearning.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.learningspringboot.springbootlearning.mapper.PickMapper;
import com.learningspringboot.springbootlearning.model.Comments;
import com.learningspringboot.springbootlearning.model.Pick;
import com.learningspringboot.springbootlearning.model.User;
import com.learningspringboot.springbootlearning.service.ICoPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @GetMapping("/skill")
    @ResponseBody
    public String skillQuery(@RequestParam("id")String userId){
        List<String> name = iCoPlayerService.skillQuery(userId);
        String names = JSON.toJSONString(name);
        return names;
    }

    @PostMapping("addComment")
    @ResponseBody
    public void addComment( @RequestParam("coPlayerId")String coPlayerId,@RequestParam("gameName")String gameName,@RequestParam("comment")String comment, @RequestParam("star")String star, @RequestParam("userId")String userId ){
        Comments comments = new Comments();
        comments.setComment(comment);
        comments.setGameName(gameName);
        comments.setStarComment(star);
        comments.setUserId(coPlayerId);
        User user = iCoPlayerService.findUser(userId);
        comments.setCommentPhoto(user.getUserPhoto());
        comments.setName(user.getUserName());
        iCoPlayerService.addComment(comments);
    }

    @GetMapping("getComments")
    @ResponseBody
    public Object getComments(@RequestParam("id")String userId) {
        JSONArray jsonArray = new JSONArray();
        List<Comments> commentsList = new ArrayList<Comments>();
        try{
            commentsList = iCoPlayerService.findComments(userId);
            for(Comments comments : commentsList){
                JSONObject comment = (JSONObject)JSON.toJSON(comments);
                jsonArray.add(comment);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonArray;
    }
}

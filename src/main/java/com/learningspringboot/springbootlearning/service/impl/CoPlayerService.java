package com.learningspringboot.springbootlearning.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.learningspringboot.springbootlearning.dto.CoPlayerDto;
import com.learningspringboot.springbootlearning.mapper.*;
import com.learningspringboot.springbootlearning.model.CoPlayer;
import com.learningspringboot.springbootlearning.model.User;
import com.learningspringboot.springbootlearning.service.ICoPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoPlayerService implements ICoPlayerService {
    @Autowired(required = false)
    private CoplayerMapper coplayerMapper;
    @Autowired(required = false)
    private UserMapper userMapper;
    @Autowired(required = false)
    private SkillMapper skillMapper;
    @Autowired(required = false)
    private ImgIntroductionMapper imgIntroductionMapper;
    @Autowired(required = false)
    private AudioIntroductionMapper audioIntroductionMapper;

    @Override
    public List<CoPlayerDto> showCoPlayers(int page, int start) {
        List<CoPlayerDto> coPlayerDtoList = new ArrayList<CoPlayerDto>();
        List<CoPlayer> coPlayers = coplayerMapper.findByIndex(start,page);
        for(int i = 0; i < coPlayers.size(); i++){
            String id = coPlayers.get(i).getUserId();
            User user = userMapper.selectById(id);
            //String userId, List<String> skills, String tag, List<String> imgIntroduction, String textIntroduction, String audioIntroduction, String userName, String userPhoto, String userGender, String userAge
            CoPlayerDto coPlayerDto = new CoPlayerDto(id,skillMapper.findSkill(id),coPlayers.get(i).getTag(),imgIntroductionMapper.findImgIntroduction(id),coPlayers.get(i).getTextIntroduction(),audioIntroductionMapper.findAudio(id).getSrc(),user.getUserName(),user.getUserPhoto(),user.getUserGender(),user.getUserAge());
            coPlayerDtoList.add(coPlayerDto);
        }
        return coPlayerDtoList;
    }
}

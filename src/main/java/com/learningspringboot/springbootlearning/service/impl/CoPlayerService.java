package com.learningspringboot.springbootlearning.service.impl;

import com.learningspringboot.springbootlearning.dto.CoPlayerDto;
import com.learningspringboot.springbootlearning.mapper.CoplayerMapper;
import com.learningspringboot.springbootlearning.mapper.UserMapper;
import com.learningspringboot.springbootlearning.model.CoPlayer;
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

    @Override
    public void showCoPlayers(int page, int start) {
        List<CoPlayerDto> coPlayerDtoList = new ArrayList<CoPlayerDto>();
        List<CoPlayer> coPlayers = coplayerMapper.findByIndex(start,page);
        for(int i = 0; i < coPlayers.size(); i++){
            String id = coPlayers.get(i).getUserId();
        }
    }
}

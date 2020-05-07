package com.learningspringboot.springbootlearning.service;

import com.learningspringboot.springbootlearning.dto.CoPlayerDto;

import java.util.List;

public interface ICoPlayerService {
    public List<CoPlayerDto> showCoPlayers(int page, int start);
    public CoPlayerDto findCoPlayer(String id);
    public boolean isPick(String id, String pickId);
    public boolean pick(String id, String pickId);
    public boolean cancelPick(String id, String pickId);
}

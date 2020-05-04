package com.learningspringboot.springbootlearning.service;

import com.learningspringboot.springbootlearning.dto.CoPlayerDto;

import java.util.List;

public interface ICoPlayerService {
    public List<CoPlayerDto> showCoPlayers(int page, int start);
}

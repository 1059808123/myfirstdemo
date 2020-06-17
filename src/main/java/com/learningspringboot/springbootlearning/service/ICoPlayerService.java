package com.learningspringboot.springbootlearning.service;

import com.learningspringboot.springbootlearning.dto.CoPlayerDto;
import com.learningspringboot.springbootlearning.model.Comments;
import com.learningspringboot.springbootlearning.model.User;

import java.util.List;

public interface ICoPlayerService {
    public List<CoPlayerDto> showCoPlayers(int page, int start);
    public CoPlayerDto findCoPlayer(String id);
    public boolean isPick(String id, String pickId);
    public boolean pick(String id, String pickId);
    public boolean cancelPick(String id, String pickId);
    public boolean hasCoPlayer(String id);
    public List<String> skillQuery(String id);
    public List<CoPlayerDto> showPicks(int page, int start, String userId);
    public void addComment(Comments comments);
    public User findUser(String userId);
    public List<Comments> findComments(String id);
}

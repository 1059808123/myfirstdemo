package com.learningspringboot.springbootlearning.dto;

import java.io.Serializable;
import java.util.List;

public class CoPlayerDto implements Serializable {
    private String userId;
    private List<String> skills;
    private String tag;
    private List<String> imgIntroduction;
    private String textIntroduction;
    private String audioIntroduction;
    private String userName;
    private String userPhoto;
    private String userGender;
    private String userAge;


}

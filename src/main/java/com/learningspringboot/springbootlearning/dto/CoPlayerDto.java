package com.learningspringboot.springbootlearning.dto;

import com.learningspringboot.springbootlearning.model.Skill;

import java.io.Serializable;
import java.util.List;

public class CoPlayerDto implements Serializable {
    private String userId;
    private List<Skill> skills;
    private String tag;
    private List<String> imgIntroduction;
    private String textIntroduction;
    private String audioIntroduction;
    private String userName;
    private String userPhoto;
    private String userGender;
    private String userAge;

    public CoPlayerDto(String userId, List<Skill> skills, String tag, List<String> imgIntroduction, String textIntroduction, String audioIntroduction, String userName, String userPhoto, String userGender, String userAge) {
        this.userId = userId;
        this.skills = skills;
        this.tag = tag;
        this.imgIntroduction = imgIntroduction;
        this.textIntroduction = textIntroduction;
        this.audioIntroduction = audioIntroduction;
        this.userName = userName;
        this.userPhoto = userPhoto;
        this.userGender = userGender;
        this.userAge = userAge;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<String> getImgIntroduction() {
        return imgIntroduction;
    }

    public void setImgIntroduction(List<String> imgIntroduction) {
        this.imgIntroduction = imgIntroduction;
    }

    public String getTextIntroduction() {
        return textIntroduction;
    }

    public void setTextIntroduction(String textIntroduction) {
        this.textIntroduction = textIntroduction;
    }

    public String getAudioIntroduction() {
        return audioIntroduction;
    }

    public void setAudioIntroduction(String audioIntroduction) {
        this.audioIntroduction = audioIntroduction;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }
}

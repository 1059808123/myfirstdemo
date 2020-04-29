package com.learningspringboot.springbootlearning.model;

import java.util.ArrayList;

public class User {
    private String userId;
    private String userName;
    private String userPhoto;
    private String userGender;
    private String userAge;
    private ArrayList<String> picks;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getGender() {
        return userGender;
    }

    public void setGender(String gender) {
        this.userGender = gender;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public ArrayList<String> getPicks() {
        return picks;
    }

    public void setPicks(ArrayList<String> picks) {
        this.picks = picks;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPhoto='" + userPhoto + '\'' +
                ", gender='" + userGender + '\'' +
                ", userAge='" + userAge + '\'' +
                ", picks=" + picks +
                '}';
    }
}

package com.learningspringboot.springbootlearning.model;

import java.io.Serializable;
import java.util.List;

public class Skill implements Serializable {
    private String userId;
    private String name;
    private String ability;
    private int price;
    private boolean isWarranted;
    private int hasNum;
    private String starComments;
    private int skillId;

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isWarranted() {
        return isWarranted;
    }

    public void setWarranted(boolean warranted) {
        isWarranted = warranted;
    }


    public int getHasNum() {
        return hasNum;
    }

    public void setHasNum(int hasNum) {
        this.hasNum = hasNum;
    }

    public String getStarComments() {
        return starComments;
    }

    public void setStarComments(String starComments) {
        this.starComments = starComments;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", ability='" + ability + '\'' +
                ", price=" + price +
                ", isWarranted=" + isWarranted +
                ", hasNum=" + hasNum +
                ", starComments='" + starComments + '\'' +
                ", skillId=" + skillId +
                '}';
    }
}

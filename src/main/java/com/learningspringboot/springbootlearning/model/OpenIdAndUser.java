package com.learningspringboot.springbootlearning.model;

/**
 * @program: springbootlearning
 * @description: Userid和openid关联表
 * @author: LiHongyan
 * @create: 2020-05-06 10:43
 **/
public class OpenIdAndUser {
    private String openId;
    private String userId;
    private String sessionKey;

    public OpenIdAndUser(String openId, String userId, String sessionKey) {
        this.openId = openId;
        this.userId = userId;
        this.sessionKey = sessionKey;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

package com.learningspringboot.springbootlearning.model;

/**
 * @program: springbootlearning
 * @description: openid结果包装对象
 * @author: LiHongyan
 * @create: 2020-05-06 10:53
 **/
public class Result {
    private String openId;
    private String session_key;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Override
    public String toString() {
        return "Result{" +
                "openId='" + openId + '\'' +
                ", session_key='" + session_key + '\'' +
                '}';
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }
}

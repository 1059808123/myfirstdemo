package com.learningspringboot.springbootlearning.model;

/**
 * @program: springbootlearning
 * @description: openid结果包装对象
 * @author: LiHongyan
 * @create: 2020-05-06 10:53
 **/
public class Result {
    private String openId;
    private String session;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    @Override
    public String toString() {
        return "Result{" +
                "openId='" + openId + '\'' +
                ", session='" + session + '\'' +
                '}';
    }
}

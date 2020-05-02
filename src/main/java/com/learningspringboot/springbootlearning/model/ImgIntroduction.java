package com.learningspringboot.springbootlearning.model;

import java.io.Serializable;

public class ImgIntroduction implements Serializable {
    private String imgId;
    private String imgUrl;
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "ImgIntroduction{" +
                "imgId='" + imgId + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}

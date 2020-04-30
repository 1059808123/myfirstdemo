package com.learningspringboot.springbootlearning.model;

import java.io.Serializable;

public class ImgIntroduction implements Serializable {
    private String imgId;
    private String imgUrl;

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
                "userId='" + imgId + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}

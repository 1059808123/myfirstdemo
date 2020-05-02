package com.learningspringboot.springbootlearning.model;

import java.io.Serializable;
import java.util.List;

public class CoPlayer implements Serializable {
    private String userId;
    private String tag;
    private String textIntroduction;
    private String audioId;
    private int imgId;
    private int commentId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTextIntroduction() {
        return textIntroduction;
    }

    public void setTextIntroduction(String textIntroduction) {
        this.textIntroduction = textIntroduction;
    }

    public String getAudioId() {
        return audioId;
    }

    public void setAudioId(String audioId) {
        this.audioId = audioId;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    @Override
    public String toString() {
        return "CoPlayer{" +
                "userId='" + userId + '\'' +
                ", tag='" + tag + '\'' +
                ", textIntroduction='" + textIntroduction + '\'' +
                ", audioId='" + audioId + '\'' +
                ", imgId=" + imgId +
                ", commentId=" + commentId +
                '}';
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }
}

package com.learningspringboot.springbootlearning.model;

public class Comments {
    private int commentId;
    private String name;
    private String commentPhoto;
    private String comment;
    private String starComment;
    private String userId;
    private String gameName;

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommentPhoto() {
        return commentPhoto;
    }

    public void setCommentPhoto(String commentPhoto) {
        this.commentPhoto = commentPhoto;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStarComment() {
        return starComment;
    }

    public void setStarComment(String starComment) {
        this.starComment = starComment;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "commentId=" + commentId +
                ", name='" + name + '\'' +
                ", commentPhoto='" + commentPhoto + '\'' +
                ", comment='" + comment + '\'' +
                ", starComment='" + starComment + '\'' +
                '}';
    }
}

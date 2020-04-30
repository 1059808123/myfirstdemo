package com.learningspringboot.springbootlearning.model;

public class Comments {
    private String commentId;
    private String name;
    private String commentPhoto;
    private String comment;
    private String starComment;

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
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
                "commentId='" + commentId + '\'' +
                ", name='" + name + '\'' +
                ", commentPhoto='" + commentPhoto + '\'' +
                ", comment='" + comment + '\'' +
                ", starComment='" + starComment + '\'' +
                '}';
    }
}

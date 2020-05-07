package com.learningspringboot.springbootlearning.model;

import java.io.Serializable;

public class Pick implements Serializable {
    private String fromUserId;
    private String pickId;
    private int id;

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getPickId() {
        return pickId;
    }

    public void setPickId(String pickId) {
        this.pickId = pickId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

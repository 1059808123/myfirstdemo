package com.learningspringboot.springbootlearning.model;

import java.io.Serializable;

public class Pick implements Serializable {
    private String fromPickId;
    private String pickId;
    private String id;

    public String getFromPickId() {
        return fromPickId;
    }

    public void setFromPickId(String fromPickId) {
        this.fromPickId = fromPickId;
    }

    public String getPickId() {
        return pickId;
    }

    public void setPickId(String pickId) {
        this.pickId = pickId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pick{" +
                "fromPickId='" + fromPickId + '\'' +
                ", pickId='" + pickId + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}

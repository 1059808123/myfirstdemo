package com.learningspringboot.springbootlearning.model;

import java.io.Serializable;

public class AudioIntroduction implements Serializable {
    private String id;
    private String src;
    private boolean bl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public boolean isBl() {
        return bl;
    }

    public void setBl(boolean bl) {
        this.bl = bl;
    }

    @Override
    public String toString() {
        return "AudioIntroduction{" +
                "id='" + id + '\'' +
                ", src='" + src + '\'' +
                ", bl=" + bl +
                '}';
    }
}

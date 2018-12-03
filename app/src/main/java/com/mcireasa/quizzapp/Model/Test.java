package com.mcireasa.quizzapp.Model;

import java.io.Serializable;

public class Test implements Serializable {
    private String text;
    private int time;
    private boolean active;
    private boolean mpublic;
    private String code;



    public Test() {

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isMpublic() {
        return mpublic;
    }

    public void setMpublic(boolean mpublic) {
        this.mpublic = mpublic;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return text;
    }
}

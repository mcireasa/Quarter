package com.mcireasa.quizzapp.Model;

import java.io.Serializable;
import java.util.List;

public class Test implements Serializable {
    private String name;
    private int time;
    private boolean active;
    private boolean mpublic;
    private String code;
    private List<Question> questions;


    public Test() {

    }

    public String getText() {
        return name;
    }

    public void setText(String text) {
        this.name = text;
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



    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return name;
    }
}

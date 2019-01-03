package com.mcireasa.quizzapp.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Test implements Serializable {
    private int id;
    private String name;
    private int time;
    private boolean active;
    private boolean mpublic;
    private boolean reverse;
    private int number_access;
    private String code;
    private List<Question> questions=new ArrayList<>();


    public Test() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isReverse() {
        return reverse;
    }

    public void setReverse(boolean reverse) {
        this.reverse = reverse;
    }

    public int getNumber_access() {
        return number_access;
    }

    public void setNumber_access(int number_access) {
        this.number_access = number_access;
    }

    @Override
    public String toString() {
        return name;
    }
}

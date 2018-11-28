package com.mcireasa.quizzapp.Model;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Question implements Serializable {
    private int id;
    private String text;
    private int nr_answers;
    private float score;
    private int time;
    private boolean type;
    private Bitmap image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNr_answers() {
        return nr_answers;
    }

    public void setNr_answers(int nr_answers) {
        this.nr_answers = nr_answers;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}

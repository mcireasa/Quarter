package com.mcireasa.quizzapp.Model;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Question implements Serializable {
    private int id;
    private String text;
    private int nr_answers;
    private float score;
    private int time;
    private boolean type;
    private Bitmap image;
    private List<Answer> answers=new ArrayList<>();

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

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", nr_answers=" + nr_answers +
                ", score=" + score +
                ", time=" + time +
                ", type=" + type +
                ", image=" + image +
                ", answers=" + answers +
                '}';
    }
}

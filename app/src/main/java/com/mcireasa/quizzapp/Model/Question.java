package com.mcireasa.quizzapp.Model;

import java.io.Serializable;

public class Question implements Serializable {
    private String text;
    private int nr_answers;

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

    public Question(String text, int nr_answers) {

        this.text = text;
        this.nr_answers = nr_answers;
    }
}

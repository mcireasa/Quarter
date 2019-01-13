package com.mcireasa.quizzapp.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DidQuestion implements Serializable {

    private int id;
    private int score;
    private int idQuestion;
    private List<MyAnswers> listAnswers=new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public List<MyAnswers> getListAnswers() {
        return listAnswers;
    }

    public void setListAnswers(List<MyAnswers> listAnswers) {
        this.listAnswers = listAnswers;
    }
}

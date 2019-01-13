package com.mcireasa.quizzapp.Model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MyTest implements Serializable {
    private int id;
    private int id_user;
    private int id_test;
    private int score;
    private LocalDateTime time_submitted;
    private long time;
    private List<DidQuestion> did_questionsList=new ArrayList<>();

    public MyTest(){
        score=0;
        time=0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_test() {
        return id_test;
    }

    public void setId_test(int id_test) {
        this.id_test = id_test;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public LocalDateTime getTime_submitted() {
        return time_submitted;
    }

    public void setTime_submitted(LocalDateTime time_submitted) {
        this.time_submitted = time_submitted;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public List<DidQuestion> getDid_questionsList() {
        return did_questionsList;
    }

    public void setDid_questionsList(List<DidQuestion> did_questionsList) {
        this.did_questionsList = did_questionsList;
    }

    @Override
    public String toString() {
        return "MyTest{" +
                "id=" + id +
                ", id_user=" + id_user +
                ", id_test=" + id_test +
                ", score=" + score +
                ", time_submitted=" + time_submitted +
                ", time=" + time +
                ", did_questionsList=" + did_questionsList +
                '}';
    }
}

package com.mcireasa.quizzapp;

public class test {
    private String quiz_code;
    private boolean tipTest;
    private String active_untill;
    private String category;
    private int access_code;
    private int timer;

    public test(String quiz_code, boolean tipTest, String active_untill, String category, int access_code, int timer) {
        this.quiz_code = quiz_code;
        this.tipTest = tipTest;
        this.active_untill = active_untill;
        this.category = category;
        this.access_code = access_code;
        this.timer = timer;
    }

    public String getQuiz_code() {
        return quiz_code;
    }

    public boolean isTipTest() {
        return tipTest;
    }

    public String getActive_untill() {
        return active_untill;
    }

    public String getCategory() {
        return category;
    }

    public int getAccess_code() {
        return access_code;
    }

    public int getTimer() {
        return timer;
    }

    public void setQuiz_code(String quiz_code) {
        this.quiz_code = quiz_code;
    }

    public void setTipTest(boolean tipTest) {
        this.tipTest = tipTest;
    }

    public void setActive_untill(String active_untill) {
        this.active_untill = active_untill;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAccess_code(int access_code) {
        this.access_code = access_code;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }



}

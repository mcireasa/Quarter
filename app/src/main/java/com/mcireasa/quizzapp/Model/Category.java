package com.mcireasa.quizzapp.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Category implements Serializable {
    private String name;
    private List<Test> tests;
    private List<Question> questions;

    public Category() {
        tests=new ArrayList<>();
        questions=new ArrayList<>();
    }

    public Category(String name, List<Test> tests, List<Question> questions) {
        this.name = name;
        this.tests = tests;
        this.questions = questions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void addTests(Test test) {
        tests.add(test);
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

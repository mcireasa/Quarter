package com.mcireasa.quizzapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.mcireasa.quizzapp.Model.Answer;
import com.mcireasa.quizzapp.Model.Category;
import com.mcireasa.quizzapp.Model.Question;
import com.mcireasa.quizzapp.Model.Test;
import com.mcireasa.quizzapp.Model.User;

import java.util.ArrayList;
import java.util.List;

public class DatabaseRepository implements DatabaseConstants {

    private SQLiteDatabase database;
    private DatabaseController controller;

    public DatabaseRepository(Context context) {
        controller = DatabaseController.getInstance(context);
    }

    public void open() {
        try {
            database = controller.getWritableDatabase();
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            database.close();
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
    }

    public long insertUser(User user) {
        if (user == null) {
            return -1;
        }

        ContentValues contentValues = new ContentValues();

        contentValues.put(NAME, user.getUsername());
        contentValues.put(EMAIL, user.getEmail());
        contentValues.put(PASSWORD, user.getPassword());
        contentValues.put(TYPE, user.getType());

        return database.insert(USERS,
                null, contentValues);
    }

    public List<User> getUser(){

        Cursor cursor = database.rawQuery("SELECT * FROM  " + USERS + ";", null);


        List<User> result = new ArrayList<>();

        while(cursor.moveToNext()) {
            User user = new User();
            user.setEmail(cursor.getString(cursor.getColumnIndex(EMAIL)));
            user.setUsername(cursor.getString(cursor.getColumnIndex(NAME)));
            user.setPassword(cursor.getString(cursor.getColumnIndex(PASSWORD)));
            user.setType(cursor.getInt(cursor.getColumnIndex(TYPE)));
            result.add(user);

        }
        cursor.close();
        return result;
    }


    public long insertTest(Test test) {
        if (test == null) {
            return -1;
        }

        ContentValues contentValues = new ContentValues();

        contentValues.put(NAME_TEST, test.getText());
        contentValues.put(ACTIVE, test.isActive());
        contentValues.put(PUBLIC, test.isMpublic());
        contentValues.put(COD_ACCES, test.getCode());
        contentValues.put(NUMBER_ACCES, test.getNumber_access());
        contentValues.put(REVERSE, test.isReverse());


        return database.insert(TESTS,
                null, contentValues);
    }


    public List<Test> getTests(){

        Cursor cursor = database.rawQuery("SELECT * FROM  " + TESTS + ";", null);


        List<Test> result = new ArrayList<>();

        while(cursor.moveToNext()) {
            Test test = new Test();
            test.setId(cursor.getInt(cursor.getColumnIndex(TESTS_ID)));
            test.setText(cursor.getString(cursor.getColumnIndex(NAME_TEST)));
            test.setActive(Boolean.valueOf(String.valueOf(cursor.getColumnIndex(ACTIVE))));
            test.setMpublic(Boolean.valueOf(String.valueOf(cursor.getColumnIndex(PUBLIC))));
            test.setCode(cursor.getString(cursor.getColumnIndex(COD_ACCES)));
            test.setNumber_access(cursor.getInt(cursor.getColumnIndex(NUMBER_ACCES)));
            result.add(test);

        }
        cursor.close();
        return result;
    }


    public long insertCategory(Category category) {
        if (category == null) {
            return -1;
        }

        ContentValues contentValues = new ContentValues();

        contentValues.put(CATEGORY_NAME, category.getName());


        return database.insert(CATEGORIES,
                null, contentValues);
    }

    public List<Category> getCategories(){

        Cursor cursor = database.rawQuery("SELECT * FROM  " + CATEGORIES + ";", null);

        List<Category> result = new ArrayList<>();


        while (cursor.moveToNext()) {
            Category category = new Category();
            category.setId(cursor.getInt(cursor.getColumnIndex(CATEGORIES_ID)));
            category.setName(cursor.getString(cursor.getColumnIndex(CATEGORY_NAME)));
            result.add(category);
        }

            cursor.close();

        return result;
    }



    public long insertQuestion(Question question, Integer testId) {
        if (question == null) {
            return -1;
        }

        ContentValues contentValues = new ContentValues();

        contentValues.put(QUESTION_TEXT, question.getText());
        contentValues.put(SCORE, question.getScore());
        contentValues.put(TIME, question.getTime());
        contentValues.put(TEST_ID, testId);

        //TODO - de verificat ce e cu question type in model
        //TODO de vazut ce facem cu testId


        return database.insert(QUESTIONS,
                null, contentValues);
    }


    public List<Question> getQuestions(){

        Cursor cursor = database.rawQuery("SELECT * FROM  " + QUESTIONS + ";", null);

        List<Question> result = new ArrayList<>();


        while (cursor.moveToNext()) {

            Question question = new Question();

            question.setId(cursor.getInt(cursor.getColumnIndex(QUESTION_ID)));
            question.setText(cursor.getString(cursor.getColumnIndex(QUESTION_TEXT)));
            question.setScore(cursor.getInt(cursor.getColumnIndex(SCORE)));
            question.setTime(cursor.getInt(cursor.getColumnIndex(TIME)));

            //TODO de adaugat si aici type

            result.add(question);
        }

        cursor.close();

        return result;
    }

    public List<Question> getQuestionsbyId(int id){

        Cursor cursor = database.rawQuery("SELECT * FROM  " + QUESTIONS + " WHERE TEST_ID="+id+";", null);

        List<Question> result = new ArrayList<>();


        while (cursor.moveToNext()) {

            Question question = new Question();

            question.setId(cursor.getInt(cursor.getColumnIndex(QUESTION_ID)));
            question.setText(cursor.getString(cursor.getColumnIndex(QUESTION_TEXT)));
            question.setScore(cursor.getInt(cursor.getColumnIndex(SCORE)));
            question.setTime(cursor.getInt(cursor.getColumnIndex(TIME)));



            result.add(question);
        }

        cursor.close();

        return result;
    }


    public long insertAnswer(Answer answer, Integer questionId) {
        if (answer == null) {
            return -1;
        }

        ContentValues contentValues = new ContentValues();

        contentValues.put(ANSWER_TEXT, answer.getText());
        contentValues.put(CORRECT_FLAG, answer.isCorrect());
        contentValues.put(QUESTION_ID, questionId);

        //TODO - de vazut cu idQuestion


        return database.insert(ANSWERS,
                null, contentValues);
    }


    public List<Answer> getAnswers(){

        Cursor cursor = database.rawQuery("SELECT * FROM  " + ANSWERS + ";", null);

        List<Answer> result = new ArrayList<>();


        while (cursor.moveToNext()) {

            Answer answer = new Answer();

            answer.setId(cursor.getInt(cursor.getColumnIndex(ANSWER_ID)));
            answer.setCorrect( cursor.getInt(cursor.getColumnIndex(CORRECT_FLAG)) > 0);
            answer.setText(cursor.getString(cursor.getColumnIndex(ANSWER_TEXT)));

            result.add(answer);
        }

        cursor.close();

        return result;
    }
    public List<Answer> getAnswersById(int id){

        Cursor cursor = database.rawQuery("SELECT * FROM  " + ANSWERS +" WHERE id_question="+id+ ";", null);

        List<Answer> result = new ArrayList<>();


        while (cursor.moveToNext()) {

            Answer answer = new Answer();

            answer.setId(cursor.getInt(cursor.getColumnIndex(ANSWER_ID)));
            answer.setCorrect( cursor.getInt(cursor.getColumnIndex(CORRECT_FLAG)) > 0);
            answer.setText(cursor.getString(cursor.getColumnIndex(ANSWER_TEXT)));

            result.add(answer);
        }

        cursor.close();

        return result;
    }





















}

package com.mcireasa.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.mcireasa.quizzapp.Model.Question;

public class QuestionFormActivity extends AppCompatActivity {

    Question newQuestion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_form);
         newQuestion=new Question();


    }

    public void add(View view) {
        Intent addIntent = new Intent(this, AnswersFormActivity.class);
        addIntent.putExtra("New Question",newQuestion);
        startActivity(addIntent);
    }
}

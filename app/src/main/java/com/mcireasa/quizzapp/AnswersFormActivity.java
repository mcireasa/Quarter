package com.mcireasa.quizzapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.mcireasa.quizzapp.Model.Category;
import com.mcireasa.quizzapp.Model.Question;

public class AnswersFormActivity extends AppCompatActivity {

    Question question;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers_form);
        question=(Question)getIntent().getSerializableExtra("New Question");





    }
}

package com.mcireasa.quizzapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.mcireasa.quizzapp.Model.Question;
import com.mcireasa.quizzapp.Model.Test;

public class NrQuestionsForm extends AppCompatActivity {

    EditText nr_questions;
    Test test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nr_questions_form);
        nr_questions=(EditText)findViewById(R.id.nrQuestions);
        test =(Test)getIntent().getSerializableExtra("Test");
    }

    public boolean validation(){
        boolean valid=true;
        if(nr_questions==null||"".equals(nr_questions.getText().toString())){
            nr_questions.setError("You have to have at least 1 question");
            valid=false;
        }else if(!TextUtils.isDigitsOnly(nr_questions.getText())){
            nr_questions.setError("Only digits");
            valid=false;
        }else if(Integer.parseInt(nr_questions.getText().toString())>30||Integer.parseInt(nr_questions.getText().toString())<1){
            nr_questions.setError("You have to have between 1 and 30 questions");
            valid=false;
        }
        return valid;
    }

    public void add(View view) {
        if(validation()) {

            int nr = Integer.parseInt(nr_questions.getText().toString());
            for (int i = 0; i < nr; i++) {
                Intent addIntent = new Intent(this, QuestionFormActivity.class);
                startActivityForResult(addIntent, 1);
            }
            Intent explicitIntent =
                    new Intent();
            explicitIntent.putExtra("Test", test);
            setResult(RESULT_OK, explicitIntent);
            finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==1&&resultCode==RESULT_OK){
            Question question =(Question) data.getSerializableExtra("Question");
            test.getQuestions().add(question);
        }
    }

}

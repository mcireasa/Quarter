package com.mcireasa.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.mcireasa.quizzapp.Model.Answer;
import com.mcireasa.quizzapp.Model.Category;
import com.mcireasa.quizzapp.Model.Question;

public class AnswersFormActivity extends AppCompatActivity {

    Answer answer=new Answer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers_form);






    }

    public void Finish(View view){
        Intent explicitIntent =
                new Intent();
        explicitIntent.putExtra("Answer", answer);
        setResult(RESULT_OK,explicitIntent);
        finish();
    }
}

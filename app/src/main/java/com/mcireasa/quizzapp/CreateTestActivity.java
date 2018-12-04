package com.mcireasa.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class CreateTestActivity extends AppCompatActivity{

    String quizCode, activeUntil, Category, aC,tM;
    boolean Active, Private;
    int accessCode, Timer;

    EditText quiz_code, active, active_until, timer;
    EditText category, access_code;
    RadioButton activeb, privateb;

    test t;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_test);
    }

    public void onClickAddQuiz(View view) {
            quiz_code = (EditText)findViewById(R.id.quiz_code);
            active_until = (EditText)findViewById(R.id.active_until);
            category = (EditText)findViewById(R.id.category);
            access_code = (EditText)findViewById(R.id.access_code);
            activeb = (RadioButton)findViewById(R.id.activebtn);
            privateb = (RadioButton)findViewById(R.id.privatebtn);
            timer = (EditText)findViewById(R.id.timer);

            quizCode = quiz_code.getText().toString();
            activeUntil = active_until.getText().toString();
            Category = category.getText().toString();
            aC = access_code.getText().toString();
            accessCode = Integer.parseInt(aC);
            tM =timer.getText().toString();
            Timer = Integer.parseInt(tM);


            if(activeb.isChecked())
            {
                Active = true;
                test t = new test(quizCode, Active, activeUntil, Category,accessCode,Timer );

            }else if(privateb.isChecked()){
                Private = true;
                test t = new test(quizCode, Private, activeUntil, Category,accessCode,Timer );
            }


            Intent intent = new Intent(CreateTestActivity.this,QuestionFormActivity.class);
            startActivity(intent);

    }
}

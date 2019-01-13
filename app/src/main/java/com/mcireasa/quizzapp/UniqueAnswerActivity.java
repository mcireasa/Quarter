package com.mcireasa.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.mcireasa.quizzapp.Model.Answer;
import com.mcireasa.quizzapp.Model.DidQuestion;
import com.mcireasa.quizzapp.Model.MyAnswers;
import com.mcireasa.quizzapp.Model.MyTest;
import com.mcireasa.quizzapp.Model.Question;
import com.mcireasa.quizzapp.Model.Test;

public class UniqueAnswerActivity extends AppCompatActivity {

    Question q;
    TextView title,count,score;
    RadioGroup rg;
    Test test;
    MyTest myTest;
    int nr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unique_answer);
        q=(Question)getIntent().getSerializableExtra("question") ;
        title=(TextView)findViewById(R.id.text_view_question);
        nr=(Integer) getIntent().getIntExtra("number",1);
        test=(Test)getIntent().getSerializableExtra("test");
        int total=test.getQuestions().size();

        myTest=(MyTest)getIntent().getSerializableExtra("myTest") ;
        rg=(RadioGroup)findViewById(R.id.radioGroupAns) ;
        title.setText(q.getText());
        score=(TextView)findViewById(R.id.text_view_score) ;
        score.setText("Score:"+myTest.getScore());
        count=(TextView)findViewById(R.id.text_view_question_count) ;
        count.setText(nr+"/"+total);
        for(Answer a:q.getAnswers()){
            RadioButton b=new RadioButton(this);
            b.setText(a.getText());
            b.setId(a.getId());
            rg.addView(b);
        }

    }

    public void next(View view) {

        DidQuestion didQuestion = new DidQuestion();
        didQuestion.setIdQuestion(q.getId());
        boolean ok = true;
        for (Answer a : q.getAnswers()) {

            RadioButton radioButton = (RadioButton) findViewById(a.getId());
            if (radioButton.isChecked()) {
                MyAnswers myAnswers = new MyAnswers();
                myAnswers.setId(a.getId());
                if (a.isCorrect()) {
                } else {
                    ok = false;
                }
            }

        }
        if (ok == true) {
            didQuestion.setScore((int) q.getScore());
            myTest.setScore(myTest.getScore() + didQuestion.getScore());
        }
        myTest.getDid_questionsList().add(didQuestion);
        Intent intent;
        if (nr != test.getQuestions().size()) {


            int numb = 0;
            for (Answer a : test.getQuestions().get(nr).getAnswers()) {
                if (a.isCorrect())
                    numb++;
            }
            if (numb < 2) {
                intent = new Intent(this, UniqueAnswerActivity.class);
            } else {
                intent = new Intent(this, MultiAnswerActivity.class);
            }
            intent.putExtra("question", test.getQuestions().get(nr));
            intent.putExtra("myTest", myTest);
            intent.putExtra("number", nr + 1);
            intent.putExtra("test", test);

            startActivity(intent);
        }else{
            intent=new Intent(this,FinishTestActivity.class);
            intent.putExtra("myTest", myTest);
            startActivity(intent);
        }
        finish();
    }
}


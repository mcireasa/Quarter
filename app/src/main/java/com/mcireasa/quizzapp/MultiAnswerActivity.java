package com.mcireasa.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mcireasa.quizzapp.Model.Answer;
import com.mcireasa.quizzapp.Model.DidQuestion;
import com.mcireasa.quizzapp.Model.MyAnswers;
import com.mcireasa.quizzapp.Model.MyTest;
import com.mcireasa.quizzapp.Model.Question;
import com.mcireasa.quizzapp.Model.Test;

public class MultiAnswerActivity extends AppCompatActivity {

    LinearLayout l;
    Question q;
    Test test;
    TextView title,count,score;
    MyTest myTest;;
    int nr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.BlackText);

        setContentView(R.layout.activity_multi_answer);
        q=(Question)getIntent().getSerializableExtra("question") ;
        nr=(Integer) getIntent().getIntExtra("number",1);
        test=(Test)getIntent().getSerializableExtra("test");
        int total=test.getQuestions().size();
        myTest=(MyTest)getIntent().getSerializableExtra("myTest") ;
        l=(LinearLayout)findViewById(R.id.checkboxgroup);
        title=(TextView)findViewById(R.id.text_view_question);
        score=(TextView)findViewById(R.id.text_view_score) ;
        score.setText("Score:"+myTest.getScore());
        count=(TextView)findViewById(R.id.text_view_question_count) ;
        count.setText(nr+"/"+total);
        title.setText(q.getText());
        for(Answer a:q.getAnswers()){
            CheckBox checkBox=new CheckBox(this);
            checkBox.setText(a.getText());
            checkBox.setId(a.getId());
            l.addView(checkBox);
        }
    }


    public void next(View view){

        DidQuestion didQuestion=new DidQuestion();
        didQuestion.setIdQuestion(q.getId());
        boolean ok=true;
        for(Answer a:q.getAnswers()){

            CheckBox checkBox=(CheckBox)findViewById(a.getId());
            if(checkBox.isChecked()){
                MyAnswers myAnswers=new MyAnswers();
                myAnswers.setId(a.getId());
                if(a.isCorrect()){}else{ok=false;}
            }

        }
        if(ok==true){
            didQuestion.setScore((int) q.getScore());
            myTest.setScore(myTest.getScore()+didQuestion.getScore());}
            myTest.getDid_questionsList().add(didQuestion);
        Intent intent;
        if (nr != test.getQuestions().size()){


        int numb=0;
        for(Answer a:test.getQuestions().get(nr).getAnswers()){
            if(a.isCorrect())
                numb++;
        }
        if(numb<2){
            intent=new Intent(this,UniqueAnswerActivity.class);}
        else
        {
            intent=new Intent(this,MultiAnswerActivity.class);
        }
        intent.putExtra("question",test.getQuestions().get(nr));
        intent.putExtra("myTest",myTest);
        intent.putExtra("number",nr+1);
        intent.putExtra("test",test);

        startActivity(intent);}else{
            intent=new Intent(this,FinishTestActivity.class);
            intent.putExtra("myTest", myTest);
            startActivity(intent);
        }

    finish();
    }

    }



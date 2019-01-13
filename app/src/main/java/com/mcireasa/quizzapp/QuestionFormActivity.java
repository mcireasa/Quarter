package com.mcireasa.quizzapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.mcireasa.quizzapp.Model.Answer;
import com.mcireasa.quizzapp.Model.Question;
import com.mcireasa.quizzapp.Model.Test;
import com.mcireasa.quizzapp.database.DatabaseRepository;

public class QuestionFormActivity extends AppCompatActivity {

    EditText et_nrAnswers,et_text,et_score,et_time;
    int nr;
    Question newQuestion=new Question();

    private DatabaseRepository repository;

    Test test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_form);
         newQuestion=new Question();
        et_text=(EditText)findViewById(R.id.QuestionText);
        et_score=(EditText)findViewById(R.id.ScoreQuestion);
        et_time=(EditText)findViewById(R.id.TimeQuestion);
        et_nrAnswers=(EditText)findViewById(R.id.nrq);
        test =(Test)getIntent().getSerializableExtra("Test");



    }

    public boolean validation(){

        boolean valid=true;
        if(et_text.getText()==null||"".equals((et_text.getText().toString()))){
            et_text.setError("A question has to have a text");
            valid=false;
        }
        if(et_nrAnswers.getText()==null||"".equals((et_nrAnswers.getText().toString()))){
            et_nrAnswers.setError("A question has to have at least one question");
            valid=false;
        }else
        if(!TextUtils.isDigitsOnly(et_nrAnswers.getText())){
            et_nrAnswers.setError("Only digits");
            valid=false;
        }else
        if(Integer.parseInt(et_nrAnswers.getText().toString())<1||
                Integer.parseInt(et_nrAnswers.getText().toString())>8){
            et_nrAnswers.setError("This number must be smaller than 9 and higher than 0");
            valid=false;
        }

        if(et_score.getText()==null||"".equals((et_score.getText().toString()))){}else
        if(!TextUtils.isDigitsOnly(et_score.getText())){
            et_score.setError("Only digits");
            valid=false;
        }else
        if(Integer.parseInt(et_score.getText().toString())<0||
                Integer.parseInt(et_score.getText().toString())>100){
            et_score.setError("This number must be smaller than 100 and higher than 0");
            valid=false;
        }

        if(et_score.getText()==null||"".equals((et_score.getText().toString()))){}
        else
        if(!TextUtils.isDigitsOnly(et_time.getText())){
            et_time.setError("Only digits");
            valid=false;
        }

        return valid;
    }

    public void add(View view) {
            if(validation()) {
                et_nrAnswers = (EditText) findViewById(R.id.nrq);
                newQuestion.setText(et_text.getText().toString());
                if(et_score.getText()==null||"".equals((et_score.getText().toString()))){}
                else{
                newQuestion.setScore(Integer.parseInt(et_score.getText().toString()));}
                if(et_time.getText()==null||"".equals((et_time.getText().toString()))){}
                else{
                    newQuestion.setTime(Integer.parseInt(et_time.getText().toString()));}

                nr = Integer.parseInt(et_nrAnswers.getText().toString());
                newQuestion.setNr_answers(nr);

//                int nr=0;
//                for(Answer ans:newQuestion.getAnswers()){
//                    if(ans.isCorrect()){
//                        nr++;
//                    }
//                }
//                if(nr>1){
//                    newQuestion.setType(true);
//                }else {
//                    newQuestion.setType(false);
//                }

                repository = new DatabaseRepository(getApplicationContext());
                repository.open();

                newQuestion.setId(Integer.valueOf(String.valueOf(repository.insertQuestion(newQuestion, test.getId()))));



                for (int i = 0; i < nr; i++) {
                    Intent addIntent = new Intent(this, AnswersFormActivity.class);
                    addIntent.putExtra("idQuestion", newQuestion.getId());
                    startActivityForResult(addIntent, 1);
                }

                repository.close();

                Intent explicitIntent =
                        new Intent();
                explicitIntent.putExtra("Question", newQuestion);
                setResult(RESULT_OK, explicitIntent);
                finish();
            }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==1&&resultCode==RESULT_OK){
            Answer answer=(Answer)data.getSerializableExtra("Answer");
            newQuestion.getAnswers().add(answer);
        }
    }
}

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

public class QuestionFormActivity extends AppCompatActivity {

    EditText et_nrAnswers,et_text,et_score,et_time;
    int nr;
    Question newQuestion=new Question();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_form);
         newQuestion=new Question();


    }

    public boolean validation(){
        boolean valid=true;
        if(et_text.getText()!=null){
            et_text.setError("A question has to have a text");
            valid=false;
        }
        if(et_nrAnswers.getText()!=null){
            et_text.setError("A question has to have at least one question");
            valid=false;
        }
        if(et_score.getText()!=null){
        if(!TextUtils.isDigitsOnly(et_score.getText())){
            et_score.setError("Only digits");
            valid=false;
        }else
        if(Integer.parseInt(et_score.getText().toString())<0||
                Integer.parseInt(et_score.getText().toString())>100){
            et_nrAnswers.setError("This number must be smaller than 100 and higher than 0");
            valid=false;
        }}
        if(et_time.getText()!=null){
        if(!TextUtils.isDigitsOnly(et_time.getText())){
            et_time.setError("Only digits");
            valid=false;
        }}
        if(!TextUtils.isDigitsOnly(et_nrAnswers.getText())){
            et_nrAnswers.setError("Only digits");
            valid=false;
        }else
        if(Integer.parseInt(et_nrAnswers.getText().toString())<1||
                Integer.parseInt(et_nrAnswers.getText().toString())>8){
            et_nrAnswers.setError("This number must be smaller than 9 and higher than 0");
            valid=false;
        }
        return valid;
    }

    public void add(View view) {

            et_nrAnswers = (EditText) findViewById(R.id.nrq);
            nr = Integer.parseInt(et_nrAnswers.getText().toString());
            for (int i = 0; i < nr; i++) {
                Intent addIntent = new Intent(this, AnswersFormActivity.class);
                startActivityForResult(addIntent, 1);
            }
            Intent explicitIntent =
                    new Intent();
            explicitIntent.putExtra("Question", newQuestion);
            setResult(RESULT_OK, explicitIntent);
            finish();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==1&&resultCode==RESULT_OK){
            Answer answer=(Answer)data.getSerializableExtra("Answer");
            newQuestion.getAnswers().add(answer);
        }
    }
}

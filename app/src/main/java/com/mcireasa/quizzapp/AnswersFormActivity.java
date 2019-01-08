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
import com.mcireasa.quizzapp.database.DatabaseRepository;

public class AnswersFormActivity extends AppCompatActivity {

    Answer answer=new Answer();
    EditText answer_text;
    CheckBox checkBox;
    Integer questionId;

    private DatabaseRepository repository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers_form);
        answer_text=(EditText)findViewById(R.id.AnswerText);
        checkBox=(CheckBox)findViewById(R.id.checkBoxIsCorrect);
        questionId = getIntent().getIntExtra("idQuestion", 1);


    }

    public boolean validation(){

        boolean valid= true;


        if(answer_text.getText()==null||"".equals((answer_text.getText().toString()))){
            answer_text.setError("An answer has to have a text");
            valid=false;
        }
        return valid;
    }

    public void finish(View view){

        if(validation()) {

            answer.setText(answer_text.getText().toString());
            answer.setCorrect(checkBox.isChecked());

            repository = new DatabaseRepository(getApplicationContext());
            repository.open();


            answer.setId(Integer.valueOf(String.valueOf(repository.insertAnswer(answer, questionId))));

            Intent explicitIntent =
                    new Intent();
            explicitIntent.putExtra("Answer", answer);
            setResult(RESULT_OK, explicitIntent);
            finish();
        }
    }
}

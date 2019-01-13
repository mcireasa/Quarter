package com.mcireasa.quizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mcireasa.quizzapp.Model.Answer;
import com.mcireasa.quizzapp.Model.MyTest;
import com.mcireasa.quizzapp.Model.Question;
import com.mcireasa.quizzapp.Model.Test;
import com.mcireasa.quizzapp.Model.User;
import com.mcireasa.quizzapp.database.DatabaseRepository;

import java.util.List;

public class StartTestActivity extends AppCompatActivity {

    TextView name;
    Button start;
    Test test;
    User user;

    private DatabaseRepository repository;
    List<Question> questions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.BlackText);

        setContentView(R.layout.star_test_activity);
        test= (Test) getIntent().getSerializableExtra("test");


        name = findViewById(R.id.test_name);
        start = findViewById(R.id.start_test);

        name.setText(test.getText());

        user= (User) getIntent().getSerializableExtra("User");



        repository = new DatabaseRepository(getApplicationContext());
        repository.open();


        questions = repository.getQuestionsbyId(test.getId());

        for(Question q:questions){
            List<Answer>answers=repository.getAnswersById(q.getId());
            q.setAnswers(answers);
        }
        test.setQuestions(questions);

        repository.close();
    }

    public void start(View view){
        MyTest myTest=new MyTest();
        myTest.setId_test(test.getId());
        myTest.setId_user(user.getId());
       Question q=test.getQuestions().get(0);
            Intent intent;

            int nr=0;
            for(Answer a:q.getAnswers()){
                if(a.isCorrect())
                    nr++;
            }
            if(nr<2){
        intent=new Intent(this,UniqueAnswerActivity.class);}
        else
            {
                 intent=new Intent(this,MultiAnswerActivity.class);
            }
        intent.putExtra("question",q);
            intent.putExtra("myTest",myTest);
            intent.putExtra("number",1);
            intent.putExtra("test",test);

        startActivity(intent);}


}

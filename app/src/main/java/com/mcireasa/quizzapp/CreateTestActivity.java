package com.mcireasa.quizzapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.mcireasa.quizzapp.Model.Category;
import com.mcireasa.quizzapp.Model.Question;
import com.mcireasa.quizzapp.Model.Test;
import com.mcireasa.quizzapp.Model.User;

import java.util.ArrayList;
import java.util.List;

public class CreateTestActivity extends AppCompatActivity{

    String nameTest,access_code_test;
    boolean isactive,ispublic,reverse;
    int nr_access,time_test;
    Test test=new Test();

    EditText name,access_code,time,number_of_access;
    CheckBox active, mpublic,mreverse;



    Spinner spinner;
    private ArrayAdapter<Category> adapter;
    User user;
    List<Category> categories;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_test);
        user= (User) getIntent().getSerializableExtra("User");
        spinner = findViewById(R.id.CatgeorySpinner);
        adapter = new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item,
                user.getCategories());
        spinner.setAdapter(adapter);
    }

    public void onClickAddQuiz(View view) {
            name=(EditText)findViewById(R.id.nameFormTest) ;
            active=(CheckBox)findViewById(R.id.checkBoxActive);
            mpublic=(CheckBox)findViewById(R.id.checkBoxPublic) ;
            mreverse=(CheckBox)findViewById(R.id.checkBoxReverse) ;
            time=(EditText)findViewById(R.id.Timeformtext) ;

            access_code = (EditText)findViewById(R.id.AccessCodeText);
            number_of_access = (EditText)findViewById(R.id.nrAccesstext);
            nameTest=name.getText().toString();
            time_test=Integer.parseInt(time.getText().toString());
            isactive=active.isChecked();
            ispublic=mpublic.isChecked();
            if(!ispublic){
                access_code_test=access_code.getText().toString();
            }
            nr_access=Integer.parseInt(number_of_access.getText().toString());
            reverse=mreverse.isChecked();



            Intent intent = new Intent(CreateTestActivity.this,QuestionFormActivity.class);
            startActivityForResult(intent,1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==1&&resultCode==RESULT_OK){
           Question question =(Question) data.getSerializableExtra("Question");
            test.getQuestions().add(question);
        }
    }


}

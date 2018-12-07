package com.mcireasa.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.mcireasa.quizzapp.Model.Category;
import com.mcireasa.quizzapp.Model.User;

import java.util.ArrayList;
import java.util.List;

public class CreateTestActivity extends AppCompatActivity{

    String nameTest,access_code_test;
    boolean isactive,ispublic,reverse;
    int nr_access,time_test,reverse_test;

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
            time=(EditText)findViewById(R.id.Timeformtext) ;
            access_code = (EditText)findViewById(R.id.AccessCodeText);
            number_of_access = (EditText)findViewById(R.id.nrAccesstext);
            nameTest=name.getText().toString();
            time_test=Integer.parseInt(time.getText().toString());
            isactive=active.isChecked();
            ispublic=active.isChecked();


            Intent intent = new Intent(CreateTestActivity.this,QuestionFormActivity.class);
            startActivity(intent);

    }


}

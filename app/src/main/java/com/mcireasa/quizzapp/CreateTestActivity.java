package com.mcireasa.quizzapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.mcireasa.quizzapp.Model.Category;
import com.mcireasa.quizzapp.Model.Question;
import com.mcireasa.quizzapp.Model.Test;
import com.mcireasa.quizzapp.Model.User;
import com.mcireasa.quizzapp.database.DatabaseRepository;

import java.util.ArrayList;
import java.util.List;

public class CreateTestActivity extends AppCompatActivity{

    String nameTest,access_code_test;
    boolean isactive,ispublic,reverse;
    int nr_access,time_test;
    Test test=new Test();

    EditText name,access_code,time,number_of_access;
    CheckBox active, mpublic,mreverse;

    private DatabaseRepository repository;


    Spinner spinner;
    private ArrayAdapter<Category> adapter;
    User user;
    List<Category> categories;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_test);
        user= (User) getIntent().getSerializableExtra("User");

        repository = new DatabaseRepository(getApplicationContext());
        repository.open();

        List<Category> categoryList =repository.getCategories();
        spinner = findViewById(R.id.CatgeorySpinner);
        adapter = new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item,
                categoryList);
        spinner.setAdapter(adapter);


        name=(EditText)findViewById(R.id.nameFormTest) ;
        active=(CheckBox)findViewById(R.id.checkBoxActive);
        mpublic=(CheckBox)findViewById(R.id.checkBoxPublic) ;
        mreverse=(CheckBox)findViewById(R.id.checkBoxReverse) ;
        time=(EditText)findViewById(R.id.Timeformtext) ;

        access_code = (EditText)findViewById(R.id.AccessCodeText);
        number_of_access = (EditText)findViewById(R.id.nrAccesstext);
    }


    public boolean validation(){
        boolean valid=true;


        if(name.getText()==null||"".equals((name.getText().toString()))){
            name.setError("A test has to have a name");
            valid=false;
        }
        if(time.getText()==null||"".equals((time.getText().toString()))){
        }else
        if(!TextUtils.isDigitsOnly(time.getText())){
            time.setError("Only digits");
            valid=false;
        }

        if(mpublic.isChecked()){}else
            if(access_code.getText()==null||"".equals((access_code.getText().toString()))){
                access_code.setError("This test has to have an access code");
                valid=false;
            }



        return valid;
    }
    public void onClickAddQuiz(View view) {
            if(validation()){
            test.setText(name.getText().toString());
            if(time==null||"".equals((time.getText().toString()))){} else{
            test.setTime(Integer.parseInt(time.getText().toString()));}
            test.setActive(active.isChecked());
            test.setMpublic(mpublic.isChecked());
            if(!ispublic){
                test.setCode(access_code.getText().toString());
            }
            if(number_of_access==null||"".equals((number_of_access.getText().toString()))){} else{
            test.setNumber_access(Integer.parseInt(number_of_access.getText().toString()));}
            test.setReverse(mreverse.isChecked());

            repository = new DatabaseRepository(getApplicationContext());
            repository.open();

            test.setId(Integer.valueOf(String.valueOf(repository.insertTest(test))));
            repository.close();


            Intent intent = new Intent(CreateTestActivity.this,NrQuestionsForm.class);
            intent.putExtra("Test",test);

            startActivityForResult(intent,1);}

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==1&&resultCode==RESULT_OK){
            test =(Test) data.getSerializableExtra("Test");

        }
    }

}

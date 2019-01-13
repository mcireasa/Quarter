package com.mcireasa.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mcireasa.quizzapp.Model.Test;
import com.mcireasa.quizzapp.Model.User;
import com.mcireasa.quizzapp.database.DatabaseRepository;

import java.util.ArrayList;
import java.util.List;

public class EnterPINActivity extends AppCompatActivity {

    private DatabaseRepository repository;

    EditText pin;
    Button enter;
    User user;

    List<Test> testList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_test);
        pin = findViewById(R.id.textView5);
        enter = findViewById(R.id.button3);
        user= (User) getIntent().getSerializableExtra("User");




    }
            public void clickEnter(View view){

                repository = new DatabaseRepository(getApplicationContext());
                repository.open();

                testList = repository.getTests();

                for(Test t:testList)
                    if(t.getCode().equals(pin.getText().toString()))
                    {
                        Intent intent=new Intent(this,StartTestActivity.class);
                        intent.putExtra("test", t);
                        intent.putExtra("User",user);

                        startActivity(intent);
                    }

    }


//    public void start_test_activity(View view)
//    {
//        Intent intentStartTest=new Intent(EnterPINActivity.this, MultiAnswerActivity.class );
//        startActivity(intentStartTest);
//    }

    public void onClickSearch(View view)
    {

        Intent intentSearch=new Intent(EnterPINActivity.this, SearchActivity.class );
        startActivity(intentSearch);
    }
}

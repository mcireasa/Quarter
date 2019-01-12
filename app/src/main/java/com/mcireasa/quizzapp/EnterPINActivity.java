package com.mcireasa.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mcireasa.quizzapp.Model.Test;
import com.mcireasa.quizzapp.database.DatabaseRepository;

import java.util.ArrayList;
import java.util.List;

public class EnterPINActivity extends AppCompatActivity {

    private DatabaseRepository repository;

    EditText pin;
    Button enter;

    List<Test> testList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_test);
        pin = findViewById(R.id.textView5);
        enter = findViewById(R.id.button3);
        enter.setOnClickListener(enter());


    }

    private View.OnClickListener enter() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                repository = new DatabaseRepository(getApplicationContext());
                repository.open();

                testList = repository.getTests();

                for(int i=0;i<testList.size();i++)
                    if(testList.get(i).getCode().equals(pin.getText().toString()))
                    {
                        Intent intent=new Intent(getApplicationContext(),StartTestActivity.class);
                        intent.putExtra("test", testList.get(i));
                        startActivity(intent);
                    }

            }
        };
    }


    public void start_test_activity(View view)
    {
        Intent intentStartTest=new Intent(EnterPINActivity.this, MultiAnswerActivity.class );
        startActivity(intentStartTest);
    }

    public void onClickSearch(View view)
    {
        Intent intentSearch=new Intent(EnterPINActivity.this, SearchActivity.class );
        startActivity(intentSearch);
    }
}

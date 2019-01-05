package com.mcireasa.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StartTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_test);
    }


    public void start_test_activity(View view)
    {
        Intent intentStartTest=new Intent(StartTest.this, MultiAnswerActivity.class );
        startActivity(intentStartTest);
    }

    public void onClickSearch(View view)
    {
        Intent intentSearch=new Intent(StartTest.this, SearchActivity.class );
        startActivity(intentSearch);
    }
}

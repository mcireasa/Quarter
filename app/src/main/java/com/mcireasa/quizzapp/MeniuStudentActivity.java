package com.mcireasa.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MeniuStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meniu_student);
    }

    public void onClickSearch(View view)
    {
        Intent explicitIntent =
                new Intent(this,
                        SearchActivity.class);
        startActivity(explicitIntent);
    }

    public void onClickStartTest(View view)
    {
        Intent explicitIntent =
                new Intent(this,
                        StartTest.class);
        startActivity(explicitIntent);
    }

    public void onClickNewsFeed(View view)
    {
        Intent intentNewsFeed =
                new Intent(this,
                        NewsFeedActivity.class);
        startActivity(intentNewsFeed);
    }
}

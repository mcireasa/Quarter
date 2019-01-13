package com.mcireasa.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mcireasa.quizzapp.Model.User;

public class MeniuStudentActivity extends AppCompatActivity {

    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.BlackText);

        setContentView(R.layout.activity_meniu_student);

        user= (User) getIntent().getSerializableExtra("User");

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
                        EnterPINActivity.class);
        explicitIntent.putExtra("User",user);


        startActivity(explicitIntent);
    }

    public void onClickMyTests(View view)
    {
        Intent explicitIntent =
                new Intent(this,
                        MyTestActivity.class);

        explicitIntent.putExtra("User",user);

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

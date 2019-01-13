package com.mcireasa.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.mcireasa.quizzapp.Model.MyTest;

public class FinishTestActivity extends AppCompatActivity {

    MyTest myTest;
    TextView score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_test);
        myTest=(MyTest)getIntent().getSerializableExtra("myTest");
        score=(TextView) findViewById(R.id.score);
        score.setText("Final score:" +myTest.getScore());

    }
    public void backTo(View view){
        Intent intent=new Intent(this,MeniuStudentActivity.class);
        startActivity(intent);
        finish();
    }
}

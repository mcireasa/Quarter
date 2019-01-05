package com.mcireasa.quizzapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class MultiAnswerActivity extends AppCompatActivity {

    LinearLayout l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_answer);
        l=(LinearLayout)findViewById(R.id.checkboxgroup);
        for(int i=0;i<4;i++){
            CheckBox checkBox=new CheckBox(this);
            checkBox.setText("Buna");
            checkBox.setId(i);
            l.addView(checkBox);
        }
    }
}

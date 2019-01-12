package com.mcireasa.quizzapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mcireasa.quizzapp.Model.Test;
import com.mcireasa.quizzapp.database.DatabaseRepository;

public class StartTestActivity extends AppCompatActivity {

    TextView name;
    Button start;
    Test test;

    private DatabaseRepository repository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.star_test_activity);
        test= (Test) getIntent().getSerializableExtra("test");

        name = findViewById(R.id.test_name);
        start = findViewById(R.id.start_test);

        name.setText(test.getText());

        start.setOnClickListener(start());

    }

    private View.OnClickListener start() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {





            }
        };
    }


}

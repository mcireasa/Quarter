package com.mcireasa.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.mcireasa.quizzapp.Model.Test;
import com.mcireasa.quizzapp.database.DatabaseRepository;

import java.util.List;

public class StatisticsActivity extends AppCompatActivity {
Spinner spinner;
Button button;
     ArrayAdapter<Test> adapter;
    List<Test> tests;
    private DatabaseRepository repository;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        spinner=(Spinner)findViewById(R.id.spinner);


        repository = new DatabaseRepository(getApplicationContext());
        repository.open();
        tests=repository.getTests();
        adapter = new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item,
                tests);
        spinner.setAdapter(adapter);
    }

    public void showStat(View view){
        Intent intent=new Intent(this,BarChartActivity.class);
        Test test=(Test)spinner.getSelectedItem();
        intent.putExtra("test",test);
        startActivity(intent);
    }
}

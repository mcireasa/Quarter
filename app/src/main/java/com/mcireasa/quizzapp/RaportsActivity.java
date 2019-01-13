package com.mcireasa.quizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.mcireasa.quizzapp.Adapters.TestAdapter;
import com.mcireasa.quizzapp.Model.Test;
import com.mcireasa.quizzapp.database.DatabaseRepository;

import java.util.ArrayList;
import java.util.List;

public class RaportsActivity extends AppCompatActivity {

    TextView name, noQuestions;
    Button export, chart;

    private ListView list;


    DatabaseRepository databaseRepository=new DatabaseRepository(this);

    List<Test> testList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raports);


        name = findViewById(R.id.nume_test);
        noQuestions = findViewById(R.id.cod_acces);
        export = findViewById(R.id.export);
        export.setOnClickListener(viewRaports());

        chart = findViewById(R.id.button5);
        chart.setOnClickListener(viewChart());

        list = findViewById(R.id.listview_tests);

        databaseRepository.open();

        testList = databaseRepository.getTests();

        databaseRepository.close();

        TestAdapter adapter = new TestAdapter(getApplicationContext(),
                R.layout.lv_item_test, testList, getLayoutInflater());
        list.setAdapter(adapter);

    }

    private View.OnClickListener viewRaports() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ExportActivity.class);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener viewChart() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),BarChartActivity.class);
                startActivity(intent);
            }
        };
    }




}

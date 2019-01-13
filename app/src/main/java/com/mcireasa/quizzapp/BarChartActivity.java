package com.mcireasa.quizzapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.mcireasa.quizzapp.Model.MyTest;
import com.mcireasa.quizzapp.Model.Test;
import com.mcireasa.quizzapp.Model.User;
import com.mcireasa.quizzapp.database.DatabaseRepository;

import java.util.ArrayList;
import java.util.List;

public class BarChartActivity extends AppCompatActivity {

    private DatabaseRepository repository;

    List<MyTest> testList = new ArrayList<>();
    List<MyTest> myTestsList = new ArrayList<>();
    List<User>  userList = new ArrayList<>();

    Test test;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);
        BarChart chart = findViewById(R.id.barchart);

        ArrayList Notes = new ArrayList();

        Notes.add(new BarEntry(9f, 0));
        Notes.add(new BarEntry(8.6f, 1));
        Notes.add(new BarEntry(4f, 2));
        Notes.add(new BarEntry(7f, 3));


        ArrayList notes = new ArrayList();

        notes.add("Andreea");
        notes.add("Ioana");
        notes.add("Mihai");
        notes.add("Cosmin");

        repository = new DatabaseRepository(getApplicationContext());
        repository.open();

        test= (Test) getIntent().getSerializableExtra("Test");

        testList = repository.getMyTests();

        for(int i=0;i<testList.size();i++)
            if(testList.get(i).getId_test() == test.getId())
                myTestsList.add(testList.get(i));

        userList = repository.getUser();


        for(int i=0;i<myTestsList.size();i++)
        {
            Notes.add(new BarEntry(myTestsList.get(i).getScore(),i+4));
            notes.add(userList.get(myTestsList.get(i).getId_user()).getUsername());
        }



        BarDataSet bardataset = new BarDataSet(Notes, "Notes");
        chart.animateY(5000);
        BarData data = new BarData(notes, bardataset);
        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        chart.setData(data);
    }
}

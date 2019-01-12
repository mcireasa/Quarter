package com.mcireasa.quizzapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.mcireasa.quizzapp.database.DatabaseRepository;

import java.util.ArrayList;

public class BarChartActivity extends AppCompatActivity {

    private DatabaseRepository repository;


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

        BarDataSet bardataset = new BarDataSet(Notes, "Notes");
        chart.animateY(5000);
        BarData data = new BarData(notes, bardataset);
        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        chart.setData(data);
    }
}

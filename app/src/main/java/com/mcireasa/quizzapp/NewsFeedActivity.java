package com.mcireasa.quizzapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.mcireasa.quizzapp.Model.Event;

import java.util.ArrayList;
import java.util.List;

public class NewsFeedActivity extends AppCompatActivity {

    private final String TAG = "newsFeedActivity";

    private RecyclerView recyclerView;
    private RecycleViewAdapter adapter;
    private List<Event> eventList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);
        Log.d(TAG, "onCreate:started");

        recyclerView = findViewById(R.id.recycler_view);
        adapter = new RecycleViewAdapter(eventList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        populateEvents();
        adapter.notifyDataSetChanged();
    }

    private void populateEvents() {
        eventList.add(new Event(1, "Ana are mere"));
        eventList.add(new Event(2, "Ana are mere"));
        eventList.add(new Event(3, "Asdsdre mere"));
        eventList.add(new Event(4, "ewee mere"));
        eventList.add(new Event(5, "Ana are mere"));
        eventList.add(new Event(6, "Ana are mere"));
        eventList.add(new Event(7, "Ana are mere"));
        eventList.add(new Event(8, "Ana are mere"));
        eventList.add(new Event(9, "Ana are mere"));


    }
}




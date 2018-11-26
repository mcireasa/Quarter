package com.mcireasa.quizzapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

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

        RecyclerView.LayoutManager LayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(LayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareEventData();
    }

    private void prepareEventData() {
        Event e = new Event(R.drawable.firefox, "adsdsds");
        eventList.add(e);

        Event ev = new Event(R.drawable.firefox, "dfdfddfsds");
        eventList.add(ev);

        Event eve = new Event(R.drawable.firefox, "DERGTYTRFEDds");
        eventList.add(eve);

        Event en = new Event(R.drawable.firefox, "adVBHJKLFs");
        eventList.add(en);

        adapter.notifyDataSetChanged();
    }
}

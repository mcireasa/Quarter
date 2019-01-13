package com.mcireasa.quizzapp.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mcireasa.quizzapp.Model.MyTest;
import com.mcireasa.quizzapp.Model.Test;
import com.mcireasa.quizzapp.R;

import java.util.List;

public class MyTestsAdapter extends ArrayAdapter<TestRaport> {

    private Context context;
    private int resource;
    private List<TestRaport> tests;
    private LayoutInflater inflater;

    public MyTestsAdapter(@NonNull Context context, int resource, @NonNull List<TestRaport> objects, LayoutInflater inflater) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.inflater=inflater;
        this.tests=objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row = inflater.inflate(resource, parent, false);
        TextView name = row.findViewById(R.id.item_nume_test_stud);
        TextView noQuestions= row.findViewById(R.id.score_stud);

        TestRaport test = tests.get(position);


        name.setText(String.valueOf(test.getNume()));
        noQuestions.setText(String.valueOf(test.getScore()));


        return row;
    }
}

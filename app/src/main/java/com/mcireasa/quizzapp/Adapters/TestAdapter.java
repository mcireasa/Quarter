package com.mcireasa.quizzapp.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mcireasa.quizzapp.Model.Test;
import com.mcireasa.quizzapp.R;

import java.util.List;

public class TestAdapter extends ArrayAdapter<Test> {
    private Context context;
    private int resource;
    private List<Test> tests;
    private LayoutInflater inflater;

    public TestAdapter(@NonNull Context context, int resource, @NonNull List<Test> objects, LayoutInflater inflater) {
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
        TextView name = row.findViewById(R.id.item_nume_test);
        TextView noQuestions= row.findViewById(R.id.item_numar_intrebari);

        Test test = tests.get(position);

        name.setText(test.getText());
        noQuestions.setText(test.getCode());


        return row;
    }
}

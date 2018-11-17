package com.mcireasa.quizzapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.mcireasa.quizzapp.Model.Category;
import com.mcireasa.quizzapp.Model.Test;

import java.util.ArrayList;
import java.util.List;

public class TestsActivity extends AppCompatActivity {

    private ListView listView;
    private Category category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        super.onContentChanged();
        TextView tv=(TextView)findViewById(R.id.textViewTitlePage);
        listView=(ListView)findViewById(R.id.listviewcategory);
        category= (Category) getIntent().getSerializableExtra("Category");
        List<Test> lista= (ArrayList<Test>) category.getTests();
        tv.setText(category.getName());
        ArrayAdapter<Test> arrayAdapter=new ArrayAdapter<Test>(this,android.R.layout.simple_list_item_1,lista);
        listView.setAdapter(arrayAdapter);


    }
}

package com.mcireasa.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.mcireasa.quizzapp.Model.Category;
import com.mcireasa.quizzapp.Model.Test;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {


    private ListView listView;
    private Intent myIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        myIntent=new Intent(this,CategoryOptionsActivity.class);
        Category c1=new Category();
        c1.setName("Pooo");
        Category c2=new Category();
        c2.setName("Abecedar");
        Category c3=new Category();
        Test t1=new Test();
        t1.setText("Test greu");
        List<Test> test=c3.getTests();
        c3.addTests(t1);
        c3.setName("Android");
        List<Category> lista=new ArrayList<>();
        lista.add(c1);
        lista.add(c2);
        lista.add(c3);




        listView=(ListView)findViewById(R.id.listviewcategory);
        ArrayAdapter<Category> arrayAdapter=new ArrayAdapter<Category>(this,android.R.layout.simple_list_item_1,lista);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(listClick);
    }

    AdapterView.OnItemClickListener listClick=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Category categ=(Category) listView.getItemAtPosition(position);
            myIntent.putExtra("Category_selected", categ);
            startActivity(myIntent);

        }
    };

    public void add(View view){
        Intent addIntent=new Intent(this,AddCategoryActivity.class);
        startActivity(addIntent);
    }

}

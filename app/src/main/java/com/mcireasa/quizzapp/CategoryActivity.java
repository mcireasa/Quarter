package com.mcireasa.quizzapp;

import android.content.Intent;
import android.support.annotation.Nullable;
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
    private List lista;
    ArrayAdapter<Category> arrayAdapter=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        myIntent = new Intent(this, CategoryOptionsActivity.class);
        Category c1 = new Category();
        c1.setName("Pooo");
        Category c2 = new Category();
        c2.setName("Abecedar");
        Category c3 = new Category();
        Test t1 = new Test();
        t1.setText("Poo");
        t1.setMpublic(true);
        Test t2=new Test();
        t2.setText("Android");
        t2.setMpublic(false);
        t2.setCode("23456");
        List<Test> test = c3.getTests();
        c3.addTests(t1);
        c3.addTests(t2);
        c3.setName("Android");
         lista = new ArrayList<>();
        lista.add(c1);
        lista.add(c2);
        lista.add(c3);


        listView = (ListView) findViewById(R.id.listviewcategory);
         arrayAdapter = new ArrayAdapter<Category>(this, android.R.layout.simple_list_item_1, lista);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(listClick);
    }

    AdapterView.OnItemClickListener listClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Category categ = (Category) listView.getItemAtPosition(position);
            myIntent.putExtra("Category_selected", categ);
            startActivity(myIntent);

        }
    };

    public void add(View view) {
        Intent addIntent = new Intent(this, AddCategoryActivity.class);
        startActivityForResult(addIntent,1);

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==1&&resultCode==RESULT_OK){
            Category category=new Category();
            category.setName(data.getStringExtra("CategoryName"));
            lista.add(category);
            if(arrayAdapter!=null) {
                arrayAdapter.notifyDataSetChanged();

            }
        }
    }
}

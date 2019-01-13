package com.mcireasa.quizzapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mcireasa.quizzapp.Model.Category;
import com.mcireasa.quizzapp.Model.Test;
import com.mcireasa.quizzapp.Model.User;
import com.mcireasa.quizzapp.database.DatabaseRepository;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {


    private ListView listView;
    private Intent myIntent;
    private List lista;
    ArrayAdapter<Category> arrayAdapter=null;
    User user;

    List<Category> categories = new ArrayList<>();

    private DatabaseRepository repository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        myIntent = new Intent(this, CategoryOptionsActivity.class);

       lista = new ArrayList<>();
       user=(User) getIntent().getSerializableExtra("User");
        lista=user.getCategories();

        repository = new DatabaseRepository(getApplicationContext());
        repository.open();

        categories = user.getCategories();

        categories.addAll(repository.getCategories());

        Log.i("info", categories.toString());

        repository.close();


        listView = (ListView) findViewById(R.id.listviewcategory);
         arrayAdapter = new ArrayAdapter<Category>(this, android.R.layout.simple_list_item_1, categories);

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
            categories.add(category);
            if(arrayAdapter!=null) {
                arrayAdapter.notifyDataSetChanged();

            }
        }
    }


}

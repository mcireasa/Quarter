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
import android.widget.ListView;
import android.widget.ProgressBar;

import com.mcireasa.quizzapp.Model.Category;
import com.mcireasa.quizzapp.Model.Test;

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
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        myIntent = new Intent(this, CategoryOptionsActivity.class);

       lista = new ArrayList<>();

        progressBar=(ProgressBar)findViewById(R.id.progressBar) ;

        listView = (ListView) findViewById(R.id.listviewcategory);
         arrayAdapter = new ArrayAdapter<Category>(this, android.R.layout.simple_list_item_1, lista);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(listClick);
        CategoryWorkers categoryWorkers=new CategoryWorkers();
        categoryWorkers.execute();

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

    class CategoryWorkers extends AsyncTask<Void,Integer,List<Category>>{

        @Override
        protected void onPreExecute() {
            if(progressBar != null) {
                progressBar.setVisibility(View.VISIBLE);
            }
        }

        @Override
        protected List<Category> doInBackground(Void... voids) {
            HttpURLConnection connection = null;
            try {
                URL url = new URL("https://api.myjson.com/bins/wu4a6");
                connection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                String line = null;
                while((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                String result = stringBuilder.toString();
                Log.d("JSON", result);
                List<Category> categories=new ArrayList();
                JSONObject jsonObject = new JSONObject(result);
                JSONArray categoryArray = jsonObject.getJSONArray("categories");
                for(int i=0;i<categoryArray.length();i++){
                    Category category=new Category();
                    JSONObject categoryObject = (JSONObject) categoryArray.get(i);
                    category.setId(categoryObject.getInt("id"));
                    category.setName(categoryObject.getString("name"));
                    JSONArray testsArray=categoryObject.getJSONArray("tests");
                    for(int j=0;j<testsArray.length();j++){
                        Test test=new Test();
                        JSONObject testObject=(JSONObject)testsArray.get(j);
                        test.setText(testObject.getString("name"));
                        test.setId(testObject.getInt("id"));
                        test.setActive(testObject.getBoolean("active"));
                        test.setMpublic(testObject.getBoolean("public"));
                        test.setCode(testObject.getString("code"));
                        category.getTests().add(test);
                    }
                    categories.add(category);

                }
                return categories;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                if(connection != null) {
                    connection.disconnect();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<Category> categories) {
            if(progressBar != null) {
                progressBar.setVisibility(View.INVISIBLE);
            }
            for(Category categ:categories){
                lista.add(categ);
            }

                arrayAdapter.notifyDataSetChanged();


        }
    }
}

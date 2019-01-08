package com.mcireasa.quizzapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.mcireasa.quizzapp.Model.Category;
import com.mcireasa.quizzapp.Model.Test;
import com.mcireasa.quizzapp.Model.User;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MeniuProfesorActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarToggle;
    NavigationView navigationView;
    ProgressBar progressBar;
    List<Category>lista;
    User user;
    Button addTest,showCategories,newsfeed, raports;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meniu_profesor);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarToggle);
        actionBarToggle.syncState();
        progressBar=(ProgressBar)findViewById(R.id.progressBar) ;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        user=new User();
        addTest=(Button)findViewById(R.id.createTestButton);
        showCategories=(Button)findViewById(R.id.categoriesButton);
        newsfeed=(Button)findViewById(R.id.newsFeed);
        raports = findViewById(R.id.raportsButton);
        raports.setOnClickListener(viewRaports());
        CategoryWorkers categoryWorkers=new CategoryWorkers();
        categoryWorkers.execute();


        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_settings:
                        Intent intentSettings = new Intent(MeniuProfesorActivity.this, SettingsActivity.class);
                        startActivity(intentSettings);
                        break;
                    case R.id.nav_account:
                        Intent intentAccount = new Intent(MeniuProfesorActivity.this, MyAccountActivity.class);
                        startActivity(intentAccount);
                        break;
                    case R.id.nav_logout:
                        Intent intentLogout = new Intent(MeniuProfesorActivity.this, LoginActivity.class);
                        startActivity(intentLogout);
                        break;
                    case R.id.nav_about:
                        Intent intentAbout = new Intent(MeniuProfesorActivity.this, AboutActivity.class);
                        startActivity(intentAbout);
                }
                return false;

            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (actionBarToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void onClickCreateTest(View view) {
        Intent intentCreateTest = new Intent(MeniuProfesorActivity.this, CreateTestActivity.class);
        intentCreateTest.putExtra("User",user);
        startActivity(intentCreateTest);
    }

    public void onClickNewsfeed(View view) {
        Intent intentNewsfeed = new Intent(MeniuProfesorActivity.this, NewsFeedActivity.class);
        startActivity(intentNewsfeed);
    }


    public void seeCategories(View view) {
        Intent explicitIntent =
                new Intent(this,
                        CategoryActivity.class);
        explicitIntent.putExtra("User",user);
        startActivity(explicitIntent);
    }

    public void onClickEstiStudent(View view)
    {
        Intent intentMeniuStudent=new Intent(MeniuProfesorActivity.this, MeniuStudentActivity.class);
        startActivity(intentMeniuStudent);
    }

    private View.OnClickListener viewRaports() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),RaportsActivity.class);
                startActivity(intent);
            }
        };
    }

    class CategoryWorkers extends AsyncTask<Void,Integer,List<Category>> {

        @Override
        protected void onPreExecute() {

            if(progressBar != null) {
                progressBar.setVisibility(View.VISIBLE);
            }
            if(addTest!=null){
                addTest.setVisibility(View.INVISIBLE);
            }
            if(showCategories!=null){
                showCategories.setVisibility(View.INVISIBLE);
            }
            if(newsfeed!=null){
                newsfeed.setVisibility(View.INVISIBLE);
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
        protected void onPostExecute(List<Category> categoriesList) {
            if(progressBar != null) {
                progressBar.setVisibility(View.INVISIBLE);
            }
            if(addTest!=null){
                addTest.setVisibility(View.VISIBLE);
            }
            if(showCategories!=null){
                showCategories.setVisibility(View.VISIBLE);
            }
            if(newsfeed!=null){
                newsfeed.setVisibility(View.VISIBLE);
            }
            for(Category categ:categoriesList){
                user.getCategories().add(categ);
            }




        }
    }
}

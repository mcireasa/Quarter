package com.mcireasa.quizzapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class MeniuProfesorActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarToggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meniu_profesor);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarToggle);
        actionBarToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
        startActivity(explicitIntent);
    }
}

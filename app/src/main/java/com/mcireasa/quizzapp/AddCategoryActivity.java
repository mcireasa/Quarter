package com.mcireasa.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AddCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);
    }

    public void addCategory(View view) {
        Intent explicitIntent =
                new Intent(this, CategoryActivity.class);
        EditText name = (EditText) findViewById(R.id.nameNewCategory);
        if (name != null) {
            explicitIntent.putExtra("CategoryName", name.getText().toString());
            startActivity(explicitIntent);
        }
    }
}

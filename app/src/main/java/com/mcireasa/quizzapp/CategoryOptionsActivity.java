package com.mcireasa.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mcireasa.quizzapp.Model.Category;

public class CategoryOptionsActivity extends AppCompatActivity {

    private Category category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_options);
        TextView tv=(TextView)findViewById(R.id.textViewNameC);
        category= (Category) getIntent().getSerializableExtra("Category_selected");
        tv.setText(category.getName());

    }


    public void seeTest(View view) {
        Intent explicitIntent =
                new Intent(CategoryOptionsActivity.this,
                        TestsActivity.class);
        explicitIntent.putExtra("Category", this.category);
        startActivity(explicitIntent);
    }
}

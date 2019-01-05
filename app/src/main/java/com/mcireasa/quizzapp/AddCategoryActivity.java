package com.mcireasa.quizzapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mcireasa.quizzapp.Model.Category;
import com.mcireasa.quizzapp.database.DatabaseRepository;

public class AddCategoryActivity extends AppCompatActivity {

    private EditText nameCategory;
    private DatabaseRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);
        nameCategory=(EditText)findViewById(R.id.nameNewCategory);
    }

    public void addCategory(View view) {
        Intent explicitIntent =
                new Intent();

        if (nameCategory != null) {
            if("".equals(nameCategory.getText().toString())){
                AlertDialog.Builder builder =
                        new AlertDialog.Builder(this);
                builder.setTitle(R.string.error_text);
                builder.setMessage("The new category has to have a name");
                builder.setPositiveButton("OK", null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }else {
                explicitIntent.putExtra("CategoryName", nameCategory.getText().toString());
                setResult(RESULT_OK,explicitIntent);

                repository = new DatabaseRepository(getApplicationContext());
                repository.open();

                Category category = new Category();
                category.setName(nameCategory.getText().toString());

                Long id = repository.insertCategory(category);
                repository.close();

                Toast.makeText(this, String.valueOf(id), Toast.LENGTH_SHORT).show();


                finish();
            }
        }
    }
}

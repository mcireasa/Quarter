package com.mcireasa.quizzapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.mcireasa.quizzapp.Model.User;
import com.mcireasa.quizzapp.database.DatabaseRepository;
import com.mcireasa.quizzapp.firebase.FirebaseController;

public class CreateAccountActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword,etRepeatPassword,etEmail;
    private RadioButton button_s,button_p;
    private Button createAccount;
    private Integer type;

    private DatabaseRepository repository;

    private FirebaseController firebaseController;

    String username,password,repeatpassword,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);

        setContentView(R.layout.activity_create_account);
        repository = new DatabaseRepository(getApplicationContext());
        firebaseController = FirebaseController.getInstance();

        init();

    }


    public void init(){
        etUsername=(EditText)findViewById(R.id.username_newaccount);
        etPassword=(EditText)findViewById(R.id.password_newaccount);
        etRepeatPassword=(EditText)findViewById(R.id.repeatpass_newaccount);
        etEmail=(EditText)findViewById(R.id.email_newaccount);
        button_p = (RadioButton) findViewById(R.id.profesor_option);
        button_s = (RadioButton) findViewById(R.id.student_option);

        createAccount = findViewById(R.id.buttonCreateAccount);
        createAccount.setOnClickListener(create());

    }

    private View.OnClickListener create() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validation()) {

                    username = etUsername.getText().toString();
                    password = etPassword.getText().toString();
                    repeatpassword = etRepeatPassword.getText().toString();
                    email = etEmail.getText().toString();

                    if(button_p.isChecked())
                        type = 1;
                    else if(button_s.isChecked())
                        type = 2;

                    repository.open();

                    User user = new User();

                    user.setUsername(username);
                    user.setEmail(email);
                    user.setPassword(password);
                    user.setType(type);

                    insertUser(user);

                    repository.close();
                    finish();
                }
            }
        };
    }

    private void insertUser(User user) {

        repository.open();
        Long id = repository.insertUser(user);
        if (id != -1) {
            user.setId(Integer.valueOf(String.valueOf(id)));
            String globalId = exportToFirebase(user);
            if (globalId != null) {
                user.setGlobalId(globalId);
            }
        }

        repository.close();
    }

    public boolean validation(){
        boolean valid=true;
        if(etUsername.getText()==null&&"".equals(etUsername.getText().toString())){
            etUsername.setError("An account has to have a username");
            valid=false;
        }
        if(etPassword.getText()==null&&"".equals(etPassword.getText().toString())){
            etPassword.setError("An account has to have a password");
            valid=false;
        }
        if(etRepeatPassword.getText()==null&&"".equals(etRepeatPassword.getText().toString())){
            etRepeatPassword.setError("Write the same password");
            valid=false;
        }
        if(etEmail.getText()==null&&"".equals((etEmail.getText().toString()))){
            etEmail.setError("An account has to have an email");
            valid=false;
        }

        if(button_s.isChecked()||button_p.isChecked()){}else{
            valid=false;
        }

        return valid;
    }

    private String exportToFirebase(User user) {
        return firebaseController.upsertUser(user);
    }
}

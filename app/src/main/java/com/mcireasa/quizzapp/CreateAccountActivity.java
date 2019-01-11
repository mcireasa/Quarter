package com.mcireasa.quizzapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class CreateAccountActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword,etRepeatPassword,etEmail;
    private RadioButton button_s,button_p;

    String username,password,repeatpassword,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
    }


    public void onClickCreate(View view){
        etUsername=(EditText)findViewById(R.id.username_newaccount);
        etPassword=(EditText)findViewById(R.id.password_newaccount);
        etRepeatPassword=(EditText)findViewById(R.id.repeatpass_newaccount);
        etEmail=(EditText)findViewById(R.id.email_newaccount);
        button_p = (RadioButton) findViewById(R.id.profesor_option);
        button_s = (RadioButton) findViewById(R.id.student_option);
        if(validation()) {
//            button_p = (RadioButton) findViewById(R.id.profesor_option);
//            button_s = (RadioButton) findViewById(R.id.student_option);
//            username = etUsername.getText().toString();
//            password = etPassword.getText().toString();
//            repeatpassword = etRepeatPassword.getText().toString();
//            email = etEmail.getText().toString();
            finish();
        }

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
}

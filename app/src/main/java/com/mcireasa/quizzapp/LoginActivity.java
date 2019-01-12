package com.mcireasa.quizzapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mcireasa.quizzapp.Model.User;
import com.mcireasa.quizzapp.database.DatabaseRepository;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private DatabaseRepository repository;
    private List<User> userList = new ArrayList<>();

    EditText textUsername, textPassword;

    private SharedPreferences sharedPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTheme(R.style.BlackText);

        setContentView(R.layout.activity_login);
        textUsername = (EditText)findViewById(R.id.TextUsername);
        textPassword = (EditText)findViewById(R.id.TextPassword);
        sharedPref = getSharedPreferences(Constants.Pref_file_name, MODE_PRIVATE);


        TextView forgotPass_tv = (TextView) findViewById(R.id.ForgotPassText);

        restore();
    }

    public void onClickForgotPassText(View view) {
        AlertDialog.Builder forgotBuilder = new AlertDialog.Builder(LoginActivity.this);
        View forgotView = getLayoutInflater().inflate(R.layout.dialog_forgot_pass, null);
        final EditText forgotPasswordEmailText = (EditText) forgotView.findViewById(R.id.ForgotEmailText);
        final EditText forgotPasswordUserText = (EditText) forgotView.findViewById(R.id.ForgotUserText);
        Button btnSend = (Button) forgotView.findViewById(R.id.ForgotBtnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //verificare existenta user in bdd
                if (!forgotPasswordEmailText.getText().toString().isEmpty() && !forgotPasswordUserText.getText().toString().isEmpty()) {
                    Toast.makeText(LoginActivity.this, "We've sent a recovery link to your email address.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Please fill any empty fields!", Toast.LENGTH_LONG).show();
                }

            }
        });
        forgotBuilder.setView(forgotView);
        AlertDialog dialog = forgotBuilder.create();
        dialog.show();
    }

    public void onClickNewAccount(View view){
        Intent intent = new Intent(LoginActivity.this, CreateAccountActivity.class);
        startActivity(intent);

    }

    public void restore()
    {
        String username_pref = sharedPref.getString(Constants.Pref_username, null);
        String password_pref = sharedPref.getString(Constants.Pref_password, null);

        textUsername.setText(username_pref);
        textPassword.setText(password_pref);
    }


    public void OnClikLoginBtn(View view) {

        repository = new DatabaseRepository(getApplicationContext());
        repository.open();

        userList = repository.getUser();

        for(int i=0;i<userList.size();i++)
            if(userList.get(i).getUsername().equals(textUsername.getText().toString()) && userList.get(i).getPassword().equals(textPassword.getText().toString()))
            {
                if(userList.get(i).getType()==1){
                    Intent intent = new Intent(LoginActivity.this, MeniuProfesorActivity.class);
                    intent.putExtra("User",userList.get(i));
                    startActivity(intent);
                }
                else if (userList.get(i).getType() ==2){
                    Intent intent = new Intent(LoginActivity.this, MeniuStudentActivity.class);
                    intent.putExtra("User",userList.get(i));
                    startActivity(intent);
                }
                else
                    Toast.makeText(this, "User has a wrong type", Toast.LENGTH_LONG).show();

            }

        String username = textUsername.getText().toString();
        String password = textPassword.getText().toString();

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(Constants.Pref_username, username);
        editor.putString(Constants.Pref_password, password);
        editor.commit();


    }
}

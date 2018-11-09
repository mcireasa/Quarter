package com.mcireasa.quizzapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView forgotPass_tv = (TextView) findViewById(R.id.ForgotPassText);
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


    public void OnClikLoginBtn(View view) {
        final EditText textUsername = (EditText)findViewById(R.id.TextUsername);
        final EditText textPaswword = (EditText)findViewById(R.id.TextPassword);
        Button btnLogin = (Button) findViewById(R.id.btnLogim);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //verificare username + password cu bd
                //de aflat cum draq retinem username-ul si parola peste tot in aplicatie (in resources de preferabil)
                if(!textUsername.getText().toString().isEmpty() && !textPaswword.getText().toString().isEmpty())
                {
                    Intent intent = new Intent(LoginActivity.this, MeniuProfesorActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, "Please fill any empty fields!", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}

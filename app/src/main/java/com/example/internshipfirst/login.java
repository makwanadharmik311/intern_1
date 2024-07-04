package com.example.internshipfirst;



import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

public class login extends AppCompatActivity {
    TextView login_create,forget;
    EditText email,password;
    Button signin;
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        signin = (Button) findViewById(R.id.login_signup);
        email = (EditText) findViewById(R.id.login_email);
        password = (EditText) findViewById(R.id.login_password);
        login_create = (TextView) findViewById(R.id.login_create);
        forget = (TextView) findViewById(R.id.forget);

        signin.setOnClickListener(new View.OnClickListener() {

            String em = email.getText().toString();
            String pa = password.getText().toString();
            String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

            @Override
            public void onClick(View view) {
                if(email.getText().toString().equals("")){
                    email.setError("email id requaired");
                }
                else if(!email.getText().toString().trim().matches(emailPattern)){
                    email.setError("error!!");
                }
                else if(password.getText().toString().trim().equals("")){
                    password.setError("password is required");
                }
                else if(password.getText().toString().trim().length() < 6){
                    password.setError("6 length required");
                }
                else{
                    Toast.makeText(login.this, "email " + em + "\n" + "password " + pa, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(login.this, Profile.class);
                    startActivity(intent);
                }
                //Snackbar.make(view,"ready",Snackbar.LENGTH_LONG).show();
            }
        });

        login_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, register.class);
                startActivity(intent);
            }
        });

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, forgetPassword.class);
                startActivity(intent);
            }
        });
    }

}
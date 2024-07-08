package com.example.internshipfirst;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class register extends AppCompatActivity {

    EditText reg_name,reg_con,reg_email,reg_pass,reg_conf;
    Button regis;
    TextView already;
    SQLiteDatabase db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        db = openOrCreateDatabase("internshipfirst.db",MODE_PRIVATE,null);
        String query = "CREATE TABLE IF NOT EXISTS USERS(USERID INT PRIMARY KEY,NAME VARCHAR(50),CONTACT BIGINT(10),EMAIL VARCHAR(50),PASSWORD VARCHARR(20))";
        db.execSQL(query);

        reg_name = (EditText) findViewById(R.id.reg_name);
        reg_con = (EditText) findViewById(R.id.reg_con);
        reg_email = (EditText) findViewById(R.id.reg_email);
        reg_pass = (EditText) findViewById(R.id.reg_pass);
        reg_conf = (EditText) findViewById(R.id.reg_conf);
        regis = (Button) findViewById(R.id.register);
        already = (TextView) findViewById(R.id.already);

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = reg_name.getText().toString().trim();
                String contect = reg_con.getText().toString().trim();
                String email = reg_email.getText().toString().trim();
                String password = reg_pass.getText().toString().trim();
                String confirm = reg_conf.getText().toString().trim();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                if(name.matches("")){
                    reg_name.setError("error !");
                }
                else if(contect.matches("")){
                    reg_con.setError("error !");
                }
                else if(contect.length() < 10){
                    reg_con.setError("required length 10");
                }
                else if(email.matches("")){
                    reg_email.setError("error !");
                }
                else if(!email.matches(emailPattern)){
                    reg_email.setError("error !");
                }
                else if(password.matches("")) {
                    reg_email.setError("error !");
                }
                else if(password.length() < 6){
                    reg_pass.setError("required length 6");
                }
                else if(confirm.matches("")){
                    reg_conf.setError("error !");
                }
                else if(!password.matches(confirm)) {
                    reg_conf.setError("error !");
                }
                else{
                    String query = "INSERT INTO USERS VALUES (NULL,'"+ name +"','"+ contect +"','"+ email +"','"+ password +"')";
                    db.execSQL(query);
                    Intent intent = new Intent(register.this, Profile.class);
                    startActivity(intent);
                }
            }
        });

        already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }




}
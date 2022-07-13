package com.example.smartparkingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Signup extends AppCompatActivity {
       EditText username,password,emailid,phoneno;
       Button  signup,login;
       DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        emailid = findViewById(R.id.email);
        username = findViewById(R.id.username);
        phoneno=findViewById(R.id.phone);
        password=findViewById(R.id.password);
        signup= findViewById(R.id.signup);
        login=findViewById(R.id.login);
        DB = new DBHelper(this);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailid.getText().toString();
                String uname = username.getText().toString();
                String phone= phoneno.getText().toString();
                String pwd = password.getText().toString();
                if (uname.equals("") || pwd.equals("")||email.equals("") || phone.equals("")) {
                    Toast.makeText(Signup.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else
                    {
                    Boolean checkuser = DB.checkusername(email);
                    if (checkuser == false) {
                        Boolean insert = DB.insertData(email,uname,phone, pwd);
                        if (insert == true) {
                            Toast.makeText(Signup.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), Login.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(Signup.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Signup.this, "Email already exists! please sign in", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Signup.this, Login.class);
                startActivity(intent);
            }
        });
    }
}
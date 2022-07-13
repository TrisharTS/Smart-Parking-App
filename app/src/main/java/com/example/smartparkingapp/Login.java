package com.example.smartparkingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
     EditText emailid,loginpassword;
     Button loginbtn,signupbtn;
     DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailid= findViewById(R.id.emailid);
        loginpassword=findViewById(R.id.loginpassword);
        loginbtn =findViewById(R.id.loginbtn);
        signupbtn =findViewById(R.id.signupbtn);
        DB = new DBHelper(this);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loginemailid= emailid.getText().toString();
                String password=loginpassword.getText().toString();
                if (loginemailid.equals("") || password.equals("")) {
                    Toast.makeText(Login.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean checkuserpassword = DB.checkuseremailpassword(loginemailid, password);
                    if(checkuserpassword==true){
                        Toast.makeText(Login.this, "Signin Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Login.this, UserDashboard.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(Login.this,"Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
;        });
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,Signup.class);
                startActivity(intent);
            }
        });
    }
}
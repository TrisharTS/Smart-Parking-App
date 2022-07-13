package com.example.smartparkingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {
    EditText email,name,phone,message;
    Button submit;
    DBHelper3 DB3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        email = findViewById(R.id.email);
        name = findViewById(R.id.username);
        phone = findViewById(R.id.phone);
        message = findViewById(R.id.message);
        submit = findViewById(R.id.submit);
        DB3 = new DBHelper3(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = email.getText().toString();
                String uname = name.getText().toString();
                String uphone = phone.getText().toString();
                String feedback = message.getText().toString();

                if (mail.equals("") || uname.equals("") || uname.equals("") || uphone.equals("") || message.equals("")) {
                    Toast.makeText(Feedback.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean insert = DB3.insertData(mail,uname,uphone,feedback);
                    if(insert == true)
                    {
                        Toast.makeText(Feedback.this, "Thank You For your Feedback", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(Feedback.this, "Failed to submit Feedback", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

    }
}
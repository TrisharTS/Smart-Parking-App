package com.example.smartparkingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Exit extends AppCompatActivity {

    Button btn_exit,btn_cancel;
    boolean isPressed = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit);

        btn_exit=findViewById(R.id.btn_exit);
        btn_cancel=findViewById(R.id.btn_cancel);


        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Exit.this,UserDashboard.class);
                startActivity(intent);
            }
        });
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Clear all activities
                finishAffinity();
                //exit
                System.exit(0);

            }
        });

    }
    @Override
    public void onBackPressed() {

        //check condition
        if (isPressed){
            //when double back press within a second
            //Clear all activity
            finishAffinity();
            //exit
            System.exit(0);
        }else
        {
            //When double back press delay for 2 seconds
            //Display toast

            Toast.makeText(getApplicationContext(),"Please Click back again to exit.",Toast.LENGTH_SHORT).show();
            //SET TRUE
            isPressed=true;
        }
        //Initialize runnable
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                //set false
                isPressed=false;


            }
        };
        //handler delay for 2 seconds
        new Handler().postDelayed(runnable,2000);

    }
}
package com.example.smartparkingapp;


import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;

public class UserDashboard extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    DrawerLayout drawerLayout;

    NavigationView navigationView;
    Toolbar toolbar;
    public CardView card1,card2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view1);
        toolbar=findViewById(R.id.toolbar);

        card1 = (CardView) findViewById(R.id.c1);
        card2 = (CardView) findViewById(R.id.c2);


        card1.setOnClickListener(this);
        card2.setOnClickListener(this);




                setSupportActionBar(toolbar);



                navigationView.bringToFront();
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

    }



    @Override
    public void onBackPressed() {


        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(  MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_Home:
                Intent intent = new Intent(UserDashboard.this, UserDashboard.class);
                startActivity(intent);
                break;
            case R.id.nav_viewSlot:
                Intent intent1 = new Intent(UserDashboard.this, BookSlot.class);
                startActivity(intent1);
                break;
            case R.id.nav_feedback:
                Intent intent2 = new Intent(UserDashboard.this, Feedback.class);
                startActivity(intent2);
                break;
            case R.id.exit:
                Intent intent3 = new Intent(UserDashboard.this, Exit.class);
                startActivity(intent3);
                break;

        }
        return true;
    }



    @Override
    public void onClick(View v) {
        Intent i;

        switch(v.getId()) {
            case R.id.c1 :
                i = new Intent(this,BookSlot.class);
                startActivity(i);
                break;

            case R.id.c2 :
                i = new Intent(this,Feedback.class);
                startActivity(i);
                break;

        }


    }


}
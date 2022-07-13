package com.example.smartparkingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BookSlot extends AppCompatActivity {

    public CardView card1,card2, card3, card4, card5, card6;
    TextView s1,s2,s3,s4,s5,s6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_slot);

        card1 = (CardView) findViewById(R.id.cr1);
        card2 = (CardView) findViewById(R.id.cr2);
        card3 = (CardView) findViewById(R.id.cr3);
        card4 = (CardView) findViewById(R.id.cr4);
        card5 = (CardView) findViewById(R.id.cr5);
        card6 = (CardView) findViewById(R.id.cr6);

        s1 = (TextView) findViewById(R.id.slot1);
        s2 = (TextView) findViewById(R.id.slot2);
        s3 = (TextView) findViewById(R.id.slot3);
        s4 = (TextView) findViewById(R.id.slot4);
        s5 = (TextView) findViewById(R.id.slot5);
        s6 = (TextView) findViewById(R.id.slot6);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(BookSlot.this,ParkingForm.class);
                intent.putExtra("slot",s1.getText().toString());
                startActivity(intent);
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(BookSlot.this,ParkingForm.class);
                intent.putExtra("slot",s2.getText().toString());
                startActivity(intent);
            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(BookSlot.this,ParkingForm.class);
                intent.putExtra("slot",s3.getText().toString());
                startActivity(intent);
            }
        });

        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(BookSlot.this,ParkingForm.class);
                intent.putExtra("slot",s4.getText().toString());
                startActivity(intent);
            }
        });

        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(BookSlot.this,ParkingForm.class);
                intent.putExtra("slot",s5.getText().toString());
                startActivity(intent);
            }
        });

        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(BookSlot.this,ParkingForm.class);
                intent.putExtra("slot",s6.getText().toString());
                startActivity(intent);
            }
        });
    }

}
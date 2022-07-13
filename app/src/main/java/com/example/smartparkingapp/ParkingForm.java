
package com.example.smartparkingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;
import android.os.Bundle;

public class ParkingForm extends AppCompatActivity {
    TextView slotnames,starttime,endtime,parkdate,tv;
    Button book;
    DBHelper2 DB2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_form);
        slotnames = findViewById(R.id.name);
        starttime= findViewById(R.id.starttime);
        endtime= findViewById(R.id.endtime);
        parkdate = findViewById(R.id.date);
        book = findViewById(R.id.book);
        DB2 = new DBHelper2(this);
        tv = findViewById(R.id.textView3);
        Bundle bundle = null;
        bundle = getIntent().getExtras();
        if(bundle != null) {
            String myslot = bundle.getString("slot");
            tv.setText(myslot);
        }

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String slotno= tv.getText().toString();
                String slotname = slotnames.getText().toString();
                String sttime = starttime.getText().toString();
                String entime= endtime.getText().toString();
                String pdate= parkdate.getText().toString();


                if (slotno.equals("") ||slotname.equals("") || sttime.equals("")||entime.equals("") || pdate.equals("")) {
                    Toast.makeText(ParkingForm.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean checkuserslot = DB2.checkslot(slotno);
                    if(checkuserslot == false)
                    {
                        Boolean insert = DB2.insertData(slotno,slotname,sttime,entime,pdate);
                        if(insert == true)
                        {
                            Toast.makeText(ParkingForm.this, "Slot Booked Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ParkingForm.this,UserDashboard.class);
                            intent.putExtra("slotno",slotno);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(ParkingForm.this, "Failed to book Slot!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(ParkingForm.this, "Slot already booked!, Please book another", Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });





    }
}


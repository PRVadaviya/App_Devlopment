package com.example.studentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DocterActivity extends AppCompatActivity {

    ImageView back ;
    Button booknow_2;
    Button booknow_3;
    Button booknow_4;
    Button booknow_5;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docter);

        back = (ImageView) findViewById(R.id.back);

        Button booknow_2 = findViewById(R.id.booknow_2);
        Button booknow_3 = findViewById(R.id.booknow_3);
        Button booknow_4 = findViewById(R.id.booknow_4);
        Button booknow_5 = findViewById(R.id.booknow_5);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DocterActivity.this,Home_page.class));
            }
        });

        booknow_2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                openDialog("8320016609" , "I would like to schedule an appointment for a DR.DHRUVISHA SAVALIYA MAM. Please let me know the available times. Thank you!");
            }

        });


        booknow_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                openDialog("8140211828" , "I would like to schedule an appointment for a DR.DRASHTI AMIPARA MAM. Please let me know the available times. Thank you!");
            }

        });

        booknow_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                openDialog("8140211828" ,"I would like to schedule an appointment for a DR.POOJA MANGUKIYA MAM. Please let me know the available times. Thank you!");
            }

        });

        booknow_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                openDialog("8140211828", "I would like to schedule an appointment for a DR.MANASVI VAGHANI MAM. Please let me know the available times. Thank you!");
            }

        });

    }

    public void openDialog(String number , String msg)
    {
        BookSucessfully myDialog = new BookSucessfully(number , msg);
        myDialog.show(getSupportFragmentManager(), "My Dialog ");
    }


}
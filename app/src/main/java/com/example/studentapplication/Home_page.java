package com.example.studentapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Home_page extends AppCompatActivity
{

    CardView health_update;
    ImageView doctor_detail;
    ImageView edit;
    ImageView medi ;
    ImageView lab ;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        health_update = (CardView) findViewById(R.id.health_update);
        doctor_detail = (ImageView) findViewById(R.id.doctor_click);
        edit = (ImageView) findViewById(R.id.profile_edit);
        medi = (ImageView) findViewById(R.id.Medicine);
        lab = (ImageView) findViewById(R.id.lab);

        lab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Home_page.this , Labtest.class);
                startActivity(in);
            }
        });


        medi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(Home_page.this , Medicine_Activity.class);
                startActivity(i1);
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i2 = new Intent(Home_page.this , Profile_Activity.class);
                startActivity(i2);
            }
        });

        health_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.who.int/"));
                startActivity(intent);
            }
        });


        doctor_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Home_page.this, DocterActivity.class);
                startActivity(intent);
            }
        });
    }
}
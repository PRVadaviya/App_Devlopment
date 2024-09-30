package com.example.studentapplication;



import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DocterActivity extends AppCompatActivity {

    Button booknow_2;
    Button booknow_3;
    Button booknow_4;
    Button booknow_5;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docter);



         Button booknow_2 = findViewById(R.id.booknow_2);
        Button booknow_3 = findViewById(R.id.booknow_3);
        Button booknow_4 = findViewById(R.id.booknow_4);
        Button booknow_5 = findViewById(R.id.booknow_5);



        booknow_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DocterActivity.this,BookDocterActivity.class));

            }
        });

        booknow_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DocterActivity.this,BookDocterActivity.class));
            }
        });

        booknow_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DocterActivity.this,BookDocterActivity.class));
            }
        });

        booknow_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DocterActivity.this,BookDocterActivity.class));
            }
        });

    }
}
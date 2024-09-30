package com.example.studentapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class Profile_Activity extends AppCompatActivity
{
    TextView profile_logout;
    SharedPreferences sp;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profile_logout = findViewById(R.id.profile_logout);
        sp = getSharedPreferences("login",MODE_PRIVATE);
        profile_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                SharedPreferences.Editor edit = sp.edit();
                edit.clear();
                edit.apply();
                startActivity(new Intent(Profile_Activity.this, MainActivity.class));
            }
        });

    }
}
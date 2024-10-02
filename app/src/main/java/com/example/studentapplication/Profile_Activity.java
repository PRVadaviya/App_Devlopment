package com.example.studentapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class Profile_Activity extends AppCompatActivity
{
    TextView profile_logout,Email,contact , username;
    SharedPreferences sp;
    DBHandler db;
    String email ;
    MyDataType data = new MyDataType() ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profile_logout = findViewById(R.id.profile_logout);
        Email = findViewById(R.id.profile_email);
        contact = findViewById(R.id.profile_phoneno);
        username = findViewById(R.id.profile_username);
        db = new DBHandler(this);


        sp = getSharedPreferences("login",MODE_PRIVATE);

        email = sp.getString("email" , null);

        data = db.getData(email);


           Email.setText("Email    : " + email);
         contact.setText("Phone    : " + data.phone);
        username.setText("User      :  " + data.name);

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
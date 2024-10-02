package com.example.studentapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Medicine_Activity extends AppCompatActivity {

    ImageView back ;
    Button b1 , b2 , b3 , b4 , b5 , b6 ;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);

        back = (ImageView) findViewById(R.id.back);
        b1 = (Button) findViewById(R.id.addnow_1);
        b2 = (Button) findViewById(R.id.addnow_2);
        b3 = (Button) findViewById(R.id.addnow_3);
        b4 = (Button) findViewById(R.id.addnow_4);
        b5 = (Button) findViewById(R.id.addnow_5);
        b6 = (Button) findViewById(R.id.addnow_6);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Medicine_Activity.this,Home_page.class));
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                openDialog("8140211828" , "I would like to request a booking for the following medicine: Upsire-D3 1000lU Capsule. Please confirm availability and delivery options. Thank you!");
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                openDialog("8140211828" , "I would like to request a booking for the following medicine: DOLO 650 TABLET. Please confirm availability and delivery options. Thank you!");
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                openDialog("8140211828" , "I would like to request a booking for the following medicine: HealthVit Chromium Picolinate. Please confirm availability and delivery options. Thank you!");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                openDialog("8140211828" , "I would like to request a booking for the following medicine: Tata 1mg Calsium + Vitamin D3. Please confirm availability and delivery options. Thank you!");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                openDialog("8140211828" , "I would like to request a booking for the following medicine: Vitamin B Complex Capsules. Please confirm availability and delivery options. Thank you!");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                openDialog("8140211828" , "I would like to request a booking for the following medicine: Vitamin D Complex Capsules. Please confirm availability and delivery options. Thank you!");
            }

        });
    }

    public void openDialog(String number , String msg)
    {
        BookSucessfully myDialog = new BookSucessfully(number , msg);
        myDialog.show(getSupportFragmentManager(), "My Dialog");
    }
}
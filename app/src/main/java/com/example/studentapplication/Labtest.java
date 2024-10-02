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

public class Labtest extends AppCompatActivity {

    ImageView back ;
    Button b1 , b2 , b3 , b4 , b5 , b6 ;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labtest);

        back = (ImageView) findViewById(R.id.back);
        b1 = (Button) findViewById(R.id.buynow_1);
        b2 = (Button) findViewById(R.id.buynow_2);
        b3 = (Button) findViewById(R.id.buynow_3);
        b4 = (Button) findViewById(R.id.buynow_4);
        b5 = (Button) findViewById(R.id.buynow_5);
        b6 = (Button) findViewById(R.id.buynow_6);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Labtest.this,Home_page.class));
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                openDialog("8140211828" , "I would like to schedule an appointment for a Iron Studies test . Please let me know the available times. Thank you!");
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                openDialog("8140211828" , "I would like to schedule an appointment for a Blood Glucose Fasting test . Please let me know the available times. Thank you!"  );
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                openDialog("8140211828" , "I would like to schedule an appointment for a Liver function test . Please let me know the available times. Thank you!");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                openDialog("8140211828" , "I would like to schedule an appointment for a Complete Hemogram test . Please let me know the available times. Thank you!");
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                openDialog("8140211828" , "I would like to schedule an appointment for a Lipid Profile test . Please let me know the available times. Thank you!");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                openDialog("8140211828" , "I would like to schedule an appointment for a Kidney Function test . Please let me know the available times. Thank you!");
            }

        });
    }

    public void openDialog(String number , String msg)
    {
        BookSucessfully myDialog = new BookSucessfully(number , msg);
        myDialog.show(getSupportFragmentManager(), "My Dialog");
    }

}
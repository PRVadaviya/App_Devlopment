package com.example.studentapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Sign_up extends AppCompatActivity
{

    TextView Signin;
    EditText name , email , password , phone_no , repassword;
    Button sign_up;
    MyDataType mdt ;
    DBHandler dh ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);

        Signin = (TextView) findViewById(R.id.Sign_up_now);
        name = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.confirmpassword);
        phone_no = findViewById(R.id.phone);
        sign_up = findViewById(R.id.login_button);

        dh = new DBHandler(this);
        mdt = new MyDataType();
        Intent intent1 = new Intent(Sign_up.this,MainActivity.class);

        Signin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(intent1);
            }
        });

        sign_up.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mdt.name = name.getText().toString();
                mdt.email = email.getText().toString();
                mdt.password = password.getText().toString();
                mdt.phone = phone_no.getText().toString();
                dh.addInfo(mdt);
                startActivity(intent1);
            }
        });
    }
}
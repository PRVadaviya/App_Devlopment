package com.example.studentapplication;

import static com.example.studentapplication.R.id.Sign_up_now;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int Splash_DelayMillis = 1500;

    EditText email ;
    EditText password ;
    Button loginButton ;
    TextView Signup ;
    DBHandler dh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dh = new DBHandler(this);

        Signup = (TextView) findViewById(Sign_up_now);
        Intent intent1 = new Intent(MainActivity.this,Sign_up.class);
        Intent intent2 = new Intent(MainActivity.this,Home_page.class);

        Signup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(intent1);
            }
        });

        email = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.login_button);

        loginButton.setOnClickListener(v->{

            if(email.getText().toString().isEmpty() || password.getText().toString().isEmpty())
            {
                Toast.makeText(getApplicationContext(),"Please",Toast.LENGTH_SHORT).show();
            }
            else
            {
                MyDataType mdt = new MyDataType();
                mdt.email = email.getText().toString();
                mdt.password = password.getText().toString();
                boolean exist = dh.userAuthentication(mdt);

                if(exist)
                {
                    startActivity(intent2);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Please2344",Toast.LENGTH_SHORT).show();
                }

            }

        });

    }

}
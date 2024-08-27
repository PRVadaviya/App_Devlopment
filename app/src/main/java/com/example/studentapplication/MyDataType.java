package com.example.studentapplication;

import android.util.Log;

public class MyDataType
{
    int id;
    String name;
    String email;
    String phone;
    String password;


    public void display(){
        Log.d("UserInfo","Id : "+id+", name : "+ name+", email : "+email+", phone : "+phone+", pass : "+password);
}
}
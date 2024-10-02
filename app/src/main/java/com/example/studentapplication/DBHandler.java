package com.example.studentapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "HealthCareApp";
    private static final String TABLE_INFO = "userdata";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PHONE_NO = "phone_number";
    private static final String KEY_PASSWORD = "password";


    DBHandler(Context context){
        super(context,DB_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

//        db.execSQL("CREATE TABLE "+TABLE_INFO+"( "+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+KEY_NAME+
//                " TEXT NOT NULL, " +KEY_EMAIL+" TEXT NOT NULL, "+KEY_PHONE_NO+" TEXT NOT NULL, "+KEY_PASSWORD+" TEXT NOT NULL)");

        db.execSQL("CREATE TABLE "+TABLE_INFO+"( "+KEY_NAME+
                " TEXT NOT NULL, " +KEY_EMAIL+" TEXT PRIMARY KEY, "+KEY_PHONE_NO+" TEXT NOT NULL, "+KEY_PASSWORD+" TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_INFO);
        onCreate(db);

    }

    public void addInfo(MyDataType mdt){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_NAME,mdt.name);
        values.put(KEY_EMAIL,mdt.email);
        values.put(KEY_PHONE_NO,mdt.phone);
        values.put(KEY_PASSWORD,mdt.password);

        db.insert(TABLE_INFO,null,values);
        db.close();
    }

    public ArrayList<MyDataType> getInfo(){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_INFO,null);

        ArrayList<MyDataType> list = new ArrayList<>();

        while(cursor.moveToNext()){
            MyDataType mdt = new MyDataType();
            mdt.name = cursor.getString(0);
            mdt.email = cursor.getString(1);
            mdt.phone = cursor.getString(2);
            mdt.password = cursor.getString(3);
            list.add(mdt);
        }
        cursor.close();
        db.close();
        return list;
    }

    boolean userAuthentication(MyDataType mdt){
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM "+TABLE_INFO+" WHERE "+KEY_EMAIL+" = ? AND "+KEY_PASSWORD+" = ?";

        Cursor cursor = db.rawQuery(query,new String[]{mdt.email,mdt.password});
        boolean exist = false;
        if(cursor != null && cursor.getCount() > 0){
            exist = true;
        }
        cursor.close();
        db.close();
        return exist;
    }

    public void deleteAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLE_INFO);
        db.close();
}


    public MyDataType getData(String email){
        SQLiteDatabase db = getReadableDatabase();
        String query = "select * from "+TABLE_INFO+" where "+KEY_EMAIL+" = ?";
        Cursor cursor = db.rawQuery(query,new String[]{email});
        MyDataType data = new MyDataType();
        if(cursor.getCount() == 0){
            Log.d("database","cursor is empty");
        }

        while(cursor.moveToNext()){
            MyDataType mdt = new MyDataType();
            data.name = cursor.getString(cursor.getColumnIndexOrThrow(KEY_NAME));
            Log.d("database","cursor is "+data.name);
            data.email = cursor.getString(cursor.getColumnIndexOrThrow(KEY_EMAIL));
            Log.d("database","cursor is "+data.email);
            data.phone = cursor.getString(cursor.getColumnIndexOrThrow(KEY_PHONE_NO));
            Log.d("database","cursor is "+data.phone);
            data.password = cursor.getString(cursor.getColumnIndexOrThrow(KEY_PASSWORD));
            Log.d("database","cursor is "+data.password);
        }
        return data;
    }

}
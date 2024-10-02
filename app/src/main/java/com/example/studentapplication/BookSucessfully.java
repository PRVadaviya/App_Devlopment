package com.example.studentapplication;

import static android.app.PendingIntent.getActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BookSucessfully extends AppCompatDialogFragment {

    String number;
    String msg ;

    BookSucessfully(String number){

    }

    BookSucessfully(String number , String msg){
        this.number = number;
        this.msg = msg ;
    }



    public Dialog onCreateDialog (@Nullable Bundle savedInstanceState)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("My Dialog Information") ;

        builder.setMessage("This is a message from my dialog").setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                try
                {

                    SmsManager smsManager=SmsManager.getDefault();
                    smsManager.sendTextMessage(number,null,msg,null,null);
                    Toast.makeText(getContext(),"Message Sent",Toast.LENGTH_LONG).show();
                }

                catch (Exception e)
                {
                    Log.d("Message","Error : "+e);
                }
            }
        });

        return builder.create();
    }

    }

package com.codearteam.testdatabase;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(getApplicationContext(), getDataDB(), Toast.LENGTH_LONG).show();
    }


    private String getDataDB()  {
        DatabaseHelper myDbHelper = new DatabaseHelper(getApplicationContext());

        String word = "";

        try {
            myDbHelper.createDataBase();
        } catch (IOException ioe) {
            Toast.makeText(getApplicationContext(), ioe.getMessage(), Toast.LENGTH_LONG).show();
        }

        myDbHelper.openDataBase();

        Cursor myData = myDbHelper.RawQuery();


        myData.moveToFirst();
        word = myData.getString(0);

        myData.close();
        myDbHelper.close();

        return word;
    }


}
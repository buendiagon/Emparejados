package com.example.bienestaraprendiz.emparejapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bienestaraprendiz.emparejapp.BD.crud;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ContentValues registr=new ContentValues();
        registr.put("nombre","daniel");
        registr.put("puntaje","0");
        crud crear=new crud(this,"emparejados",null,1);
        crear.eliminar(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent pasar = new Intent(getApplicationContext(),names.class);
                startActivity(pasar);
                finish();
            }
        },2000);
    }
}

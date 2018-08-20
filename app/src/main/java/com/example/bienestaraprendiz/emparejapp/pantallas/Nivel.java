package com.example.bienestaraprendiz.emparejapp.pantallas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bienestaraprendiz.emparejapp.R;

public class Nivel extends AppCompatActivity {
    Button facil,medio,dificil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel);
        facil=findViewById(R.id.facilId);
        medio=findViewById(R.id.medioId);
        dificil=findViewById(R.id.dificilId);
        String player1=getIntent().getStringExtra("player1");
        String player2=getIntent().getStringExtra("player2");
        final Intent intent=new Intent(Nivel.this,Juego.class);
        intent.putExtra("player1",player1);
        intent.putExtra("player2",player2);
        facil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nivel=1;
                intent.putExtra("nivel",nivel);
                startActivity(intent);
            }
        });
        medio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nivel=2;
                intent.putExtra("nivel",nivel);
                startActivity(intent);
            }
        });
        dificil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nivel=3;
                intent.putExtra("nivel",nivel);
                startActivity(intent);
            }
        });
    }
}

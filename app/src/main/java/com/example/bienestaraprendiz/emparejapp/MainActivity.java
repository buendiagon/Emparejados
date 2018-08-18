package com.example.bienestaraprendiz.emparejapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bienestaraprendiz.emparejapp.pantallas.Nivel;

public class MainActivity extends AppCompatActivity {
    Button inicio, puntaje, configuracion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicio=findViewById(R.id.inicioId);
        puntaje=findViewById(R.id.puntajesId);
        configuracion=findViewById(R.id.configuracion);
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), Nivel.class);
                startActivity(intent);
            }
        });
        puntaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //puntaje
            }
        });
        configuracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //configuracion
            }
        });
    }
}

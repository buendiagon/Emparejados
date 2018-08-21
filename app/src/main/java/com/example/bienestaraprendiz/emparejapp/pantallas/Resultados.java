package com.example.bienestaraprendiz.emparejapp.pantallas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bienestaraprendiz.emparejapp.MainActivity;
import com.example.bienestaraprendiz.emparejapp.R;

public class Resultados extends AppCompatActivity {
    TextView player1,player2,puntaje1,puntaje2;
    Button jugar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        final String jugador1=getIntent().getStringExtra("player1");
        final String jugador2=getIntent().getStringExtra("player2");
        String score1=getIntent().getStringExtra("puntaje1");
        String score2=getIntent().getStringExtra("puntaje2");
        player1=findViewById(R.id.jugador1);
        player2=findViewById(R.id.jugador2);
        puntaje1=findViewById(R.id.score1);
        puntaje2=findViewById(R.id.score2);
        jugar=findViewById(R.id.volverJugar);
        player1.setText(jugador1);
        player2.setText(jugador2);
        puntaje1.setText(score1);
        puntaje2.setText(score2);
        jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Resultados.this, MainActivity.class);
                intent.putExtra("player1",jugador1);
                intent.putExtra("player2",jugador2);
                startActivity(intent);
            }
        });
    }
}

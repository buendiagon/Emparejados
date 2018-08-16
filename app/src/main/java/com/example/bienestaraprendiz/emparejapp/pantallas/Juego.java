package com.example.bienestaraprendiz.emparejapp.pantallas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bienestaraprendiz.emparejapp.Entidades.parejasVo;
import com.example.bienestaraprendiz.emparejapp.R;

import java.util.ArrayList;
import java.util.Random;

public class Juego extends AppCompatActivity {
    TextView Player1,Player2,Puntaje1,Puntaje2;
    ImageView ima1,ima2,ima3,ima4,ima5,ima6,ima7,ima8;
    ArrayList<parejasVo> parejas;
    ArrayList<ImageView> juega;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        Player1=findViewById(R.id.player1Id);
        Player2=findViewById(R.id.player2Id);
        Puntaje1=findViewById(R.id.puntaje1Id);
        Puntaje2=findViewById(R.id.puntaje2Id);
        ima1=findViewById(R.id.imagen1);
        ima2=findViewById(R.id.imagen2);
        ima3=findViewById(R.id.imagen3);
        ima4=findViewById(R.id.imagen4);
        ima5=findViewById(R.id.imagen5);
        ima6=findViewById(R.id.imagen6);
        ima7=findViewById(R.id.imagen7);
        ima8=findViewById(R.id.imagen8);
        parejas= new ArrayList<>();
        llenarTarjetas();
    }

    private void llenarTarjetas() {
        Random rnd=new Random();
        //cambiar drawable
        parejas.add(new parejasVo(R.drawable.ic_launcher_background,false));
        parejas.add(new parejasVo(R.drawable.ic_launcher_background,false));
        parejas.add(new parejasVo(R.drawable.ic_launcher_background,false));
        parejas.add(new parejasVo(R.drawable.ic_launcher_background,false));
        int j=0;
        while (j<8) {
            Random random = new Random();
            int n = random.nextInt(3) + 0;
            int contador=0;
            for (int i = 0; i < j; i++) {

            }
            j++;
        }

    }
}

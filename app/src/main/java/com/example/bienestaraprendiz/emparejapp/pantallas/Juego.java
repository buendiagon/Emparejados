package com.example.bienestaraprendiz.emparejapp.pantallas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bienestaraprendiz.emparejapp.Entidades.parejasVo;
import com.example.bienestaraprendiz.emparejapp.R;

import java.util.ArrayList;
import java.util.Random;

public class Juego extends AppCompatActivity {
    TextView Player1,Player2,Puntaje1,Puntaje2;
    ImageView ima1,ima2,ima3,ima4,ima5,ima6,ima7,ima8,ima9,ima10,ima11,ima12,ima13,ima14,ima15,ima16;
    ArrayList<parejasVo> parejas;
    ArrayList<Integer> juega;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int nivel=getIntent().getIntExtra("nivel",0);
        if(nivel==1){
            setContentView(R.layout.activity_juego);
        }
        else if(nivel==2){
            setContentView(R.layout.medio);
            ima9=findViewById(R.id.imagen9);
            ima10=findViewById(R.id.imagen10);
            ima11=findViewById(R.id.imagen11);
            ima12=findViewById(R.id.imagen12);
        }
        else {
            setContentView(R.layout.dificil);
            ima9=findViewById(R.id.imagen9);
            ima10=findViewById(R.id.imagen10);
            ima11=findViewById(R.id.imagen11);
            ima12=findViewById(R.id.imagen12);
            ima13=findViewById(R.id.imagen13);
            ima14=findViewById(R.id.imagen14);
            ima15=findViewById(R.id.imagen15);
            ima16=findViewById(R.id.imagen16);
        }
        parejas= new ArrayList<>();
        juega= new ArrayList<>();
        Player1=findViewById(R.id.player1Id);
        Player2=findViewById(R.id.player2Id);
        Puntaje1=findViewById(R.id.puntaje1Id);
        Puntaje2=findViewById(R.id.puntaje2Id);
        juega.add(R.drawable.descarga);
        juega.add(R.drawable.descarga1);
        juega.add(R.drawable.descarga2);
        juega.add(R.drawable.descarga3);
        juega.add(R.drawable.descarga4);
        juega.add(R.drawable.descarga5);
        juega.add(R.drawable.descarga6);
        juega.add(R.drawable.descarga7);
        juega.add(R.drawable.espada);
        ima1=findViewById(R.id.imagen1);
        ima2=findViewById(R.id.imagen2);
        ima3=findViewById(R.id.imagen3);
        ima4=findViewById(R.id.imagen4);
        ima5=findViewById(R.id.imagen5);
        ima6=findViewById(R.id.imagen6);
        ima7=findViewById(R.id.imagen7);
        ima8=findViewById(R.id.imagen8);
        Tarjetas(nivel);
        llenarTarjetas(nivel);

    }

    private void llenarTarjetas(int nivel) {
        ima1.setImageResource(parejas.get(0).getImagen());
        ima2.setImageResource(parejas.get(1).getImagen());
        ima3.setImageResource(parejas.get(2).getImagen());
        ima4.setImageResource(parejas.get(3).getImagen());
        ima5.setImageResource(parejas.get(4).getImagen());
        ima6.setImageResource(parejas.get(5).getImagen());
        ima7.setImageResource(parejas.get(6).getImagen());
        ima8.setImageResource(parejas.get(7).getImagen());
        if(nivel==2){
            ima9.setImageResource(parejas.get(8).getImagen());
            ima10.setImageResource(parejas.get(9).getImagen());
            ima11.setImageResource(parejas.get(10).getImagen());
            ima12.setImageResource(parejas.get(11).getImagen());
        }
        else if(nivel==3){
            ima13.setImageResource(parejas.get(12).getImagen());
            ima14.setImageResource(parejas.get(13).getImagen());
            ima15.setImageResource(parejas.get(14).getImagen());
            ima16.setImageResource(parejas.get(15).getImagen());
            ima9.setImageResource(parejas.get(8).getImagen());
            ima10.setImageResource(parejas.get(9).getImagen());
            ima11.setImageResource(parejas.get(10).getImagen());
            ima12.setImageResource(parejas.get(11).getImagen());
        }
    }

    private void Tarjetas(int nivel) {
        for(int z=0;z<16;z++){
            parejas.add(z,new parejasVo(R.drawable.espada,false));
        }
        Random rnd=new Random(System.currentTimeMillis());
        int cartas=0;
        int aleatorio=0;
        if(nivel==1){
            aleatorio=8;
            cartas=4;
        }
        else if(nivel==2){
            aleatorio=12;
            cartas=6;
        }
        else if(nivel==3){
            aleatorio=16;
            cartas=8;
        }
        for (int i=0;i<cartas;i++){
            int n=rnd.nextInt(aleatorio)+0;
            for(int j=0;j<2;j++) {
                while (juega.get(8) != parejas.get(n).getImagen()) {
                    n = rnd.nextInt(aleatorio)+0;

                }
                parejas.set(n,new parejasVo(juega.get(i),false));
            }
        }
    }
}

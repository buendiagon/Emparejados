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
    ImageView ima1,ima2,ima3,ima4,ima5,ima6,ima7,ima8;
    ArrayList<parejasVo> parejas;
    ArrayList<Integer> juega;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        parejas= new ArrayList<>();
        juega= new ArrayList<>();
        Player1=findViewById(R.id.player1Id);
        Player2=findViewById(R.id.player2Id);
        Puntaje1=findViewById(R.id.puntaje1Id);
        Puntaje2=findViewById(R.id.puntaje2Id);
        parejas.add(new parejasVo(R.drawable.descarga,false));
        parejas.add(new parejasVo(R.drawable.descarga1,false));
        parejas.add(new parejasVo(R.drawable.descarga2,false));
        parejas.add(new parejasVo(R.drawable.descarga3,false));
        parejas.add(new parejasVo(R.drawable.descarga4,false));
        parejas.add(new parejasVo(R.drawable.descarga5,false));
        parejas.add(new parejasVo(R.drawable.descarga6,false));
        parejas.add(new parejasVo(R.drawable.descarga7,false));
        parejas.add(new parejasVo(R.drawable.ic_launcher_background,false));
        ima1=findViewById(R.id.imagen1);
        ima2=findViewById(R.id.imagen2);
        ima3=findViewById(R.id.imagen3);
        ima4=findViewById(R.id.imagen4);
        ima5=findViewById(R.id.imagen5);
        ima6=findViewById(R.id.imagen6);
        ima7=findViewById(R.id.imagen7);
        ima8=findViewById(R.id.imagen8);
        Tarjetas(1);
        llenarTarjetas();

    }

    private void llenarTarjetas() {
        ima1.setImageResource(juega.get(0));
        ima2.setImageResource(juega.get(1));
        ima3.setImageResource(juega.get(2));
        ima4.setImageResource(juega.get(3));
        ima5.setImageResource(juega.get(4));
        ima6.setImageResource(juega.get(5));
        ima7.setImageResource(juega.get(6));
        ima8.setImageResource(juega.get(7));
    }

    private void Tarjetas(int nivel) {
        for(int z=0;z<16;z++){
            juega.add(parejas.get(8).getImagen());
        }
        Random rnd=new Random(System.currentTimeMillis());
        int cartas=0;
        int aleatorio=0;
        //cambiar drawable
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
            int n=rnd.nextInt(aleatorio-1)+0;
            for(int j=0;j<2;j++) {
                while (juega.get(n) != parejas.get(8).getImagen()) {
                    n = rnd.nextInt(aleatorio-1)+0;

                }
                juega.add(n,parejas.get(i).getImagen());
                Toast.makeText(getApplicationContext(),"carta:"+i+" en "+String.valueOf(n),Toast.LENGTH_SHORT).show();
            }
        }
    }
}

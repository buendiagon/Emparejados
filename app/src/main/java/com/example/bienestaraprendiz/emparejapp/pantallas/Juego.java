package com.example.bienestaraprendiz.emparejapp.pantallas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
    ArrayList<Integer> voltea;
    ArrayList<Integer> voltea1;
    int click=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int nivel=getIntent().getIntExtra("nivel",0);
        voltea=new ArrayList<>();
        voltea1=new ArrayList<>();
        if(nivel==1){
            setContentView(R.layout.activity_juego);
        }
        else if(nivel==2){
            setContentView(R.layout.medio);
            voltea.add((ima9=findViewById(R.id.imagen9)).getId());
            voltea.add((ima10=findViewById(R.id.imagen10)).getId());
            voltea.add((ima11=findViewById(R.id.imagen11)).getId());
            voltea.add((ima12=findViewById(R.id.imagen12)).getId());
        }
        else {
            setContentView(R.layout.dificil);
            voltea1.add((ima9=findViewById(R.id.imagen9)).getId());
            voltea1.add((ima10=findViewById(R.id.imagen10)).getId());
            voltea1.add((ima11=findViewById(R.id.imagen11)).getId());
            voltea1.add((ima12=findViewById(R.id.imagen12)).getId());
            voltea1.add((ima13=findViewById(R.id.imagen13)).getId());
            voltea1.add((ima14=findViewById(R.id.imagen14)).getId());
            voltea1.add((ima15=findViewById(R.id.imagen15)).getId());
            voltea1.add((ima16=findViewById(R.id.imagen16)).getId());
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
        juega.add((ima1=findViewById(R.id.imagen1)).getId());
        juega.add((ima2=findViewById(R.id.imagen2)).getId());
        juega.add((ima3=findViewById(R.id.imagen3)).getId());
        juega.add((ima4=findViewById(R.id.imagen4)).getId());
        juega.add((ima5=findViewById(R.id.imagen5)).getId());
        juega.add((ima6=findViewById(R.id.imagen6)).getId());
        juega.add((ima7=findViewById(R.id.imagen7)).getId());
        juega.add((ima8=findViewById(R.id.imagen8)).getId());
        Tarjetas(nivel);
        if(click==2){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            llenarTarjetas(nivel);
            click=0;
        }

    }


    private void llenarTarjetas(int nivel) {
        ima1.setImageResource(juega.get(8));
        ima2.setImageResource(juega.get(8));
        ima3.setImageResource(juega.get(8));
        ima4.setImageResource(juega.get(8));
        ima5.setImageResource(juega.get(8));
        ima6.setImageResource(juega.get(8));
        ima7.setImageResource(juega.get(8));
        ima8.setImageResource(juega.get(8));
        if(nivel==2){
            ima9.setImageResource(juega.get(8));
            ima10.setImageResource(juega.get(8));
            ima11.setImageResource(juega.get(8));
            ima12.setImageResource(juega.get(8));
        }
        else if(nivel==3){
            ima9.setImageResource(juega.get(8));
            ima10.setImageResource(juega.get(8));
            ima11.setImageResource(juega.get(8));
            ima12.setImageResource(juega.get(8));
            ima13.setImageResource(juega.get(8));
            ima14.setImageResource(juega.get(8));
            ima15.setImageResource(juega.get(8));
            ima16.setImageResource(juega.get(8));
        }
    }
    public void voltear(View view) throws InterruptedException {
        ImageView imagen;
        int id=view.getId();
        int nivel=getIntent().getIntExtra("nivel",0);;
        for(int i=9;i<17;i++){
            if(id==juega.get(i)){
                imagen=view.findViewById(id);
                imagen.setImageResource(parejas.get(i-9).getImagen());
                click++;
            }
        }
        if(!voltea.isEmpty()){
            for(int i=0;i<4;i++){
                if(voltea.get(i)==id) {
                    imagen = view.findViewById(id);
                    imagen.setImageResource(parejas.get(i+8).getImagen());
                    click++;
                }
            }
        }

        if(!voltea1.isEmpty()){
            for(int i=0;i<8;i++){
                if(voltea1.get(i)==id) {
                    imagen = view.findViewById(id);
                    imagen.setImageResource(parejas.get(i+8).getImagen());
                    click++;
                }
            }
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

package com.example.bienestaraprendiz.emparejapp.pantallas;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bienestaraprendiz.emparejapp.Entidades.listaVo;
import com.example.bienestaraprendiz.emparejapp.Entidades.parejasVo;
import com.example.bienestaraprendiz.emparejapp.R;

import java.util.ArrayList;
import java.util.Random;

public class Juego extends AppCompatActivity {
    TextView Player1,Player2,Puntaje1,Puntaje2;
    ImageView ima1,ima2,ima3,ima4,ima5,ima6,ima7,ima8,ima9,ima10,ima11,ima12,ima13,ima14,ima15,ima16;
    ArrayList<parejasVo> parejas;
    ArrayList<listaVo> juega;
    ArrayList<Integer> juego;
    int click=0,pareja=0;
    int anterior=0;
    int verificar=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        juega= new ArrayList<>();
        int nivel=getIntent().getIntExtra("nivel",0);if(nivel==1){
            setContentView(R.layout.activity_juego);
        }
        else if(nivel==2){
            setContentView(R.layout.medio);
            juega.add(new listaVo((ima9=findViewById(R.id.imagen9)).getId(),nivel));juega.add(new listaVo((ima10=findViewById(R.id.imagen10)).getId(),nivel));juega.add(new listaVo((ima11=findViewById(R.id.imagen11)).getId(),nivel));juega.add(new listaVo((ima12=findViewById(R.id.imagen12)).getId(),nivel));
        }
        if(nivel==3) {
            setContentView(R.layout.dificil);
            juega.add(new listaVo((ima9=findViewById(R.id.imagen9)).getId(),nivel));juega.add(new listaVo((ima10=findViewById(R.id.imagen10)).getId(),nivel));juega.add(new listaVo((ima11=findViewById(R.id.imagen11)).getId(),nivel));juega.add(new listaVo((ima12=findViewById(R.id.imagen12)).getId(),nivel));
            juega.add(new listaVo((ima13=findViewById(R.id.imagen13)).getId(),nivel));juega.add(new listaVo((ima14=findViewById(R.id.imagen14)).getId(),nivel));juega.add(new listaVo((ima15=findViewById(R.id.imagen15)).getId(),nivel));juega.add(new listaVo((ima16=findViewById(R.id.imagen16)).getId(),nivel));
        }

        parejas= new ArrayList<>();
        juego=new ArrayList<>();
        Player1=findViewById(R.id.player1Id);
        Player2=findViewById(R.id.player2Id);
        Puntaje1=findViewById(R.id.puntaje1Id);
        Puntaje2=findViewById(R.id.puntaje2Id);
        parejas.add(0,new parejasVo(R.drawable.descarga,false));parejas.add(1,new parejasVo(R.drawable.descarga1,false));parejas.add(2,new parejasVo(R.drawable.descarga2,false));parejas.add(3,new parejasVo(R.drawable.descarga3,false));parejas.add(4,new parejasVo(R.drawable.descarga4,false));
        parejas.add(5,new parejasVo(R.drawable.descarga5,false));parejas.add(6,new parejasVo(R.drawable.descarga6,false));parejas.add(7,new parejasVo(R.drawable.descarga7,false));parejas.add(8,new parejasVo(R.drawable.espada,false));
        juega.add(new listaVo((ima1=findViewById(R.id.imagen1)).getId(),nivel));juega.add(new listaVo((ima2=findViewById(R.id.imagen2)).getId(),nivel));juega.add(new listaVo((ima3=findViewById(R.id.imagen3)).getId(),nivel));juega.add(new listaVo((ima4=findViewById(R.id.imagen4)).getId(),nivel));
        juega.add(new listaVo((ima5=findViewById(R.id.imagen5)).getId(),nivel));juega.add(new listaVo((ima6=findViewById(R.id.imagen6)).getId(),nivel));juega.add(new listaVo((ima7=findViewById(R.id.imagen7)).getId(),nivel));juega.add(new listaVo((ima8=findViewById(R.id.imagen8)).getId(),nivel));
        Tarjetas(nivel);

    }
    private void Tarjetas(int nivel) {
        for(int z=0;z<16;z++){
            juego.add(Integer.valueOf(parejas.get(8).getImagen()));
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
                while (!juego.get(n).equals(parejas.get(8).getImagen())) {
                    n = rnd.nextInt(aleatorio)+0;
                }

                juego.set(n,parejas.get(i).getImagen());
            }
            //Toast.makeText(getApplicationContext(),"carta:"+juega.get(n).toString()+" en "+String.valueOf(parejas.get(i).getImagen()),Toast.LENGTH_SHORT).show();
        }
    }
    public void llenarTarjetas(int nivel){
        ima1.setImageResource(parejas.get(8).getImagen());ima2.setImageResource(parejas.get(8).getImagen());ima3.setImageResource(parejas.get(8).getImagen());ima4.setImageResource(parejas.get(8).getImagen());ima5.setImageResource(parejas.get(8).getImagen());ima6.setImageResource(parejas.get(8).getImagen());ima7.setImageResource(parejas.get(8).getImagen());ima8.setImageResource(parejas.get(8).getImagen());
        if(nivel>=2) {
            ima9.setImageResource(parejas.get(8).getImagen());ima10.setImageResource(parejas.get(8).getImagen());ima11.setImageResource(parejas.get(8).getImagen());ima12.setImageResource(parejas.get(8).getImagen());
        }
        if(nivel==3){
            ima13.setImageResource(parejas.get(8).getImagen());ima14.setImageResource(parejas.get(8).getImagen());ima15.setImageResource(parejas.get(8).getImagen());ima16.setImageResource(parejas.get(8).getImagen());
        }
    }
    public void voltear(final View view){
        final int maxi;
        int si=0;
        final int anterior1=anterior;
        final int max=juega.get(0).getNivel();if(max==1) maxi=8;else if(max==2) maxi=12; else maxi=16;
        ImageView imagen;
        for(int i=0;i<maxi;i++){
            if(view.getId()==juega.get(i).getNombre()){
                imagen=findViewById(view.getId());
                imagen.setImageResource(juego.get(i));
                if(anterior!=view.getId()){
                    click++;
                    if(verificar==juego.get(i) && click==2){
                        si=1;
                        pareja++;
                    }else verificar=juego.get(i);
                    anterior=view.getId();
                }
                break;
            }
        }
        if(click==2){
            final int finalSi = si;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    anterior=0;
                    if(finalSi==1){
                        findViewById(view.getId()).setVisibility(view.INVISIBLE);
                        findViewById(anterior1).setVisibility(view.INVISIBLE);
                    }
                    llenarTarjetas(max);
                    verificar=0;
                    click=0;
                }
            },1000);
            Log.d("juego",String.valueOf(pareja));
            if(pareja==maxi/2){
                Toast.makeText(getApplicationContext(),"Has ganado",Toast.LENGTH_SHORT).show();
            }
        }

    }
}

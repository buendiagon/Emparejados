package com.example.bienestaraprendiz.emparejapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class names extends AppCompatActivity {
    Button ingresar,iniciar,pausar,reiniciar,temporizador;
    EditText name1,name2;
    Chronometer chronometro;
    long detenerse;
    boolean Running;
    TextView mostrartem;
    int count = 30;
    Boolean running = true;
//    String opciones[]={"empezar de nuevo","salir","noseee"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_names);
        ingresar=findViewById(R.id.ingresar);
        name1 = findViewById(R.id.name1);
        name2 = findViewById(R.id.name2);
        iniciar = findViewById(R.id.iniciar);
        pausar = findViewById(R.id.pausar);
        reiniciar = findViewById(R.id.reiniciar);
        chronometro = findViewById(R.id.chronometro);
        temporizador = findViewById(R.id.temporizador);
        mostrartem = findViewById(R.id.mostrartem);


        temporizador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                starttem();
            }
        });
        
        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarchronometro();
            }
        });

        pausar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pausarchronometro();
            }
        });

        reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reiniciarchronometro();
            }
        });

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name1.getText().toString().equals("") || name2.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Ingrese el nombre por favor",Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent=new Intent(names.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void starttem() {
//        final Thread nuevo = new Thread(){
//            @Override
//            public void run(){
//                while (!isInterrupted()){
//                    try {
//                        Thread.sleep(1000);
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                count --;
//                                mostrartem.setText(String.valueOf(count));
////                                if (count == 25){
////                                    Toast.makeText(getApplicationContext(),"se acabooo",Toast.LENGTH_SHORT).show();
//////            finish();
////
////                                }
//
//                            }
//                        });
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
//        nuevo.start();


        final Thread nuevo = new Thread(){
            @Override
            public void run(){
                while (!isInterrupted()){
                    try {

                        Thread.sleep(1000);

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    count --;
                                    mostrartem.setText(String.valueOf(count));
                                    if (count == 25){
//                                        Toast.makeText(getApplicationContext(),"acaboooo",Toast.LENGTH_SHORT).show();
//                                        running = false;
//                                        nuevo.interrupt();
//                                        Thread.interrupted();
//                                        Runtime.getRuntime().exit(1);
//                                        Thread.interrupted();
//                                        mostrartem.setVisibility(View.INVISIBLE);
//                                        temporizador.setVisibility(View.INVISIBLE);
                                        AlertDialog.Builder mostrar = new AlertDialog.Builder(names.this);
                                        mostrar
                                                .setTitle("Se acabo el tiempo")
                                                .setCancelable(false)
                                                .setPositiveButton("nuevo", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialogInterface, int i) {
                                                        Intent nuevo = new Intent(names.this,names.class);
                                                        startActivity(nuevo);
                                                        finish();
                                                    }
                                                })
                                                .setNegativeButton("salir", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialogInterface, int i) {
                                                        finish();
                                                    }
                                                });
                                        AlertDialog ver = mostrar.create();
                                        ver.show();
                                    }

                                }
                            });


                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        nuevo.start();


}


    private void reiniciarchronometro() {
        chronometro.setBase(SystemClock.elapsedRealtime());
        detenerse = 0;
        chronometro.stop();
    }

    private void pausarchronometro() {
        if (Running){
            chronometro.stop();
            detenerse = SystemClock.elapsedRealtime() - chronometro.getBase();
            Running = false;
        }
    }

    private void iniciarchronometro() {
        if (!Running){
            chronometro.setBase(SystemClock.elapsedRealtime() - detenerse);
            chronometro.start();
            Running = true;
            
        }
    }
}

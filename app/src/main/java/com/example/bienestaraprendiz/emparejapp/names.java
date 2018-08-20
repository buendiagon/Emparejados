package com.example.bienestaraprendiz.emparejapp;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bienestaraprendiz.emparejapp.BD.crud;
import com.example.bienestaraprendiz.emparejapp.pantallas.Juego;

public class names extends AppCompatActivity {
    Button ingresar;
    EditText name1,name2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_names);
        ingresar=findViewById(R.id.ingresar);
        name1 = findViewById(R.id.name1);
        name2 = findViewById(R.id.name2);
        final crud crear=new crud(this,"emparejados",null, 1);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name1.getText().toString().equals("") || name2.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Ingrese el nombre por favor",Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent=new Intent(names.this,MainActivity.class);
                    intent.putExtra("player1",name1.getText().toString());
                    intent.putExtra("player2",name2.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}

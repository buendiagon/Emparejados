package com.example.bienestaraprendiz.emparejapp.pantallas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Adapter;

import com.example.bienestaraprendiz.emparejapp.Adaptadores.AdapterList;
import com.example.bienestaraprendiz.emparejapp.BD.crud;
import com.example.bienestaraprendiz.emparejapp.Entidades.ListaAdapter;
import com.example.bienestaraprendiz.emparejapp.Entidades.PuntajesVo;
import com.example.bienestaraprendiz.emparejapp.R;

import java.util.ArrayList;

public class AltosPuntajes extends AppCompatActivity {
    ArrayList<PuntajesVo> puntajesVos;
    ArrayList<ListaAdapter> lista;
    RecyclerView recyclerView;
    AdapterList adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altos_puntajes);
        resultado();
    }

    private void resultado() {
        crud con=new crud(this,"emparejados",null,1);
        lista=new ArrayList<>();
        for(int i=1;i<=6;i++) {
            puntajesVos=new ArrayList<>();
            con.consultar(this, "select * from tb_puntaje where nivel="+String.valueOf(i), puntajesVos);
            lista.add(new ListaAdapter(puntajesVos.get(0).getNombre(),
                    puntajesVos.get(1).getNombre(),
                    puntajesVos.get(2).getNombre(),
                    puntajesVos.get(3).getNombre(),
                    puntajesVos.get(4).getNombre(),
                    puntajesVos.get(0).getPuntaje(),
                    puntajesVos.get(1).getPuntaje(),
                    puntajesVos.get(2).getPuntaje(),
                    puntajesVos.get(3).getPuntaje(),
                    puntajesVos.get(4).getPuntaje()));
            Log.d("based", String.valueOf(i));
        }
        recyclerView=findViewById(R.id.recyclerId);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter=new AdapterList(lista);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
    }
}

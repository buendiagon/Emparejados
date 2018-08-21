package com.example.bienestaraprendiz.emparejapp.Adaptadores;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;

import com.example.bienestaraprendiz.emparejapp.Entidades.ListaAdapter;
import com.example.bienestaraprendiz.emparejapp.Entidades.PuntajesVo;
import com.example.bienestaraprendiz.emparejapp.R;

import java.util.ArrayList;

public class AdapterList extends RecyclerView.Adapter<AdapterList.ListaViewHolder> {
    ArrayList<ListaAdapter> puntajes;

    public AdapterList(ArrayList<ListaAdapter> puntajesVos) {
        this.puntajes=puntajesVos;
    }

    @NonNull
    @Override
    public AdapterList.ListaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup,false);
        return new ListaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterList.ListaViewHolder listaViewHolder, int i) {
        if(i==0)listaViewHolder.titulo.setText("Fácil"); else if(i==1)listaViewHolder.titulo.setText("Medio");else if(i==2)listaViewHolder.titulo.setText("Difícil");else if(i==3)listaViewHolder.titulo.setText("Fácil con tiempo");else if(i==4)listaViewHolder.titulo.setText("Medio con tiempo");else if(i==5)listaViewHolder.titulo.setText("Difícil con tiempo");
        listaViewHolder.nombre1.setText(puntajes.get(i).getNombre1());
        listaViewHolder.nombre2.setText(puntajes.get(i).getNombre2());
        listaViewHolder.nombre3.setText(puntajes.get(i).getNombre3());
        listaViewHolder.nombre4.setText(puntajes.get(i).getNombre4());
        listaViewHolder.nombre5.setText(puntajes.get(i).getNombre5());
        listaViewHolder.puntaje1.setText(String.valueOf(puntajes.get(i).getPuntaje1()));
        listaViewHolder.puntaje2.setText(String.valueOf(puntajes.get(i).getPuntaje2()));
        listaViewHolder.puntaje3.setText(String.valueOf(puntajes.get(i).getPuntaje3()));
        listaViewHolder.puntaje4.setText(String.valueOf(puntajes.get(i).getPuntaje4()));
        listaViewHolder.puntaje5.setText(String.valueOf(puntajes.get(i).getPuntaje5()));
    }
    @Override
    public int getItemCount() {
        return puntajes.size();
    }

    public class ListaViewHolder extends RecyclerView.ViewHolder {
        TextView nombre1,nombre2,nombre3,nombre4,nombre5,puntaje1,puntaje2,puntaje3,puntaje4,puntaje5,titulo;
        public ListaViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre1=itemView.findViewById(R.id.nombre1);
            nombre2=itemView.findViewById(R.id.nombre2);
            nombre3=itemView.findViewById(R.id.nombre3);
            nombre4=itemView.findViewById(R.id.nombre4);
            nombre5=itemView.findViewById(R.id.nombre5);
            puntaje1=itemView.findViewById(R.id.puntaje1);
            puntaje2=itemView.findViewById(R.id.puntaje2);
            puntaje3=itemView.findViewById(R.id.puntaje3);
            puntaje4=itemView.findViewById(R.id.puntaje4);
            puntaje5=itemView.findViewById(R.id.puntaje5);
            titulo=itemView.findViewById(R.id.Titulo);
        }
    }
}

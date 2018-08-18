package com.example.bienestaraprendiz.emparejapp.Entidades;

public class listaVo {
    int nombre;
    int nivel;
    public listaVo(int nombre,int nivel){
        this.nombre=nombre;
        this.nivel=nivel;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}

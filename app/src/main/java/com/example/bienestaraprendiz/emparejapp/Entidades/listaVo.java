package com.example.bienestaraprendiz.emparejapp.Entidades;

public class listaVo {
    String nombre;
    int puntaje;
    public listaVo(String nombre,int puntaje){
        this.nombre=nombre;
        this.puntaje=puntaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}

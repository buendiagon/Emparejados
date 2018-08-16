package com.example.bienestaraprendiz.emparejapp.Entidades;

public class parejasVo {
    int imagen;
    boolean vuelta;
    public parejasVo(int imagen, boolean vuelta){
        this.imagen=imagen;
        this.vuelta=vuelta;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public boolean isVuelta() {
        return vuelta;
    }

    public void setVuelta(boolean vuelta) {
        this.vuelta = vuelta;
    }
}

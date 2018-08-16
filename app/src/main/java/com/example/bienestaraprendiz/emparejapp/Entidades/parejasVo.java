package com.example.bienestaraprendiz.emparejapp.Entidades;

import android.widget.ImageView;

public class parejasVo {
    ImageView imagen;
    boolean vuelta;
    public parejasVo(int imagen, boolean vuelta){
        this.imagen=imagen;
        this.vuelta=vuelta;
    }

    public ImageView getImagen() {
        return imagen;
    }

    public void setImagen(ImageView imagen) {
        this.imagen = imagen;
    }

    public boolean isVuelta() {
        return vuelta;
    }

    public void setVuelta(boolean vuelta) {
        this.vuelta = vuelta;
    }
}

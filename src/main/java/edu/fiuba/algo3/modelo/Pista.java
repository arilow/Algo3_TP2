package edu.fiuba.algo3.modelo;

public class Pista {
    private String contenido;
    private String imagen;
    static int counter = 0;

    public Pista(String contenido) {

        this.contenido = contenido;

        counter++;
        if(counter > 3)
            counter = 1;
        imagen = "Image"+ counter + ".png";
    }

    public String mostrar() {
        return contenido;
    }

    public String obtenerImagen() {
        return imagen;
    }
}

package edu.fiuba.algo3.modelo;

import javafx.scene.shape.StrokeLineCap;

public class OrdenDeArresto {


    private boolean ejecutada;
    private String nombreLadron;

    public OrdenDeArresto(){
        this.ejecutada = false;
    }

    public OrdenDeArresto(String nombreLadron){
        this.nombreLadron = nombreLadron;
        this.ejecutada = true;
    }

    public boolean fueEjecutada(){
        return ejecutada;
    }

    public void ejecutarOrden(){
        this.ejecutada = true;
    }
}

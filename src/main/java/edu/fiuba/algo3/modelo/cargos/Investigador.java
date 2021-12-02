package edu.fiuba.algo3.modelo.cargos;

import edu.fiuba.algo3.modelo.Tiempo;

public class Investigador implements Cargo {
    private int cantidadArrestos;
    private int velocidadViaje = 1300; // km/h
    public int getCantidadArrestos() {
        return cantidadArrestos;
    }

    public void setCantidadArrestos(int cantidadArrestos) {
        this.cantidadArrestos = cantidadArrestos;
    }

    public void viajar(float distancia, Tiempo tiempo) {
        // TODO: arreglar rendondeo the division entera
        tiempo.sumarHoras((int) distancia/velocidadViaje);
    }

}

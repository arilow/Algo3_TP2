package edu.fiuba.algo3.modelo.cargos;

import edu.fiuba.algo3.modelo.Tiempo;

public class Novato implements Cargo {
    private int cantidadArrestos;
    private int velocidadViaje = 900; // km/h
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

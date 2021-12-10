package edu.fiuba.algo3.modelo.cargos;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Tiempo;

public class Sargento implements Cargo {

    Jugador jugador;
    private int velocidadViaje = 1500; // km/h
    @Override
    public void agregarArresto() {
        jugador.setCantidadArrestos( jugador.getCantidadArrestos()+ 1);
    }

    public void viajar(double distancia, Tiempo tiempo) {
        // TODO: arreglar rendondeo the division entera
        tiempo.sumarHoras((int) distancia/velocidadViaje);
    }

    @Override
    public void asignarJugador(Jugador jugador) {
        this.jugador = jugador;
    }

}

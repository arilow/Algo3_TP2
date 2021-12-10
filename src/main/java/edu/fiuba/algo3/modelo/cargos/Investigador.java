package edu.fiuba.algo3.modelo.cargos;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Tiempo;

public class Investigador implements Cargo {

    Jugador jugador;
    private int velocidadViaje = 1300; // km/h

    @Override
    public void agregarArresto() {
        jugador.setCantidadArrestos(jugador.getCantidadArrestos()+1);
        if (jugador.getCantidadArrestos() > 19) {
            jugador.asignarCargo(new Sargento());
        }
    }

    public void viajar(float distancia, Tiempo tiempo) {
        // TODO: arreglar rendondeo the division entera
        tiempo.sumarHoras((int) distancia/velocidadViaje);
    }

    @Override
    public void asignarJugador(Jugador jugador) {
        this.jugador = jugador;
    }
}

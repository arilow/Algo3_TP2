package edu.fiuba.algo3.modelo.cargos;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Tiempo;

public class Detective implements Cargo {

    private Jugador jugador;
    private int velocidadViaje = 1100; // km/h

    @Override
    public void agregarArresto() {
        jugador.setCantidadArrestos(jugador.getCantidadArrestos()+1);
        if (jugador.getCantidadArrestos() > 9) {
            jugador.asignarCargo(new Investigador());
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

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

    public void viajar(double distancia, Tiempo tiempo) {
        tiempo.sumarHoras((int) Math.round(distancia/velocidadViaje));
    }

    @Override
    public void asignarJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public String obtenerCargo() {return "investigador";}
}

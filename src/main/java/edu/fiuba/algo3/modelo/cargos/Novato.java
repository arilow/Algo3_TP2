package edu.fiuba.algo3.modelo.cargos;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Tiempo;

public class Novato implements Cargo {

    Jugador jugador;
    private int cantidadArrestos;
    private int velocidadViaje = 900; // km/h
    public int getCantidadArrestos() {
        return cantidadArrestos;
    }

    @Override
    public void agregarArresto() {
        jugador.setCantidadArrestos(jugador.getCantidadArrestos() + 1);
        if (jugador.getCantidadArrestos() > 4) {
            jugador.asignarCargo(new Detective());
        }
    }

    public void setCantidadArrestos(int cantidadArrestos) {
        this.cantidadArrestos = cantidadArrestos;
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

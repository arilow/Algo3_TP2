package edu.fiuba.algo3.modelo.cargos;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Tiempo;

public interface Cargo {
    void agregarArresto();
    void viajar(double diatancia, Tiempo tiempo);
    void asignarJugador(Jugador jugador);
    String obtenerCargo();
}

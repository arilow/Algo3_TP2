package edu.fiuba.algo3.modelo.cargos;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Tiempo;

public interface Cargo {
    void agregarArresto();
    void viajar(float diatancia, Tiempo tiempo);
    void asignarJugador(Jugador jugador);
}

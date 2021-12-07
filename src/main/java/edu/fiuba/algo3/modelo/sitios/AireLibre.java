package edu.fiuba.algo3.modelo.sitios;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.sitios.Sitio;

public class AireLibre implements Sitio {

    private Jugador jugador;

    public void asignarJugador(Jugador jugador) {
        this.jugador = jugador;
    }
}

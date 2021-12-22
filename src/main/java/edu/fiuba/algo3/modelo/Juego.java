package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.vista.OyenteEstadoPartida;

public class Juego {
    private Partida partida;

    public Juego() {
    }

    public void comenzarPartida(OyenteEstadoPartida oyenteEstadoPartida) {
        partida = new Partida(oyenteEstadoPartida);
        partida.empezar();
    }

    public Nivel nivelActual() {
        return partida.nivelActual();
    }

    public Partida partidaActual() { return partida;}
}

package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.vista.OyenteEstadoPartida;

import java.util.List;
import java.util.Observable;

public class Juego extends Observable {
    private Partida partida;

    public Juego() {
    }

    public void comenzarPartida(OyenteEstadoPartida oyenteEstadoPartida) {
        System.out.println("Juego: Comienza Partida");
        partida = new Partida(oyenteEstadoPartida);
        partida.empezar();
    }

    public Nivel nivelActual() {
        return partida.nivelActual();
    }

    public Partida partidaActual() { return partida;}
}

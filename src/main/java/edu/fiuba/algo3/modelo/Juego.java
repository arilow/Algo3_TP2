package edu.fiuba.algo3.modelo;

import java.util.List;

public class Juego {
    private Partida partida;

    public Juego() {
    }

    public void comenzarPartida() {
        System.out.println("Juego: Comienza Partida");
        partida = new Partida();
        partida.empezar();
    }
}

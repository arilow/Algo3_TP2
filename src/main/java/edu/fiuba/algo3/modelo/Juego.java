package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Observable;

public class Juego extends Observable {
    private Partida partida;

    public Juego() {
    }

    public void comenzarPartida() {
        System.out.println("Juego: Comienza Partida");
        partida = new Partida();
        partida.empezar();

        setChanged();
        notifyObservers();
    }

    public Nivel nivelActual() {
        return partida.nivelActual();
    }

    public Partida partidaActual() { return partida;}
}

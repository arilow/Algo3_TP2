package edu.fiuba.algo3.modelo;

import java.util.Observable;

public class ComunicadorEstadoPartida extends Observable {
    EstadoPartida estadoActual;

    public ComunicadorEstadoPartida(EstadoPartida estadoPartida) {
        estadoActual = estadoPartida;
    }

    public void definirEstado(EstadoPartida estadoPartida) {
        estadoActual = estadoPartida;
        setChanged();
        notifyObservers();
    }

    public EstadoPartida obtenerEstado() {
        return estadoActual;
    }
}

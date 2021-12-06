package edu.fiuba.algo3.modelo.sitios.edificios;

import edu.fiuba.algo3.modelo.Jugador;

public class Banco extends Edificio{

    private Jugador jugador;

    public Banco(String pista) {
        super(pista);
    }


    @Override
    public void asignarJugador(Jugador jugador) {
        this.jugador = jugador;
    }
}

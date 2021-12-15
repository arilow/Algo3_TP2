package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.objetos.ObjetoRobado;

import java.util.List;

public class Partida {
    private CreadorDeNiveles creadorDeNiveles;
    private Nivel nivelActual;
    private Jugador jugador;

    public Partida()
    {
        creadorDeNiveles = new CreadorDeNiveles();
    }

    public void empezar() {
        registrarJugador();
        crearNivel();
        comenzarNivel();
    }

    public void registrarJugador() {
        jugador = new Jugador("Buquitas Lurna");
    }

    public void crearNivel() {
        nivelActual = creadorDeNiveles.crearNivel(jugador);
    }

    public void comenzarNivel() {
        nivelActual.jugar();
    }

    public Nivel nivelActual() {
        return nivelActual;
    }
}


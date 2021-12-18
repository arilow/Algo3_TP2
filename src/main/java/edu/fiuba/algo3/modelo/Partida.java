package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.objetos.ObjetoRobado;
import edu.fiuba.algo3.vista.OyenteEstadoPartida;

import java.util.List;

public class Partida {
    private CreadorDeNiveles creadorDeNiveles;
    private Nivel nivelActual;
    private Jugador jugador;

    private ComunicadorEstadoPartida estado;

    public Partida(OyenteEstadoPartida oyenteEstadoPartida) {
        estado = new ComunicadorEstadoPartida(EstadoPartida.CREAR);
        estado.addObserver(oyenteEstadoPartida);

        creadorDeNiveles = new CreadorDeNiveles();
    }

    public void empezar() {
        estado.definirEstado(EstadoPartida.EMPEZAR);
    }

    public void registrarJugador(String nombre) {
        jugador = new Jugador(nombre);
        crearNivel();
        comenzarNivel();
    }

    public void crearNivel() {
        nivelActual = creadorDeNiveles.crearNivel(jugador);
    }

    public void comenzarNivel() {
        nivelActual.jugar(estado);
        estado.definirEstado(EstadoPartida.COMIENZA_NIVEL);
    }

    public Nivel nivelActual() {
        return nivelActual;
    }
}


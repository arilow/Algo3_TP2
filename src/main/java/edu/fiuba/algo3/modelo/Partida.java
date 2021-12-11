package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.objetos.ObjetoRobado;

import java.util.List;

public class Partida {
    /*
    private List<Ladron> ladrones;
    private List<Ciudad> ciudades;
    private List<ObjetoRobado> objetosRobados;

     */
    private CreadorDeNiveles creadorDeNiveles;
    private Nivel nivelActual;
    private Jugador jugador;

    public Partida()
    {
    /*
        this.ladrones = ladrones;
        this.ciudades = ciudades;
        this.objetosRobados = objetosRobados;
     */
        creadorDeNiveles = new CreadorDeNiveles();
    //    jugador = new Jugador("jugador");
    }

    public void empezar() {
        registrarJugador();
        crearNivel();
        comenzarNivel();
    }

    public void registrarJugador() {
        System.out.println("Paritda: Se registra jugador");

        jugador = new Jugador("Buquitas Lurna");
    }

    public void crearNivel() {
        System.out.println("Paritda: Se crea nivel");

        nivelActual = creadorDeNiveles.crearNivel(jugador);
    }

    public void comenzarNivel() {
        System.out.println("Paritda: Comienza nivel");
        nivelActual.jugar();
    }
}


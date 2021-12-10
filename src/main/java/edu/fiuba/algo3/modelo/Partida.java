package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.objetos.ObjetoRobado;

import java.util.List;

public class Partida {
    private List<Ladron> ladrones;
    private List<Ciudad> ciudades;
    private List<ObjetoRobado> objetosRobados;
    private CreadorDeNiveles creadorDeNiveles;
    private Nivel nivelActual;
    private Jugador jugador;

    public Partida(List<Ladron> ladrones, List<Ciudad> ciudades, List<ObjetoRobado> objetosRobados)
    {
        this.ladrones = ladrones;
        this.ciudades = ciudades;
        this.objetosRobados =objetosRobados;
        creadorDeNiveles = new CreadorDeNiveles();
        jugador = new Jugador("jugador");
    }

    public void crearNivel() {
        nivelActual = creadorDeNiveles.crearNivel(jugador);
    }

    public void empezarNivel() {
        nivelActual.jugar();
    }
}


package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.objetos.ObjetoRobado;

import java.util.List;

public class Partida {
    private List<Ladron> ladrones;
    private List<Ciudad> ciudades;
    private List<ObjetoRobado> objetosRobados;

    public Partida(List<Ladron> ladrones, List<Ciudad> ciudades, List<ObjetoRobado> objetosRobados)
    {
        this.ladrones= ladrones;
        this.ciudades= ciudades;
        this.objetosRobados=objetosRobados;
    }
}


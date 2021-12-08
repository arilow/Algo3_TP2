package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.objetos.ObjetoRobado;

import java.util.List;

public class Partida {
    private List<Ladron> lardones;
    private List<Ciudad> ciudades;
    private List<ObjetoRobado> objetosRobados;

    public Partida(List<Ladron> ladrones, List<Ciudad> ciudades, List<ObjetoRobado> objetosRobados)
    {
        this.lardones= ladrones;
        this.ciudades= ciudades;
        this.objetosRobados=objetosRobados;
    }
}


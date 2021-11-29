package edu.fiuba.algo3.modelo;

import java.util.List;

public class Juego {
    protected final List<String> datosDeCiudades;
    protected final List<String> datosDeLadrones;

    public Juego(List<String> datosDeCiudades, List<String> datosDeLadrones) {
        this.datosDeCiudades = datosDeCiudades;
        this.datosDeLadrones = datosDeLadrones;
    }
}

package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.cargos.Cargo;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;

public class Jugador {
    private final String nombre;
    private Cargo cargo;
    private Ciudad ciudadActual;

    public Jugador(String nombre, Cargo cargo, Ciudad ciudadActual) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.ciudadActual = ciudadActual;
    }
}

package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.cargos.Cargo;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;

public class Jugador {
    private final String nombre;
    private Cargo cargo;

    public Jugador(String nombre, Cargo cargo) {
        this.nombre = nombre;
        this.cargo = cargo;
    }
}

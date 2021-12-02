package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.cargos.Cargo;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;

public class Jugador {
    private final String nombre;
    private Cargo cargo;
    private boolean fueAcuchillado = false;

    public Jugador(String nombre, Cargo cargo) {
        this.nombre = nombre;
        this.cargo = cargo;
    }
    public void recibirHeridaCuchillo(Tiempo tiempo) {
        int cantidadHoras = this.fueAcuchillado ? 1 : 2;
        tiempo.sumarHoras(cantidadHoras);
        this.fueAcuchillado = true; // Cuando fue aculliado una vez ya suma siempre 1 hs
    }
    public void recibirHeridaArmaFuego(Tiempo tiempo) {
        tiempo.sumarHoras(4);
    }
    public void dormir(Tiempo tiempo) {
        tiempo.sumarHoras(8);
    }

    public void viajar(float distancia, Tiempo tiempo) {
        cargo.viajar(distancia, tiempo);
    }
}

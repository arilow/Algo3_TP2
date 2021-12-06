package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.cargos.*;
import edu.fiuba.algo3.modelo.sitios.Sitio;
import edu.fiuba.algo3.modelo.sitios.edificios.AireLibre;
import edu.fiuba.algo3.modelo.sitios.edificios.Edificio;

public class Jugador {

    private final String nombre;
    private Cargo cargo;
    public int cantidadArrestos = 0;
    private boolean fueAcuchillado = false;
    private Sitio edificioActual;

    public Jugador(String nombre) {
        this.nombre = nombre;
        asignarCargo(new Novato());
        asignarEdificioActual(new AireLibre());
    }

    public void asignarCargo(Cargo cargo) {
        this.cargo = cargo;
        this.cargo.asignarJugador(this);
    }

    public void asignarEdificioActual(Sitio edificio){
        this.edificioActual = edificio;
        this.edificioActual.asignarJugador(this);
;    }

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

    public void agregarArresto (){
        this.cargo.agregarArresto();
    }

    public void setCantidadArrestos(int cantidadArrestos) {
        this.cantidadArrestos = cantidadArrestos;
    }
    public int getCantidadArrestos() { return this.cantidadArrestos; }

    public Cargo getCargo() {
        return this.cargo;
    }
}

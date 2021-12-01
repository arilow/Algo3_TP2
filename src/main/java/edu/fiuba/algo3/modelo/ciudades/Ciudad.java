package edu.fiuba.algo3.modelo.ciudades;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.edificios.*;

import java.util.List;

public class Ciudad {

    String nombre;
    List<Edificio> edificios;
    Edificio edificioActual;

    protected void recibirJugador(Jugador jugador) {
        /* TODO */
    }

    public Ciudad(){
    }
    public Ciudad(List<Edificio> edificios){
        this.edificios = edificios;
    }
    public void entrarAEdificio(Edificio edificio){
        edificio.mostrarPista();
        this.edificioActual = edificio;
    }

    public boolean equals(Ciudad c) {
        return this.nombre == c.nombre;
    }
}

package edu.fiuba.algo3.modelo.ciudades;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pista;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.edificios.*;

import java.util.ArrayList;
import java.util.List;

public class Ciudad {

    String nombre;

    List<Edificio> edificios;
    
    // Edificio edificioActual;

    protected void recibirJugador(Jugador jugador) {
        /* TODO */
    }

    public Ciudad(String nombre, List<Edificio> edificios){
        this.nombre = nombre;
        this.edificios = edificios;
    }

    public boolean es(String nombre) {
        return this.nombre.equals(nombre);
    }

    public Pista entrarAEdificio(int edificio, Tiempo tiempo) {
        edificios.get(edificio).aumentarTiempo(tiempo);
        return edificios.get(edificio).mostrarPista();
    }

    public float obtenerDistancia(Ciudad otra) {
        return 2000;
    }

    public boolean equals(Ciudad c) {
        return this.nombre == c.nombre;
    }
}

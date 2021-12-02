package edu.fiuba.algo3.modelo.ciudades;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.edificios.*;

import java.util.ArrayList;
import java.util.List;

public class Ciudad {

    String nombre;

    List<Edificio> edificios = new ArrayList<Edificio>();
    
    // Edificio edificioActual;

    protected void recibirJugador(Jugador jugador) {
        /* TODO */
    }

    public Ciudad(List<Edificio> edificios){
        this.edificios = edificios;
    }

    public void entrarAEdificio(int edificio, Tiempo tiempo) {
        edificios.get(edificio).aumentarTiempo(tiempo);
        edificios.get(edificio).mostrarPista();
    }

    public float obtenerDistancia(Ciudad otra) {
        return 2000;
    }
}

package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.sitios.AireLibre;
import edu.fiuba.algo3.modelo.sitios.Sitio;
import edu.fiuba.algo3.modelo.sitios.edificios.Edificio;

import java.util.List;

public class Ciudad {
    String nombre;
    List<Edificio> edificios;
    Sitio sitioActual;
    // Representa el espacio fuera de los edificios de la ciudad
    Sitio aireLibre;

    protected void recibirJugador(Jugador jugador) {
        /* TODO */
    }

    public Ciudad(String nombre, List<Edificio> edificio) {
        this.nombre = nombre;
        this.edificios = edificio;
        this.aireLibre = new AireLibre();
        this.sitioActual = aireLibre;
    }

    public boolean es(String nombre) {
        return this.nombre.equals(nombre);
    }

    public Pista entrarAEdificio(int edificio, Tiempo tiempo) {
        this.sitioActual = edificios.get(edificio);
        edificios.get(edificio).aumentarTiempo(tiempo);
        return edificios.get(edificio).mostrarPista();
    }

    public void salirDeEdificio() {
        this.sitioActual = aireLibre;
    }

    public float obtenerDistancia(Ciudad otra) {
        return 2000;
    }

    public boolean equals(Ciudad c) {
        return this.nombre == c.nombre;
    }
}

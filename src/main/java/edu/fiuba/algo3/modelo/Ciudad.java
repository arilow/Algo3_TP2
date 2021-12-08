package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.sitios.AireLibre;
import edu.fiuba.algo3.modelo.sitios.Sitio;
import edu.fiuba.algo3.modelo.sitios.edificios.Edificio;

import java.util.List;

public class Ciudad {
    private String nombre;
    private List<Edificio> edificios;
    private Sitio sitioActual;
    // Representa el espacio fuera de los edificios de la ciudad
    private Sitio aireLibre;
    private Ubicacion ubicacion;

    protected void recibirJugador(Jugador jugador) {
        /* TODO */
    }

    public Ciudad(String nombre, List<Edificio> edificio) {
        this.nombre = nombre;
        this.edificios = edificio;
        this.aireLibre = new AireLibre();
        this.sitioActual = aireLibre;
    }

    public Ciudad(String nombre, List<Edificio> edificio, Ubicacion ubicacion) {
        this.nombre = nombre;
        this.edificios = edificio;
        this.aireLibre = new AireLibre();
        this.sitioActual = aireLibre;
        this.ubicacion = ubicacion;
    }

    /*public boolean es(String nombre) {
        return this.nombre.equals(nombre);
    }*/

    public Pista entrarAEdificio(int edificio, Tiempo tiempo) {
        this.sitioActual = edificios.get(edificio);
        edificios.get(edificio).aumentarTiempo(tiempo);
        return edificios.get(edificio).mostrarPista();
    }

    public Ubicacion obtenerUbicacion(){ return ubicacion; }

    public void salirDeEdificio() {
        this.sitioActual = aireLibre;
    }

    public double obtenerDistancia(Ciudad otraCiudad) {
        return this.ubicacion.calcularDistancia(otraCiudad.obtenerUbicacion());
    }
}

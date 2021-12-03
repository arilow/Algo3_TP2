package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.edificios.Edificio;

import java.util.List;

public class Nivel {
//    private List<Ciudad> ciudades;
    private Ciudad ciudadActual;
    private Tiempo tiempo;
    private Jugador jugador;

    public Nivel(Ciudad ciudad, Jugador jugador){
        ciudadActual = ciudad;
        tiempo = new Tiempo(10);
        this.jugador = jugador;
    }

    // Chequear que la ciudad se encuentre en el nivel y
    // aca habria que descontar el tiempo de viaje.

    public void visitarCiudad(Ciudad ciudad){
        float distancia = ciudadActual.obtenerDistancia(ciudad);

        jugador.viajar(distancia, tiempo);
        ciudadActual = ciudad;
    }

    public void entrarAEdificio(int edificio){
        ciudadActual.entrarAEdificio(edificio, tiempo);
    }
    public boolean estaEnCiudad(Ciudad ciudad) {
        return this.ciudadActual == ciudad;
    }
}

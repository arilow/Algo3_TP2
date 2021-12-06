package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.objetos.ObjetoRobado;

import java.util.List;

public class Nivel {
    private List<Ciudad> ciudades;
    private Ladron ladron;
    private ObjetoRobado tesoro;
    private Ciudad ciudadActual;
    private Tiempo tiempo;
    private Jugador jugador;

    public Nivel(Ciudad ciudad, Jugador jugador, ObjetoRobado tesoro, Ladron ladron, List<Ciudad> ciudades){
        tiempo = new Tiempo(10);
        ciudadActual = ciudad;
        this.jugador = jugador;
        this.tesoro = tesoro;
        this.ladron = ladron;
    }

    // Chequear que la ciudad se encuentre en el nivel y
    // aca habria que descontar el tiempo de viaje.

    public void visitarCiudad(Ciudad ciudad){
        float distancia = ciudadActual.obtenerDistancia(ciudad);

        jugador.viajar(distancia, tiempo);
        ciudadActual = ciudad;
    }

    //TODO edificio no es un int
    public void entrarAEdificio(int edificio){
        ciudadActual.entrarAEdificio(edificio, tiempo);
    }

    //TODO reemplazar por fecha
    public int obtenerTiempo() {
        return tiempo.obtenerHorasPasadas();
    }

    public boolean tieneTesoro(String tesoro) {
        return this.tesoro.es(tesoro);
    }

    public boolean constatarDatosLadron(DatosLadron datos) {
        return ladron.constatarDatos(datos);
    }

    public boolean estaEn(String ciudad) {
        return ciudadActual.es(ciudad);
    }
}

package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.sitios.edificios.Edificio;

import java.util.List;
import java.util.Map;

public class Mapa {
    Map<String, Ciudad> mapeo_aux;
    private List<Ciudad> ciudades;

    public Mapa(List <Ciudad> ciudadesMapa) {
        for(Ciudad ciudad: ciudades) {
            mapeo_aux.put(ciudad.toString(), ciudad);
        }
        this.ciudades=ciudadesMapa;
    }

    public void viajar(Jugador jugador,Ciudad ciudadPartida, String ciudadLLlegada, Tiempo tiempo) {
            jugador.viajar(ciudadPartida.obtenerDistancia(mapeo_aux.get(ciudadLLlegada)), tiempo);
    }

}

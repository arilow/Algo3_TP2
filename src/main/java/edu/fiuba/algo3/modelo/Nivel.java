package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.edificios.Edificio;

import java.util.List;

public class Nivel {
    private List<Ciudad> ciudades;
    private Ciudad ciudadActual;

    public Nivel(List<Ciudad> ciudades){
        this.ciudades = ciudades;
    }
    public Nivel(List<Ciudad> ciudades, Ciudad ciudadInicial){
        this.ciudades = ciudades;
        this.ciudadActual = ciudadInicial;
    }
    // Chequear que la ciudad se encuentre en el nivel y
    // aca habria que descontar el tiempo de viaje.
    public void visitarCiudad(Ciudad ciudad){
        this.ciudadActual = ciudad;
    }
    public void entrarAEdificio(Edificio edificio){
        ciudadActual.entrarAEdificio(edificio);
    }
    public boolean estaEnCiudad(Ciudad ciudad) {
        return this.ciudadActual == ciudad;
    }
}

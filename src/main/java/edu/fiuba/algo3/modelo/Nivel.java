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
    public void visitarCiudad(Ciudad ciudad){
        this.ciudadActual = ciudad;
    }
    public void entrarAEdificio(Edificio edificio){
        ciudadActual.entrarAEdificio(edificio);
    }
}

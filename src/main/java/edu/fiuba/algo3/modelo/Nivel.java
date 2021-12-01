package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.edificios.Edificio;

import java.util.List;

public class Nivel {
//    private List<Ciudad> ciudades;
    private Ciudad ciudadActual;
    private Tiempo tiempo;

    public Nivel(Ciudad ciudad){
        ciudadActual = ciudad;
        tiempo = new Tiempo(10);
    }
  /*  public void visitarCiudad(Ciudad ciudad){
        this.ciudadActual = ciudad;
    }

   */

    public void entrarAEdificio(int edificio){
        ciudadActual.entrarAEdificio(edificio, tiempo);
    }
}

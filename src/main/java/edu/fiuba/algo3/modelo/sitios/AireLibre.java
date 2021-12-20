package edu.fiuba.algo3.modelo.sitios;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pista;
import edu.fiuba.algo3.modelo.sitios.Sitio;

import java.util.Observable;

public class AireLibre extends Observable implements Sitio {
    public String mostrarInfo() {
        return "AireLibre";
    }
}

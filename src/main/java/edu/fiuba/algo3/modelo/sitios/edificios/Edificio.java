package edu.fiuba.algo3.modelo.sitios.edificios;

import edu.fiuba.algo3.modelo.Pista;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.sitios.Sitio;

import java.util.Observable;

public abstract class Edificio extends Observable implements Sitio {
    protected String nombre;
    private Pista pista;
    private int contadorDeEntradas;

    public Edificio(String pista, String nombre) {
        this.pista = new Pista(pista);
        this.nombre = nombre;
        contadorDeEntradas = 0;
    }

    public void aumentarTiempo(Tiempo tiempo) {
        int horasPorSumar;
        contadorDeEntradas++;
        if(contadorDeEntradas <= 3)
            horasPorSumar = contadorDeEntradas;
        else
            horasPorSumar = 3;
        tiempo.sumarHoras(horasPorSumar);
    }

    public Pista mostrarPista() {
        setChanged();
        notifyObservers(pista);
        return pista;
    }
    public String mostrarInfo() {
        return "Edificio";
    }

    public String nombre() {
        return nombre;
    }
}

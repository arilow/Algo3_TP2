package edu.fiuba.algo3.modelo.sitios.edificios;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pista;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.sitios.Sitio;

import java.util.Observable;

public abstract class Edificio extends Observable implements Sitio {

    private Pista pista;
    private int contadorDeEntradas;
    private boolean tieneLadron;

    public Edificio(String pista) {
        this.pista = new Pista(pista);
        contadorDeEntradas = 0;
        tieneLadron = false;
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

    public void asignarLadron(){
        this.tieneLadron = true;
    }

    public boolean tieneLadron() {
        return tieneLadron;
    }

    public Pista mostrarPista() {
        setChanged();
        notifyObservers(pista);
        return pista;
    }
}

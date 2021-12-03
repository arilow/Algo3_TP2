package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.Pista;
import edu.fiuba.algo3.modelo.Tiempo;

public class Edificio {

    private Pista pista;
    int contadorDeEntradas;

    public Edificio(String pista) {
        this.pista = new Pista(pista);
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
        return pista;
    }
}

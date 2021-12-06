package edu.fiuba.algo3.modelo.sitios.edificios;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pista;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.sitios.Sitio;

abstract class Edificio implements Sitio {

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

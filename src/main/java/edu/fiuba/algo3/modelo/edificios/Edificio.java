package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.Tiempo;

public class Edificio {

    private String pista;
    int contadorDeEntradas;

    public Edificio(String pista) {
        this.pista = pista;
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

    public void mostrarPista() {
        System.out.println(pista);
    }
}

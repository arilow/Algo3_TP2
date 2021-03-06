package edu.fiuba.algo3.modelo;

import java.util.Observable;

public class Tiempo extends Observable {
    private int horas;
    private int horasFin;


    public Tiempo(int fin) {
        this.horas = 0;
        this.horasFin = fin;
    }

    public void sumarHoras(int horasSumadas) {
        horas += horasSumadas;

        if(horas >= horasFin) {
            setChanged();
            notifyObservers();
        }
    }
    public int obtenerHorasPasadas() {
        return horas;
    }
}
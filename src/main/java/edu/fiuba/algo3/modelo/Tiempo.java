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
            // throw exception
            // setChanged();
            // notifyObservers();
        }
        System.out.println("La hora es: " + aString());
        setChanged();
        notifyObservers(this);
    }

    public int obtenerHorasPasadas() {
        return horas;
    }

    public String aString(){
        //traducir el tiempo a dia y hora todas arrancan Lunes 7am
        String[] diasDeLaSemana = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};

        int tiempoEnHoras = (horas + 7) % 24;
        String dia  = diasDeLaSemana[(horas+7)/24];
        String fecha = String.format("%d",tiempoEnHoras) + "hs, " + dia + ".";

        return fecha;
    }
}
package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.time.LocalDateTime;


public class Tiempo extends Observable {
    private int horas;
    private int horasFin;
    private int dia;
    private int diaFin;

    public Tiempo() {
        this.horas = 7; /* Arranca a las 7 AM */
        this.dia = 0; /* Lunes */
        this.horasFin = 17 /* Termina a las 5 de la tarde */;
        this.diaFin = 6; /* Domingo */
    }

    public String aString(){
        String[] diasDeLaSemana = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};

        int tiempoEnHoras = horas;
        String strDia  = diasDeLaSemana[dia];
        return String.format("%d",tiempoEnHoras) + "hs, " + strDia + ".";
    }

    public void sumarHoras(int horasSumadas) {
        horas += horasSumadas;

        // Si son las 10 de la noche, sumar 9 horas.
        if (horas >= 22) {
            horas = (horas + 9) % 24;
            dia = (dia + 1) % 7;
        }

        if(horas >= horasFin && dia >= diaFin) {
            // throw exception
            // setChanged();
            // notifyObservers();
        }

        System.out.println("La hora es: " + aString());
        setChanged();
        notifyObservers(this);
    }

    public int obtenerHorasPasadas() {
        return horas - 7 + dia * 24;
    }

}
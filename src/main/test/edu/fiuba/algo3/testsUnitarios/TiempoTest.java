package edu.fiuba.algo3.testsUnitarios;


import edu.fiuba.algo3.modelo.Tiempo;
import org.junit.jupiter.api.Test;

import java.util.Observable;
import java.util.Observer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TiempoTest {

    private class ObservadorDeTiempo implements Observer {
        private int contadorDeUpdates = 0;
        @Override
        public void update(Observable o, Object arg) {
            contadorDeUpdates++;
            System.out.println("Fin");
        }
        public int obtenerContadorDeUpdates() {
            return contadorDeUpdates;
        }
    }

    @Test
    public void test01TiempoSeAgregaUnaHora() {
        Tiempo tiempo = new Tiempo(10);

        tiempo.sumarHoras(1);

        assertEquals(1, tiempo.obtenerHorasPasadas());
    }

    @Test
    public void test02TiempoSeTermina() {
        ObservadorDeTiempo observadorDeTiempo = new ObservadorDeTiempo();
        Tiempo tiempo = new Tiempo(10);
        tiempo.addObserver(observadorDeTiempo);

        tiempo.sumarHoras(10);

        assertEquals(1, observadorDeTiempo.obtenerContadorDeUpdates());
    }

    @Test
    public void test03Las25HorasCorrespondenAlMartesALas8hs() {

        Tiempo tiempo = new Tiempo(45);
        tiempo.sumarHoras(25);
        String tiempoString = tiempo.aString();

        assertEquals(tiempoString,"8hs, Martes.");
    }

    @Test
    public void test04Las50HorasCorrespondenAlMiercolesALas9hs() {

        Tiempo tiempo = new Tiempo(60);
        tiempo.sumarHoras(50);
        String tiempoString = tiempo.aString();

        assertEquals(tiempoString,"9hs, Miercoles.");
    }

    @Test
    public void test05Las100HorasCorrespondenAlViernesALas11hs() {

        Tiempo tiempo = new Tiempo(120);
        tiempo.sumarHoras(100);
        String tiempoString = tiempo.aString();

        assertEquals(tiempoString,"11hs, Viernes.");
    }

    @Test
    public void test06Las150HorasCorrespondenAlDomingoALas13hs() {

        Tiempo tiempo = new Tiempo(178);
        tiempo.sumarHoras(150);
        String tiempoString = tiempo.aString();

        assertEquals(tiempoString,"13hs, Domingo.");
    }
}

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
}

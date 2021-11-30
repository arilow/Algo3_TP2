package edu.fiuba.algo3.testsUnitarios;


import edu.fiuba.algo3.modelo.Tiempo;
import org.junit.jupiter.api.Test;

import java.util.Observable;
import java.util.Observer;

public class TiempoTest {

    private class ObservadorDeTiempo implements Observer {
        @Override
        public void update(Observable o, Object arg) {
            System.out.println("Fin");
        }
    }

    @Test
    public void test01TiempoSeAgregaUnaHora() {

    }

    @Test
    public void test02TiempoSeTermina() {
        Tiempo tiempo = new Tiempo(10);
        tiempo.addObserver(new ObservadorDeTiempo());

        tiempo.SumarHoras(10);
    }
}

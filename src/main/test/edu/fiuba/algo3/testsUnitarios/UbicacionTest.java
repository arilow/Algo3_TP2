package edu.fiuba.algo3.testsUnitarios;

import edu.fiuba.algo3.modelo.Ubicacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UbicacionTest {

    @Test
    public void test01CalcularDistanciaEntreMontrealYMexico() {
        double distanciaEsperada = 3729;

        Ubicacion uMontreal = new Ubicacion(-73.57543945312501, 45.49864682342613);
        Ubicacion uMexico = new Ubicacion(-99.15161132812501, 19.425153718960143);

        double distancia = uMexico.calcularDistancia(uMontreal);

        assertEquals(distanciaEsperada, distancia, 1);
    }
}

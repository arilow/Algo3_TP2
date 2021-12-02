package edu.fiuba.algo3.testsUnitarios;

import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.cargos.Novato;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {

    private String nombre = "Mateo";
    private Novato novato;

    @Test
    public void test01JugadorRecibeHeridaDeCuchilloPorPrimeraVez() {
        Tiempo tiempo = new Tiempo(10);
        Jugador jugador = new Jugador(nombre, novato);
        jugador.recibirHeridaCuchillo(tiempo);

        assertEquals(2, tiempo.obtenerHorasPasadas());
    }

    @Test
    public void test02JugadorRecibeHeridaDeCuchilloPorSegundaVez() {
        Tiempo tiempo = new Tiempo(10);
        Jugador jugador = new Jugador(nombre, novato);

        jugador.recibirHeridaCuchillo(tiempo);
        jugador.recibirHeridaCuchillo(tiempo);

        assertEquals(3, tiempo.obtenerHorasPasadas());
    }

    @Test
    public void test03JugadorDuerme() {
        Tiempo tiempo = new Tiempo(10);
        Jugador jugador = new Jugador(nombre, novato);

        jugador.dormir(tiempo);

        assertEquals(8, tiempo.obtenerHorasPasadas());
    }
}

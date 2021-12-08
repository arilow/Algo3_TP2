package edu.fiuba.algo3.testsEntregas;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.cargos.Cargo;
import edu.fiuba.algo3.modelo.cargos.Investigador;
import edu.fiuba.algo3.modelo.cargos.Novato;
import edu.fiuba.algo3.modelo.sitios.edificios.Banco;
import edu.fiuba.algo3.modelo.sitios.edificios.Edificio;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntregaDosTest {

    @Test
    public void test01JugadorConCargoInvestigadorViajaDeMontrealAMexico() {
        int horasPasadasEsperadas = 3;

        Cargo investigador = new Investigador();
        Jugador jugador = new Jugador("Mateo");
        jugador.asignarCargo(investigador);

        Ubicacion uMontreal = new Ubicacion(-73.575439, 45.498646);
        Ubicacion uMexico = new Ubicacion(-99.228515, 19.394067);
        Ciudad montreal = new Ciudad("Montreal", null, uMontreal);
        Ciudad mexico = new Ciudad("México", null, uMexico);

        List<Ciudad> ciudades = new ArrayList<Ciudad>();
        ciudades.add(montreal);
        ciudades.add(mexico);

        Nivel nivel = new Nivel(montreal, jugador, null, null, ciudades);

        assertEquals(nivel.obtenerCiudadActual(), montreal);
        nivel.visitarCiudad(mexico);
        assertEquals(horasPasadasEsperadas, nivel.obtenerTiempo());
        assertEquals(nivel.obtenerCiudadActual(), mexico);
    }
}

package edu.fiuba.algo3.testsUnitarios;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.CreadorDeNiveles;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Nivel;
import edu.fiuba.algo3.modelo.Ladron;
import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.cargos.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CreadorDeNivelTest {
    @Test
    public void test01CargarUnNivelConElCreadorDeNiveles() {
        CreadorDeNiveles creadorDeNiveles = new CreadorDeNiveles();
        Jugador jugador = new Jugador("Ariel");

        Nivel nivel = creadorDeNiveles.crearNivel(jugador);

        Ladron ladron = nivel.obtenerLadron();
        String nombreLadron = ladron.obtenerNombre();
        assertEquals("Fast Eddie B.", nombreLadron);

        Ciudad ciudad = nivel.obtenerCiudadActual();
        assertTrue(ciudad.es("pekin"));

        List<Ciudad> ciudades = nivel.listarCiudades();
        for(Ciudad c : ciudades) {
            System.out.print(c.obtenerNombre() + " - ");
        }

        assertTrue(nivel.tieneTesoro("Huevo de 1000 anios"));
    }

    @Test
    public void test01CargarUnNivelConElCreadorDeNivelesParaUnDetective() {
        CreadorDeNiveles creadorDeNiveles = new CreadorDeNiveles();
        Jugador jugador = new Jugador("Ariel");
        Cargo cargo = new Detective();
        jugador.asignarCargo(cargo);

        Nivel nivel = creadorDeNiveles.crearNivel(jugador);

        Ladron ladron = nivel.obtenerLadron();
        String nombreLadron = ladron.obtenerNombre();
        assertEquals("Fast Eddie B.", nombreLadron);

        Ciudad ciudad = nivel.obtenerCiudadActual();
        assertTrue(ciudad.es("pekin"));

        assertTrue(nivel.tieneTesoro("Huevo de 1000 anios"));
    }
}

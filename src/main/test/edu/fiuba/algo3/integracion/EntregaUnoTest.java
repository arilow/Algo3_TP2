package edu.fiuba.algo3.integracion;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Ladron;
import edu.fiuba.algo3.modelo.Nivel;
import edu.fiuba.algo3.modelo.cargos.Cargo;
import edu.fiuba.algo3.modelo.cargos.Novato;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.edificios.Banco;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.objetos.ObjetoComun;
import edu.fiuba.algo3.modelo.objetos.ObjetoRobado;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EntregaUnoTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }


    @Test
    public void casoDeUsoUno() {
        ObjetoComun tesoroNacional = new ObjetoComun();
        Ladron ladron = new Ladron("femenino","","","","");
        Cargo cargo = new Novato();
        Jugador jugador = new Jugador("Mateo", cargo);

        Edificio banco = new Banco("Soy una Pista de un banco.");
        List<Edificio> edificios = new ArrayList<Edificio>();
        edificios.add(banco);

        Ciudad montreal = new Ciudad(edificios);
        List<Ciudad> ciudades = new ArrayList<Ciudad>();
        ciudades.add(montreal);

        Nivel nivel = new Nivel(ciudades);
        nivel.visitarCiudad(montreal);
        nivel.entrarAEdificio(banco);

        assertEquals("Soy una Pista de un banco.", outputStreamCaptor.toString().trim());
    }

    @Test
    public void casoDeUsoTres() {
        List<Ciudad> ciudades = new ArrayList<Ciudad>();
        Ciudad montreal = new Ciudad();
        ciudades.add(montreal);
        Ciudad mexico = new Ciudad();
        ciudades.add(mexico);

        Cargo cargo = new Novato();  // Supongo que el jugador tiene un cargo de novato
        Jugador jugador = new Jugador("Mateo", cargo);

        Nivel nivel = new Nivel(ciudades, montreal);
        nivel.visitarCiudad(mexico);

        assertTrue(nivel.estaEnCiudad(mexico));
    }
}

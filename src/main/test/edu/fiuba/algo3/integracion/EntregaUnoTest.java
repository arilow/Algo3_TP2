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

public class EntregaUnoTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private int indice_banco;
    private int indice_biblioteca;

    @BeforeEach
    public void setUp() {
        indice_banco = 0;
        indice_biblioteca = 1;

        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void test01() {
        ObjetoComun tesoroNacional = new ObjetoComun();
        Ladron ladron = new Ladron("femenino","","","","");
        Cargo cargo = new Novato();
        Jugador jugador = new Jugador("Mateo", cargo);

        Edificio banco = new Banco("Soy una Pista de un banco.");
        List<Edificio> edificios = new ArrayList<Edificio>();
        edificios.add(banco);

        Ciudad montreal = new Ciudad(edificios);

        Nivel nivel = new Nivel(montreal, jugador);
        nivel.entrarAEdificio(0);

        assertEquals("Soy una Pista de un banco.", outputStreamCaptor.toString().trim());
    }
}

package edu.fiuba.algo3.testsUnitarios;

import edu.fiuba.algo3.modelo.DatosLadron;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Ladron;
import edu.fiuba.algo3.modelo.Nivel;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.edificios.Aeropuerto;
import edu.fiuba.algo3.modelo.edificios.Banco;
import edu.fiuba.algo3.modelo.edificios.Biblioteca;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.objetos.ObjetoComun;
import edu.fiuba.algo3.modelo.objetos.ObjetoRobado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class NivelTest {
    private PartidaMock partidaMock;

    private class PartidaMock {
        Jugador jugador;
        public PartidaMock() {
            jugador = new Jugador("mock");
        }
        public Nivel GenerarNivel() {
            ObjetoRobado tesoroNacionalDeMontreal = new ObjetoComun("Tesoro Nacional de Montreal");
            Ladron ladrona = new Ladron("femenino","","","","");
            List<Edificio> listaEdificios= new ArrayList<Edificio>();

            listaEdificios.add(new Banco("Pista Banco"));
            listaEdificios.add(new Biblioteca("Pista Biblioteca"));
            listaEdificios.add(new Aeropuerto("Pista Aeropuerto"));

            Ciudad montreal = new Ciudad("Montreal", listaEdificios);

            return new Nivel(montreal, jugador, tesoroNacionalDeMontreal, ladrona, null);
        }
    }

    @BeforeEach
    public void setUp() {
        partidaMock = new PartidaMock();
    }

    @Test
    public void test01TesoroNacionalDeMontrealEsRobadoPorSospechosoFemeninoYPoliciaNovatoEntraAUnBanco() {
        Nivel nivel = partidaMock.GenerarNivel();

        assertTrue(nivel.tieneTesoro("Tesoro Nacional de Montreal"));
        assertTrue(nivel.constatarDatosLadron(new DatosLadron("femenino","","","","")));
        assertTrue(nivel.estaEn("Montreal"));

        nivel.entrarAEdificio(0);
        //TODO: Corroborar que baja el tiempo.
    }
}

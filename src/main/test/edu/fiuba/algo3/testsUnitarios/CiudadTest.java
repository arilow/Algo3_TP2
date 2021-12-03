package edu.fiuba.algo3.testsUnitarios;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.cargos.Cargo;
import edu.fiuba.algo3.modelo.cargos.Novato;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.edificios.Aeropuerto;
import edu.fiuba.algo3.modelo.edificios.Banco;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.Puerto;
import edu.fiuba.algo3.modelo.objetos.ObjetoRobado;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CiudadTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private int indice_banco;
    private int indice_biblioteca;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        indice_banco = 0;
        indice_biblioteca = 1;
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    //Caso de uso 01
    @Test
    public void test01SeEntraABancoYSeImprimePista() {
        Tiempo tiempo = new Tiempo(10);
        Edificio banco = new Banco("Soy una Pista de un banco.");
        List<Edificio> edificios = new ArrayList<Edificio>();
        edificios.add(banco);

        Ciudad montreal = new Ciudad("Montreal", edificios);

        Pista pista = montreal.entrarAEdificio(0, tiempo);
        assertEquals("Soy una Pista de un banco.", pista.mostrar());
    }

    @Test
    public void test02SeEntraABancoPorPrimeraVezYTiempoAumentarEnUno() {
        int horas_pasadas_esperadas = 1;

        Tiempo tiempo = new Tiempo(10);
        Edificio banco = new Banco("Soy una Pista de un banco.");
        List<Edificio> edificios = new ArrayList<Edificio>();
        edificios.add(banco);

        Ciudad montreal = new Ciudad("Montreal", edificios);

        montreal.entrarAEdificio(indice_banco, tiempo);
        assertEquals(horas_pasadas_esperadas, tiempo.obtenerHorasPasadas());
    }

    //Caso de uso 02
    @Test
    public void test03SeEntraABancoPorPrimeraVezYLuegoUnaBibliotecaYSeImprimenPistas() {
        Tiempo tiempo = new Tiempo(10);
        Edificio banco = new Banco("Soy una Pista de un banco.");
        Edificio biblioteca = new Banco("Soy una Pista de una biblioteca.");
        List<Edificio> edificios = new ArrayList<>();
        edificios.add(banco);
        edificios.add(biblioteca);

        Ciudad montreal = new Ciudad("Montreal", edificios);

        Pista pista1 = montreal.entrarAEdificio(indice_banco, tiempo);
        Pista pista2 = montreal.entrarAEdificio(indice_biblioteca, tiempo);

        assertEquals("Soy una Pista de un banco.", pista1.mostrar());
        assertEquals("Soy una Pista de una biblioteca.", pista2.mostrar());
    }

    //Caso de uso 03
    @Test
    public void test04DetectiveNovatoViajaDeMontrealAMexico() {
        int horas_pasadas_esperadas = 11;

        Tiempo tiempo = new Tiempo(10);
        Cargo novato = new Novato();
        Ciudad montreal = new Ciudad("Montreal", null);
        Ciudad mexico = new Ciudad("México", null);
        Jugador jugador = new Jugador("Mateo");

        List<Ciudad> ciudades = new ArrayList<Ciudad>();
        ciudades.add(montreal);
        ciudades.add(mexico);

        Nivel nivel = new Nivel(montreal, jugador, null, null, ciudades);

        jugador.asignarCargo(novato);
        jugador.viajar(10000, tiempo);

        assertEquals(horas_pasadas_esperadas, tiempo.obtenerHorasPasadas());
    }

}

package edu.fiuba.algo3.testsUnitarios;

import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.edificios.Banco;
import edu.fiuba.algo3.modelo.edificios.Edificio;
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

    @Test
    public void test01SeEntraABancoYSeImprimePista() {
        Tiempo tiempo = new Tiempo(10);
        Edificio banco = new Banco("Soy una Pista de un banco.");
        List<Edificio> edificios = new ArrayList<Edificio>();
        edificios.add(banco);

        Ciudad montreal = new Ciudad(edificios);

        montreal.entrarAEdificio(0, tiempo);
        assertEquals("Soy una Pista de un banco.", outputStreamCaptor.toString().trim());
    }

    @Test
    public void test02SeEntraABancoPorPrimeraVezYTiempoAumentarEnUno() {
        int horas_pasadas_esperadas = 1;

        Tiempo tiempo = new Tiempo(10);
        Edificio banco = new Banco("Soy una Pista de un banco.");
        List<Edificio> edificios = new ArrayList<Edificio>();
        edificios.add(banco);

        Ciudad montreal = new Ciudad(edificios);

        montreal.entrarAEdificio(indice_banco, tiempo);
        assertEquals(horas_pasadas_esperadas, tiempo.obtenerHorasPasadas());
    }

    @Test
    public void test03SeEntraABancoPorPrimeraVezYLuegoUnaBibliotecaYSeImprimenPistas() {
        Tiempo tiempo = new Tiempo(10);
        Edificio banco = new Banco("Soy una Pista de un banco.");
        Edificio biblioteca = new Banco("Soy una Pista de una biblioteca.");
        List<Edificio> edificios = new ArrayList<Edificio>();
        edificios.add(banco);
        edificios.add(biblioteca);

        Ciudad montreal = new Ciudad(edificios);

        montreal.entrarAEdificio(indice_banco, tiempo);
        montreal.entrarAEdificio(indice_biblioteca, tiempo);

        assertEquals("Soy una Pista de un banco."+'\n'+"Soy una Pista de una biblioteca.",
                     outputStreamCaptor.toString().trim());
    }

}

package edu.fiuba.algo3.integracion;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Ladron;
import edu.fiuba.algo3.modelo.Nivel;
import edu.fiuba.algo3.modelo.cargos.Cargo;
import edu.fiuba.algo3.modelo.cargos.Novato;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.edificios.Banco;
import edu.fiuba.algo3.modelo.edificios.Biblioteca;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.objetos.ObjetoComun;
import edu.fiuba.algo3.modelo.objetos.ObjetoRobado;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

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
        Ladron ladron = new Ladron("femenino", "", "", "", "");
        Cargo cargo = new Novato();
        Jugador jugador = new Jugador("Mateo");

        Edificio banco = new Banco("Soy una Pista de un banco.");
        List<Edificio> edificios = new ArrayList<Edificio>();
        edificios.add(banco);

        Ciudad montreal = new Ciudad(edificios);

        Nivel nivel = new Nivel(montreal, jugador);
        nivel.entrarAEdificio(0);

        assertEquals("Soy una Pista de un banco.", outputStreamCaptor.toString().trim());
    }

    @Test
    public void test02(){
        List<Edificio> edificios = new ArrayList<Edificio>();

        Edificio banco = new Banco("Soy una Pista de un banco.");
        edificios.add(banco);
        Edificio biblioteca = new Biblioteca("Soy una Pista de una biblioteca.");
        edificios.add(biblioteca);

        Ciudad montreal = new Ciudad(edificios);
        Jugador jugador = new Jugador("Mateo");
        Nivel nivel = new Nivel(montreal, jugador);

        nivel.visitarCiudad(montreal);
        nivel.entrarAEdificio(0);
        nivel.entrarAEdificio(1);

        //Falta verificar que se está entrando a ambos edificios correctamente
//        TODO
//        Biblioteca bibliotecaStub = Mockito.mock(Biblioteca.class);
//        when(bibliotecaStub.mostrarPista()).thenReturn("Soy una Pista de una biblioteca");
//        assertEquals("Soy una Pista de un banco", bibliotecaStub.mostrarPista());
//
//        Banco bancoStub = Mockito.mock(Banco.class);
//        when(bancoStub.mostrarPista()).thenReturn("Soy una Pista de una biblioteca");
//        assertEquals("Soy una Pista de una biblioteca", bancoStub.mostrarPista());
    }

    @Test
    public void test03() {
        Ciudad montreal = new Ciudad();
        Ciudad mexico = new Ciudad();

        Jugador jugador = new Jugador("Mateo");

        Nivel nivel = new Nivel(montreal, jugador);
        nivel.visitarCiudad(mexico);

        assertTrue(nivel.estaEnCiudad(mexico));
    }
}


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
import static org.mockito.Mockito.when;

public class EntregaUnoTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    ObjetoComun tesoroNacional = new ObjetoComun();
    Ladron ladron = new Ladron("femenino","","","","");
    Cargo cargo = new Novato();
    Jugador jugador = new Jugador("Mateo", cargo);

    Edificio banco = new Banco("Soy una Pista de un banco.");
    Edificio biblioteca = new Biblioteca("Soy una Pista de una biblioteca.");
    List<Edificio> edificios = new ArrayList<Edificio>();

    Ciudad montreal = new Ciudad(edificios);
    List<Ciudad> ciudades = new ArrayList<Ciudad>();


    Nivel nivel = new Nivel(ciudades);

    @BeforeEach
    public void setUp() {

        System.setOut(new PrintStream(outputStreamCaptor));
        edificios.add(banco);
        edificios.add(biblioteca);
        ciudades.add(montreal);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void casoDeUsoDos(){

        nivel.visitarCiudad(montreal);
        nivel.entrarAEdificio(biblioteca);
        nivel.entrarAEdificio(banco);

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
}


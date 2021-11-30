package edu.fiuba.algo3.integracion;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Ladron;
import edu.fiuba.algo3.modelo.cargos.Cargo;
import edu.fiuba.algo3.modelo.cargos.Novato;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.objetos.ObjetoComun;
import edu.fiuba.algo3.modelo.objetos.ObjetoRobado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntregaUnoTest {

    @Test
    public void casoDeUsoUno() {
        Ciudad montreal = new Ciudad();
        ObjetoComun objeto = new ObjetoComun(montreal);
        Ladron ladron = new Ladron();
        ladron.setSexo("Femenino");
        Cargo cargo = new Novato();
        Jugador jugador = new Jugador("Mateo", cargo, montreal);


      //  assertEquals("Hola Mundo!", message.greet());
    }
}

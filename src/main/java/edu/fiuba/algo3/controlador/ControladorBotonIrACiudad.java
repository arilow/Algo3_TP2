package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Nivel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBotonIrACiudad implements EventHandler<ActionEvent> {
    Ciudad ciudad;
    Nivel nivel;

    public ControladorBotonIrACiudad(Nivel nivel, Ciudad ciudad) {
        this.nivel = nivel;
        this.ciudad = ciudad;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        nivel.visitarCiudad(ciudad);
    }
}
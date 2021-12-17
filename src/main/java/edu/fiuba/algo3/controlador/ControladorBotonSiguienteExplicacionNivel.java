package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Nivel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBotonSiguienteExplicacionNivel implements EventHandler<ActionEvent> {

    Nivel nivel;

    public ControladorBotonSiguienteExplicacionNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        nivel.arribarACiudadActual();
    }
}

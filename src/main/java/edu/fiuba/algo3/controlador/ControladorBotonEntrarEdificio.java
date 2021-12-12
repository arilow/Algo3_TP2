package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Nivel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBotonEntrarEdificio implements EventHandler<ActionEvent> {
    int indiceEdificio;
    Nivel nivel;

    public ControladorBotonEntrarEdificio(Nivel nivel, int edificio) {
        this.nivel = nivel;
        this.indiceEdificio = edificio;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        nivel.entrarAEdificio(indiceEdificio);
    }
}

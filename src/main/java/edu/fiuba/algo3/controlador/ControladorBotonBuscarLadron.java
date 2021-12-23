package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.DatosLadron;
import edu.fiuba.algo3.modelo.Ladron;
import edu.fiuba.algo3.modelo.Nivel;
import edu.fiuba.algo3.vista.VistaComputadoraInterpol;
import edu.fiuba.algo3.vista.VistaIzquierdaComputadoraInterpol;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;

import java.util.List;

public class ControladorBotonBuscarLadron implements EventHandler<ActionEvent> {

    Nivel nivel;
    Node vistaIzquierdaComputadoraInterpol;
    VistaComputadoraInterpol vistaComputadoraInterpol;

    public ControladorBotonBuscarLadron(Nivel nivel, VistaComputadoraInterpol vistaComputadoraInterpol, Node vistaIzquierdaComputadoraInterpol) {
        this.nivel = nivel;
        this.vistaComputadoraInterpol = vistaComputadoraInterpol;
        this.vistaIzquierdaComputadoraInterpol = vistaIzquierdaComputadoraInterpol;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        nivel.buscarLadrones(vistaComputadoraInterpol.obtenerDatosLadron());

    }
}

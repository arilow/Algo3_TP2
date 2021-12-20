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
    DatosLadron datosLadron;

    public ControladorBotonBuscarLadron(Nivel nivel, DatosLadron datosCargadosLadron, Node vistaIzquierdaComputadoraInterpol) {
        this.nivel = nivel;
        this.datosLadron = datosCargadosLadron;

        this.vistaIzquierdaComputadoraInterpol = vistaIzquierdaComputadoraInterpol;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        List<Ladron> ladrones = nivel.buscarLadrones(this.datosLadron);
        for(Ladron ladron : ladrones) {
            System.out.println(ladron.obtenerNombre());
        }
    }
}

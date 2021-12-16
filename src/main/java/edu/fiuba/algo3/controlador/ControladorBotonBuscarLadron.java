package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.DatosLadron;
import edu.fiuba.algo3.modelo.Ladron;
import edu.fiuba.algo3.modelo.Nivel;
import edu.fiuba.algo3.vista.VistaComputadoraInterpol;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBotonBuscarLadron implements EventHandler<ActionEvent> {

    Nivel nivel;
    VistaComputadoraInterpol vistaComputadoraInterpol;

    public ControladorBotonBuscarLadron(Nivel nivel, VistaComputadoraInterpol vistaComputadoraInterpol) {
        this.nivel = nivel;
        this.vistaComputadoraInterpol = vistaComputadoraInterpol;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        DatosLadron datosLadron = vistaComputadoraInterpol.obtenerDatosLadron();

        for(Ladron ladron: nivel.buscarLadrones(datosLadron)){
            System.out.println(ladron.obtenerNombre());
        }

        //si la lista es unitaria asiganar orden de arresto al ladron


    }
}

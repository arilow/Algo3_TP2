package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.DatosLadron;
import edu.fiuba.algo3.modelo.Ladron;
import edu.fiuba.algo3.modelo.Nivel;
import edu.fiuba.algo3.vista.VistaComputadoraInterpol;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.List;

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
        List<Ladron> listaLadrones = nivel.buscarLadrones(datosLadron);

        if (listaLadrones.size() == 1){
            String nombre = listaLadrones.get(0).obtenerNombre();
            nivel.emitirOrdenDeArresto(listaLadrones.get(0).obtenerNombre());
            System.out.println("Se emite orden de arresto a : "+ nombre );
            // todo Esto imprimir en vista izquierda
        } else{
            for(Ladron ladron: nivel.buscarLadrones(datosLadron)){
                System.out.println(ladron.obtenerNombre());
                // todo: esto imprimir en vista izquierda
            }
        }

        //si la lista es unitaria asiganar orden de arresto al ladron


    }
}

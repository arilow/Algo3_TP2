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
    VistaComputadoraInterpol vistaComputadoraInterpol;
    Node vistaIzquierdaComputadoraInterpol;

    public ControladorBotonBuscarLadron(Nivel nivel, VistaComputadoraInterpol vistaComputadoraInterpol, Node vistaIzquierdaComputadoraInterpol) {
        this.nivel = nivel;
        this.vistaComputadoraInterpol = vistaComputadoraInterpol;
        this.vistaIzquierdaComputadoraInterpol = vistaIzquierdaComputadoraInterpol;
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

        VistaIzquierdaComputadoraInterpol.enlistarLadrones(listaLadrones);

        //si la lista es unitaria asiganar orden de arresto al ladron


    }
}

package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Nivel;
import edu.fiuba.algo3.vista.VentanaPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBotonInterpol implements EventHandler<ActionEvent> {

    VentanaPrincipal ventanaPrincipal;
    Nivel nivelActual;

    public ControladorBotonInterpol(Nivel nivel, VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        nivelActual = nivel;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ventanaPrincipal.mostrarComputadoraInterpol();
    }
}

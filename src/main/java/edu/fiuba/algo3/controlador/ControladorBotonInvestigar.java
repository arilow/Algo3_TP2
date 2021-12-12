package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.VentanaPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBotonInvestigar implements EventHandler<ActionEvent>  {
    VentanaPrincipal ventanaPrincipal;

    public ControladorBotonInvestigar(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ventanaPrincipal.mostrarEdificios();
    }
}

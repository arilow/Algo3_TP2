package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Nivel;
import edu.fiuba.algo3.vista.VentanaPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBotonInvestigar implements EventHandler<ActionEvent>  {
    VentanaPrincipal ventanaPrincipal;
    Nivel nivelActual;

    public ControladorBotonInvestigar(Nivel nivel, VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        nivelActual = nivel;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ventanaPrincipal.mostrarEdificios(nivelActual.listarEdificios());
    }
}

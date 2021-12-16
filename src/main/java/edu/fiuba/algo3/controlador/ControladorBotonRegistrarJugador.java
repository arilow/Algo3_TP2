package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Nivel;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.vista.VentanaPrincipal;
import edu.fiuba.algo3.vista.VistaRegistroJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBotonRegistrarJugador implements EventHandler<ActionEvent> {

    private VistaRegistroJugador vista;
    private Partida partida;

    public ControladorBotonRegistrarJugador(Partida partida) {
        this.partida = partida;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String nombreJugador = vista.obtenerInfoJugador();

        partida.registrarJugador(nombreJugador);
    }

}

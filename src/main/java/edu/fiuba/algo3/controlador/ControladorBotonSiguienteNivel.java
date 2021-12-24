package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.vista.VistaRegistroJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBotonSiguienteNivel implements EventHandler<ActionEvent> {

    private Partida partida;

    public ControladorBotonSiguienteNivel(Partida partida) {
        this.partida = partida;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        partida.siguienteNivel();
    }
}

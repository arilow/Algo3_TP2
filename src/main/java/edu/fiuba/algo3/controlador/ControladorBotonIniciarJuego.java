package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.OyenteEstadoPartida;
import edu.fiuba.algo3.vista.VentanaPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBotonIniciarJuego implements EventHandler<ActionEvent> {

    Juego juego;
    VentanaPrincipal vista;
    OyenteEstadoPartida oyenteEstadoPartida;

    public ControladorBotonIniciarJuego(Juego juego, OyenteEstadoPartida oyenteEstadoPartida) {
        this.juego = juego;
        this.oyenteEstadoPartida = oyenteEstadoPartida;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        juego.comenzarPartida(oyenteEstadoPartida);
    }
}

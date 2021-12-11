package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.VentanaPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBotonIniciarJuego implements EventHandler<ActionEvent> {

    Juego juego;
    VentanaPrincipal vista;
    public ControladorBotonIniciarJuego(Juego juego, VentanaPrincipal vista) {
        this.juego = juego;
        this.vista = vista;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println("Hola!!");
        vista.abrirPantallaDePartida();
        juego.comenzarPartida();
    }
}

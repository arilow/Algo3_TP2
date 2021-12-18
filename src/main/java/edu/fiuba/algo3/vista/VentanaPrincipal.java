package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBotonIniciarJuego;
import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class VentanaPrincipal implements Observer {
    int anchoVentana;
    int altoVentana;

    ConstructorDeEscenas constructorDeEscenas;
    Button initButton;
    Juego juego;
    Stage stage;

    public VentanaPrincipal(Stage stage, Juego juego) {
        this.juego = juego;
        this.stage = stage;
        anchoVentana = 640;
        altoVentana = 480;

        // Borrar.
        juego.addObserver(this);

        initButton = new Button();
        initButton.setText("Iniciar juego");
        initButton.setOnAction(new ControladorBotonIniciarJuego(juego, new OyenteEstadoPartida(this)));
        StackPane layout = new StackPane();

        layout.getChildren().add(initButton);

        Scene scene = new Scene(layout, anchoVentana, altoVentana);
        stage.setScene(scene);

        constructorDeEscenas = new ConstructorDeEscenas(this, stage, juego, anchoVentana, altoVentana);
    }

    public void abrirPantallaRegistroJugador() {
        HBox layout = constructorDeEscenas.construirPantallaRegistroJugador();
        Scene scene = new Scene(layout, anchoVentana, altoVentana);
        stage.setScene(scene);
    }

    public void mostrarPantallaInicioNivel() {
        HBox layout = constructorDeEscenas.construirPantallaInicioNivel();
        Scene scene = new Scene(layout, anchoVentana, altoVentana);
        stage.setScene(scene);
    }

    public void mostrarPantallaInicioCiudad() {
        HBox layout = constructorDeEscenas.construirPantallaInicioCiudad();
        Scene scene = new Scene(layout, anchoVentana, altoVentana);
        stage.setScene(scene);
    }

    public void mostrarEdificios(List<String> edificios) {
        HBox layout = constructorDeEscenas.construirPantallaSeleccionEdificios(edificios);
        Scene scene = new Scene(layout, anchoVentana, altoVentana);
        stage.setScene(scene);
    }

    public void mostrarComputadoraInterpol() {
        constructorDeEscenas.construirPantallaComputadoraInterpol();
    }

    @Override
    public void update(Observable o, Object arg) {
        // abrirPantallaRegistroJugador();
        // abrirPantallaDePartida();
    }
}

package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBotonIniciarJuego;
import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class VentanaPrincipal {
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

        initButton = new Button();
        initButton.setText("Iniciar juego");
        initButton.setOnAction(new ControladorBotonIniciarJuego(juego, new OyenteEstadoPartida(this)));
        StackPane layout = new StackPane();

        layout.getChildren().add(initButton);

        Scene scene = new Scene(layout, anchoVentana, altoVentana);
        stage.setScene(scene);

        constructorDeEscenas = new ConstructorDeEscenas(this, juego, anchoVentana, altoVentana);
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

    public void mostrarEdificios() {
        HBox layout = constructorDeEscenas.construirPantallaSeleccionEdificios();
        Scene scene = new Scene(layout, anchoVentana, altoVentana);
        stage.setScene(scene);
    }

    public void mostrarComputadoraInterpol() {
        HBox layout = constructorDeEscenas.construirPantallaComputadoraInterpol();
        Scene scene = new Scene(layout, anchoVentana, altoVentana);
        stage.setScene(scene);
    }

    public void mostrarPantallaEdificio() {
        HBox layout = constructorDeEscenas.construirPantallaEdificio(juego.nivelActual().obtenerEdificioActual().mostrarPista());
        Scene scene = new Scene(layout, anchoVentana, altoVentana);
        stage.setScene(scene);
    }
    public void mostrarPantallaInterpol() {
        HBox layout = constructorDeEscenas.construirPantallaInterpol();
        Scene scene = new Scene(layout, anchoVentana, altoVentana);
        stage.setScene(scene);
    }
    public void mostrarPantallaMapa() {
        HBox layout = constructorDeEscenas.construirPantallaMapa(juego.nivelActual().obtenerCiudadActual());
        Scene scene = new Scene(layout, anchoVentana, altoVentana);
        stage.setScene(scene);
    }
    public void mostrarCiudades() {
        HBox layout = constructorDeEscenas.construirPantallaSeleccionCiudades();
        Scene scene = new Scene(layout, anchoVentana, altoVentana);
        stage.setScene(scene);
    }

}

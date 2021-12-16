package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBotonIniciarJuego;
import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class VentanaPrincipal implements Observer {
    int windowHeight;
    int windowWidth;

    ConstructorDeEscenas constructorDeEscenas;
    Button initButton;
    Juego juego;
    Stage stage;

    public VentanaPrincipal(Stage stage, Juego juego) {
        this.juego = juego;
        this.stage = stage;
        windowWidth = 640;
        windowHeight = 480;
        juego.addObserver(this);

        initButton = new Button();
        initButton.setText("Iniciar juego");
        initButton.setOnAction(new ControladorBotonIniciarJuego(juego, this));
        StackPane layout = new StackPane();

        layout.getChildren().add(initButton);

        Scene scene = new Scene(layout, windowWidth, windowHeight);
        stage.setScene(scene);
    }

    public void abrirPantallaDePartida() {
        constructorDeEscenas = new ConstructorDeEscenas(this, stage, juego.nivelActual(), windowWidth, windowHeight);
        constructorDeEscenas.construirEscenaPrincipal();
    }


    public void mostrarEdificios(List<String> edificios) {
        constructorDeEscenas.construirPantallaSeleccionEdificios(edificios);
    }


    public void mostrarComputadoraInterpol() {
        constructorDeEscenas.construirPantallaComputadoraInterpol();
    }

    @Override
    public void update(Observable o, Object arg) {
        abrirPantallaDePartida();
    }
}

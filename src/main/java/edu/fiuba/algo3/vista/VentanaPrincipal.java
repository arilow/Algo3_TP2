package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBotonIniciarJuego;
import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class VentanaPrincipal {
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

        constructorDeEscenas = new ConstructorDeEscenas(this, windowWidth, windowHeight);
        initButton = new Button();
        initButton.setText("Iniciar juego");
        initButton.setOnAction(new ControladorBotonIniciarJuego(juego, this));
        StackPane layout = new StackPane();

        layout.getChildren().add(initButton);

        var scene = new Scene(layout, windowWidth, windowHeight);
        stage.setScene(scene);
    }

    public void abrirPantallaDePartida() {
        Scene scene = constructorDeEscenas.construirEscenaPrincipal();
        stage.setScene(scene);
    }



    public void mostrarEdificios() {
        Scene escenaSeccionEdificios = constructorDeEscenas.construirPantallaSeleccionEdificios();
        stage.setScene(escenaSeccionEdificios);
    }


}

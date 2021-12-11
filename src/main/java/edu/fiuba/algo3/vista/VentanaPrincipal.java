package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBotonIniciarJuego;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.sitios.edificios.Edificio;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class VentanaPrincipal {
    int windowHeight;
    int windowWidth;

    Button initButton;
    Juego juego;
    Stage stage;

    public VentanaPrincipal(Stage stage, Juego juego) {
        this.juego = juego;
        this.stage = stage;
        windowWidth = 640;
        windowHeight = 480;

        initButton = new Button();
        initButton.setText("Iniciar juego");
        initButton.setOnAction(new ControladorBotonIniciarJuego(juego, this));
        StackPane layout = new StackPane();

        layout.getChildren().add(initButton);

        var scene = new Scene(layout, windowWidth, windowHeight);
        stage.setScene(scene);
    }

    public void abrirPantallaDePartida() {
        VBox verticalIzquierda = construirPantallaIzquierda();
        VBox verticalDerecha = construirPantallaDerecha();

        HBox layout = new HBox();
        layout.getChildren().addAll(verticalIzquierda, verticalDerecha);

        Scene scene = new Scene(layout, windowWidth, windowHeight);
        stage.setScene(scene);
    }

    VBox construirPantallaIzquierda() {
        double canvasWidth = windowWidth * 0.5;
        double canvasHeight = windowHeight * 0.9;

        Label etiquetaCiudad = new Label("Ciudad");
        Label etiquetaTiempo = new Label("Dia, hora");

        VBox info = new VBox(etiquetaCiudad, etiquetaTiempo);
        info.setPrefHeight(windowHeight - canvasHeight);

        Canvas canvasIzquierda = new Canvas(canvasWidth, canvasHeight);
        GraphicsContext gcI = canvasIzquierda.getGraphicsContext2D();

        gcI.setFill(Color.RED);
        gcI.fillRect(0,0, canvasHeight, canvasHeight);


        VBox verticalIzquierda = new VBox();
        verticalIzquierda.getChildren().addAll(info, canvasIzquierda);

        return verticalIzquierda;
    }

    VBox construirPantallaDerecha() {
        double canvasWidth = windowWidth * 0.5;
        double canvasHeight = windowHeight * 0.75;

        Canvas canvasDerecha = new Canvas(canvasWidth, canvasHeight);
        GraphicsContext gcD = canvasDerecha.getGraphicsContext2D();

        gcD.setFill(Color.BLUE);
        gcD.fillRect(0,0,canvasWidth,canvasHeight);

        Button botonConecciones = new Button("Ver conecciones");
        botonConecciones.setPrefHeight(canvasHeight * 0.25);
        botonConecciones.setPrefWidth(windowWidth - canvasWidth);

        Button botonMapa;
        botonMapa = new Button("Viajar");
        botonMapa.setPrefHeight(canvasHeight * 0.25);
        botonMapa.setPrefWidth(windowWidth - canvasWidth);

        Button botonEdificios;
        botonEdificios = new Button("Investigar");
        botonEdificios.setPrefHeight(canvasHeight * 0.25);
        botonEdificios.setPrefWidth(windowWidth - canvasWidth);

        Button botonCompu;
        botonCompu = new Button("Visitar Interpol");
        botonCompu.setPrefHeight(canvasHeight * 0.25);
        botonCompu.setPrefWidth(windowWidth - canvasWidth);


        VBox optionButons = new VBox();
        optionButons.getChildren().addAll(botonConecciones, botonMapa, botonEdificios, botonCompu);

        VBox verticalDerecha = new VBox();
        verticalDerecha.getChildren().addAll(canvasDerecha, optionButons);
        return verticalDerecha;
    }

}

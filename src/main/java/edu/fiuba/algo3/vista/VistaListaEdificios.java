package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBotonEntrarEdificio;
import edu.fiuba.algo3.modelo.Nivel;
import edu.fiuba.algo3.modelo.Pista;
import edu.fiuba.algo3.modelo.sitios.edificios.Edificio;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class VistaListaEdificios extends VBox implements Observer{
    ConstructorDeEscenas constructorDeEscenas;

    public VistaListaEdificios(Nivel nivelActual, double ancho, double alto, ConstructorDeEscenas constructorDeEscenas) {
        this.constructorDeEscenas = constructorDeEscenas;
        List<String> edificios =  nivelActual.listarEdificios();
        nivelActual.agregarObservadorDeEdificios(this);


        double anchoCanvas = ancho;

        // Canvas izquierdo
        double altoIzquierdo = alto;
        double altoCanvas = altoIzquierdo * 0.8;
        Canvas canvasIzquierdo = new Canvas(anchoCanvas, altoCanvas);
        GraphicsContext gcI = canvasIzquierdo.getGraphicsContext2D();

        gcI.setFill(Color.GREEN);
        gcI.fillRect(0,0, anchoCanvas, altoCanvas);

        // Botones efificios izquierda
        double altoBotones = altoIzquierdo - altoCanvas;
        Button botonEdificio1;
        botonEdificio1 = new Button(edificios.get(0));
        botonEdificio1.setPrefHeight(altoIzquierdo - altoBotones);
        botonEdificio1.setPrefWidth(ancho * 0.33);
        botonEdificio1.setOnAction(new ControladorBotonEntrarEdificio(nivelActual, 0));

        Button botonEdificio2;
        botonEdificio2 = new Button(edificios.get(1));
        botonEdificio2.setPrefHeight(altoIzquierdo - altoBotones);
        botonEdificio2.setPrefWidth(ancho * 0.33);
        botonEdificio2.setOnAction(new ControladorBotonEntrarEdificio(nivelActual, 1));

        Button botonEdificio3;
        botonEdificio3 = new Button(edificios.get(2));
        botonEdificio3.setPrefHeight(altoIzquierdo - altoBotones);
        botonEdificio3.setPrefWidth(ancho * 0.33);
        botonEdificio3.setOnAction(new ControladorBotonEntrarEdificio(nivelActual, 2));

        HBox botones = new HBox(botonEdificio1, botonEdificio2, botonEdificio3);

        this.getChildren().addAll(canvasIzquierdo, botones);
    }

    @Override
    public void update(Observable o, Object arg) {
        constructorDeEscenas.construirPantallaEdificio((Pista)arg);
    }
}

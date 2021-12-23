package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBotonEntrarEdificio;
import edu.fiuba.algo3.controlador.ControladorBotonIrACiudad;
import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Nivel;
import edu.fiuba.algo3.modelo.Pista;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class VistaListaMapa extends VBox{
    ConstructorDeEscenas constructorDeEscenas;

    public VistaListaMapa(Nivel nivelActual, double ancho, double alto) {
        List<Ciudad> ciudades =  nivelActual.listarCiudades();

        double anchoCanvas = ancho;

        // Canvas izquierdo
        double altoIzquierdo = alto;
        double altoCanvas = altoIzquierdo * 0.95;
        Canvas canvasIzquierdo = new Canvas(anchoCanvas, altoCanvas);
        GraphicsContext gcI = canvasIzquierdo.getGraphicsContext2D();

        gcI.setFill(Color.BLUE);
        gcI.fillRect(0,0, anchoCanvas, altoCanvas);

        List<String> ciudadesVisitable = nivelActual.obtenerCiudadActual().obtenerCiudadesVisitables();

        // Botones Ciudades izquierda
        double altoBotones = altoIzquierdo - altoCanvas;
        Button botonCiudad1;
        botonCiudad1 = new Button(ciudadesVisitable.get(0));
        botonCiudad1.setPrefHeight(altoIzquierdo - altoBotones);
        botonCiudad1.setPrefWidth(ancho * 0.33);
        botonCiudad1.setOnAction(new ControladorBotonIrACiudad(nivelActual, nivelActual.obtenerCiudad(ciudadesVisitable.get(0))));

        Button botonCiudad2;
        botonCiudad2 = new Button(ciudadesVisitable.get(1));
        botonCiudad2.setPrefHeight(altoIzquierdo - altoBotones);
        botonCiudad2.setPrefWidth(ancho * 0.33);
        botonCiudad2.setOnAction(new ControladorBotonIrACiudad(nivelActual, nivelActual.obtenerCiudad(ciudadesVisitable.get(1))));

        Button botonCiudad3;
        botonCiudad3 = new Button(ciudadesVisitable.get(2));
        botonCiudad3.setPrefHeight(altoIzquierdo - altoBotones);
        botonCiudad3.setPrefWidth(ancho * 0.33);
        botonCiudad3.setOnAction(new ControladorBotonIrACiudad(nivelActual, nivelActual.obtenerCiudad(ciudadesVisitable.get(2))));

        HBox botones = new HBox(botonCiudad1, botonCiudad2, botonCiudad3);

        this.getChildren().addAll(canvasIzquierdo, botones);
    }
}

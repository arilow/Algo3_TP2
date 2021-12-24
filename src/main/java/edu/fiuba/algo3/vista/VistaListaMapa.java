package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBotonIrACiudad;
import edu.fiuba.algo3.modelo.Nivel;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class VistaListaMapa extends VBox{
    public VistaListaMapa(Nivel nivelActual, double ancho, double alto) {
        double anchoCanvas = ancho;

        // Canvas izquierdo
        double altoIzquierdo = alto;
        double altoCanvas = altoIzquierdo * 0.95;
        Canvas canvasIzquierdo = new Canvas(anchoCanvas, altoCanvas);
        GraphicsContext gcI = canvasIzquierdo.getGraphicsContext2D();

        Image image = new Image("Mapa.jpg");
        // TODO: des-hardcodear valores.
        gcI.drawImage(image, 0, altoCanvas*0.1, anchoCanvas, anchoCanvas);

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

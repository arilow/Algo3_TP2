package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Nivel;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class VistaListaCiudades extends VBox{
    public VistaListaCiudades(Nivel nivelActual, double ancho, double alto) {
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
        double altoEtiquetas = altoIzquierdo - altoCanvas;
        Label etiquetaCiudad1;
        etiquetaCiudad1 = new Label(ciudadesVisitable.get(0));
        etiquetaCiudad1.setPrefHeight(altoIzquierdo - altoEtiquetas);
        etiquetaCiudad1.setPrefWidth(ancho * 0.33);

        Label etiquetaCiudad2;
        etiquetaCiudad2 = new Label(ciudadesVisitable.get(1));
        etiquetaCiudad2.setPrefHeight(altoIzquierdo - altoEtiquetas);
        etiquetaCiudad2.setPrefWidth(ancho * 0.33);

        Label etiquetaCiudad3;
        etiquetaCiudad3 = new Label(ciudadesVisitable.get(2));
        etiquetaCiudad3.setPrefHeight(altoIzquierdo - altoEtiquetas);
        etiquetaCiudad3.setPrefWidth(ancho * 0.33);

        HBox botones = new HBox(etiquetaCiudad1, etiquetaCiudad2, etiquetaCiudad3);

        this.getChildren().addAll(canvasIzquierdo, botones);
    }
}

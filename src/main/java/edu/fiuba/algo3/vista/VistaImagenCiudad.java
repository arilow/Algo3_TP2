package edu.fiuba.algo3.vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class VistaImagenCiudad extends Canvas {

    public VistaImagenCiudad(double ancho, double alto) {
        super(ancho, alto);
        GraphicsContext gcI = getGraphicsContext2D();

        gcI.setFill(Color.RED);
        gcI.fillRect(0,0, alto, alto);
    }
}

package edu.fiuba.algo3.vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class VistaDescripcionCiudad extends Canvas {
    public VistaDescripcionCiudad(double ancho, double alto) {
        super(ancho, alto);
        GraphicsContext gcD = getGraphicsContext2D();

        gcD.setFill(Color.BLUE);
        gcD.fillRect(0,0,ancho, alto);
    }
}

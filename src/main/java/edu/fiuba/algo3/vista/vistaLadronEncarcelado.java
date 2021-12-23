package edu.fiuba.algo3.vista;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class vistaLadronEncarcelado extends Canvas {

    public vistaLadronEncarcelado(double ancho, double alto) {
        super(ancho, alto);
        GraphicsContext gcI = getGraphicsContext2D();

        Image image = new Image("Imagen_encarcelado.png");
        // TODO: des-hardcodear valores.
        gcI.drawImage(image, 0, alto-300, ancho, 200);
    }
}

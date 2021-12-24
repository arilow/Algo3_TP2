package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Nivel;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class VistaImagenCiudad extends Canvas {

    public VistaImagenCiudad(Ciudad ciudad, double ancho, double alto) {
        super(ancho, alto);
        GraphicsContext gcI = getGraphicsContext2D();

        Image image = new Image(ciudad.obtenerImagen());
        // TODO: des-hardcodear valores.
        gcI.drawImage(image, 0, 0, ancho, alto);
    }
}

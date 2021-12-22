package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Pista;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class VistaEdificio extends Canvas {

    public VistaEdificio(Pista pista, double ancho, double alto) {
        super(ancho, alto);
        GraphicsContext gcI = this.getGraphicsContext2D();

        Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 12);
        gcI.setFont( theFont );

        gcI.fillText(pista.mostrar(), 10, 90, 310);

        System.out.println(pista.obtenerImagen());
        Image image = new Image(pista.obtenerImagen());
        // TODO: des-hardcodear valores.
        gcI.drawImage(image, 0, alto-200, ancho, 200);
    }
}

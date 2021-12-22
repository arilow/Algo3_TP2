package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Pista;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class VistaMapa extends Canvas {
    public VistaMapa(Ciudad ciudad, double ancho, double alto) {
        super(ancho, alto);
        GraphicsContext gcI = this.getGraphicsContext2D();

        Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 12 );
        gcI.setFont( theFont );

        Image image = new Image(ciudad.obtenerImagen());
        gcI.drawImage(image, 0, alto-200, ancho, 200);
    }
}

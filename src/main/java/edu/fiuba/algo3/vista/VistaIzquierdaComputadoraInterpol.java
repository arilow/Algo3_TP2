package edu.fiuba.algo3.vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class VistaIzquierdaComputadoraInterpol extends Canvas {
    private GraphicsContext gcI;

    public VistaIzquierdaComputadoraInterpol(double anchoPantalla, double altoPantallaIzquierdaActual) {
        super(anchoPantalla, altoPantallaIzquierdaActual);

        gcI = getGraphicsContext2D();

        gcI.setFill(Color.YELLOWGREEN);
        gcI.setLineWidth(2);
        gcI.fillRect(0,0, anchoPantalla, altoPantallaIzquierdaActual);

        gcI.setFill(Color.BLACK);
        Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 15 );
        gcI.setFont( theFont );
        gcI.fillText("Listo para buscar", 91,200);
        gcI.fillText("en computadora.", 95,220);
    }
}

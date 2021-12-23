package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Ladron;
import edu.fiuba.algo3.modelo.Nivel;
import edu.fiuba.algo3.modelo.Pista;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.List;

public class VistaSospechosos extends Canvas {
    private GraphicsContext gcI;

    public VistaSospechosos(List<Ladron> sospechosos, double ancho, double alto) {
        super(ancho, alto);
        gcI = getGraphicsContext2D();

        gcI.setFill(Color.YELLOWGREEN);
        gcI.setLineWidth(2);
        gcI.fillRect(0,0, ancho, alto);
        gcI.setFill(Color.BLACK);
        Font theFont = Font.font( "Times New Roman", FontWeight.LIGHT, 15 );
        gcI.setFont( theFont );

        if (sospechosos.size() == 1)
        {
            gcI.fillText("Ya tienes la orden para arrestar a ", 81,200, ancho/2 );
            gcI.fillText(sospechosos.get(0).obtenerNombre() + '\n', 81,220, ancho/2 );
        }
        else{
            int i = 0;
            for(Ladron ladron: sospechosos){
                gcI.fillText(ladron.obtenerNombre(), 101,40+i , ancho/2 );
                i+=20;
                System.out.println(ladron.obtenerNombre());
            }
        }
    }
}

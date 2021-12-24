package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Pista;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class VistaEdificio extends VBox {
    public VistaEdificio(Pista pista, double ancho, double alto) {

        // Texto
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setPrefHeight(alto/2);
        scrollPane.setPrefWidth(ancho);

        Text text = new Text();
        text.setFont(new Font("Times New Roman", 16));
        text.setText(pista.mostrar());
        text.setWrappingWidth(ancho);
        scrollPane.setContent(text);

        // Canvas de la imagen.
        Canvas canvas = new Canvas(ancho, alto/2);
        GraphicsContext gcI = canvas.getGraphicsContext2D();
        Image image = new Image(pista.obtenerImagen());
        // TODO: des-hardcodear valores.
        gcI.drawImage(image, 0, 0, ancho, alto/2);

        this.getChildren().addAll(scrollPane, canvas);
    }
}

package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBotonBuscarLadron;
import edu.fiuba.algo3.modelo.DatosLadron;
import edu.fiuba.algo3.modelo.Nivel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.List;

public class VistaComputadoraInterpol extends VBox {

    Nivel nivelActual;
    DatosLadron datosLadron;
    public TextField inputSexo;
    TextField inputHobby;
    TextField inputSenia;
    TextField inputVehiculo;
    TextField inputCabello;
    TextField inputCabllo;

    public VistaComputadoraInterpol (Nivel nivelActual, double ancho, double alto, Node vistaIzquierdaComputadoraInterpol) {

        this.nivelActual = nivelActual;
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        double anchoCanvas = ancho;

        // Canvas izquierdo
        double altoIzquierdo = alto;
        double altoCanvas = altoIzquierdo * 0.4;
        Canvas canvasDerecho = new Canvas(anchoCanvas, altoCanvas);
        GraphicsContext gcI = canvasDerecho.getGraphicsContext2D();

        gcI.setFill(Color.GREEN);
        gcI.fillRect(0,0, anchoCanvas, altoCanvas);

        Label labelSexo = new Label("Sexo:");
        gridPane.setConstraints(labelSexo, 0,0);
        inputSexo = new TextField();
        gridPane.setConstraints(inputSexo, 1,0);

        Label labelHobby = new Label("Hobby:");
        gridPane.setConstraints(labelHobby,0, 1);
        inputHobby = new TextField();
        gridPane.setConstraints(inputHobby, 1,1);

        Label labelCabello = new Label("Cabello:");
        gridPane.setConstraints(labelCabello,0, 2);
        inputCabello = new TextField();
        gridPane.setConstraints(inputCabello, 1,2);

        Label labelSenia = new Label("Seña:");
        gridPane.setConstraints(labelSenia,0, 3);
        inputSenia = new TextField();
        gridPane.setConstraints(inputSenia, 1,3);

        Label labelVehiculo = new Label("Vehículo:");
        gridPane.setConstraints(labelVehiculo,0, 4);
        inputVehiculo = new TextField();
        gridPane.setConstraints(inputVehiculo, 1,4);

        Button checkLadronBoton = new Button("Buscar ladrones");
        gridPane.setConstraints(checkLadronBoton,1, 5);

        this.getChildren().addAll(labelSexo,inputSexo,labelHobby,inputHobby,labelCabello,inputCabello,labelSenia,inputSenia,labelVehiculo,inputVehiculo,checkLadronBoton,canvasDerecho);

        obtenerDatosLadron();
        checkLadronBoton.setOnAction( new ControladorBotonBuscarLadron(nivelActual, datosLadron, vistaIzquierdaComputadoraInterpol ));

    }
    public void obtenerDatosLadron() {
        this.datosLadron = new DatosLadron(inputSexo.getText(), inputHobby.getText(), inputCabello.getText(),
                inputSenia.getText(), inputVehiculo.getText());
    }
}

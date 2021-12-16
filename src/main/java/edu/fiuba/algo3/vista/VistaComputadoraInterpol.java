package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBotonBuscarLadron;
import edu.fiuba.algo3.modelo.DatosLadron;
import edu.fiuba.algo3.modelo.Nivel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class VistaComputadoraInterpol extends GridPane {

    Nivel nivelActual;
    DatosLadron datosLadron;
    TextField inputSexo;
    TextField inputHobby;
    TextField inputSenia;
    TextField inputVehiculo;
    TextField inputCabello;
    TextField inputCabllo;

    public VistaComputadoraInterpol (Nivel nivelActual, double ancho, double alto) {

        this.nivelActual = nivelActual;

        this.setPadding(new Insets(10,10,10,10));
        this.setVgap(8);
        this.setHgap(10);

        Label labelSexo = new Label("Sexo:");
        setConstraints(labelSexo, 0,0);
        inputSexo = new TextField();
        setConstraints(inputSexo, 1,0);

        Label labelHobby = new Label("Hobby:");
        setConstraints(labelHobby,0, 1);
        inputHobby = new TextField();
        setConstraints(inputHobby, 1,1);

        Label labelCabello = new Label("Cabello:");
        setConstraints(labelCabello,0, 2);
        inputCabello = new TextField();
        setConstraints(inputCabello, 1,2);

        Label labelSenia = new Label("Seña:");
        setConstraints(labelSenia,0, 3);
        inputSenia = new TextField();
        setConstraints(inputSenia, 1,3);

        Label labelVehiculo = new Label("Vehículo:");
        setConstraints(labelVehiculo,0, 4);
        inputVehiculo = new TextField();
        setConstraints(inputVehiculo, 1,4);

        Button checkLadronBoton = new Button("Buscar ladrones");
        setConstraints(checkLadronBoton,1, 5);

        /*checkLadronBoton.setOnAction(e -> System.out.println(inputSexo.getText()));
        checkLadronBoton.setOnAction(e -> System.out.println(inputHobby.getText()));
        checkLadronBoton.setOnAction(e -> System.out.println(inputCabello.getText()));
        checkLadronBoton.setOnAction(e -> System.out.println(inputSenia.getText()));*/

        checkLadronBoton.setOnAction( new ControladorBotonBuscarLadron(nivelActual,this ));

        this.getChildren().addAll(labelSexo,inputSexo,labelHobby,inputHobby,labelCabello,inputCabello,labelSenia,inputSenia,labelVehiculo,inputVehiculo,checkLadronBoton);

        //Scene scene = new Scene(this, ancho,alto);

    }

    public DatosLadron obtenerDatosLadron() {

        datosLadron = new DatosLadron(inputSexo.getText(), inputHobby.getText(), inputCabello.getText(), inputSenia.getText(), inputVehiculo.getText());
        return datosLadron;
    }
}

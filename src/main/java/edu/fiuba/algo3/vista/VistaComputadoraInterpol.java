package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class VistaComputadoraInterpol extends GridPane {


    public VistaComputadoraInterpol (double ancho, double alto) {

        this.setPadding(new Insets(10,10,10,10));
        this.setVgap(8);
        this.setHgap(10);

        Label labelSexo = new Label("Sexo:");
        this.setConstraints(labelSexo, 0,0);
        TextField inputSexo = new TextField();
        this.setConstraints(inputSexo, 1,0);

        Label labelHobby = new Label("Hobby:");
        this.setConstraints(labelHobby,0, 1);
        TextField inputHobby = new TextField();
        this.setConstraints(inputHobby, 1,1);

        Label labelCabello = new Label("Cabello:");
        this.setConstraints(labelCabello,0, 2);
        TextField inputCabello = new TextField();
        this.setConstraints(inputCabello, 1,2);

        Label labelSenia = new Label("Seña:");
        this.setConstraints(labelSenia,0, 3);
        TextField inputSenia = new TextField();
        this.setConstraints(inputSenia, 1,3);

        Label labelVehiculo = new Label("Vehículo:");
        this.setConstraints(labelVehiculo,0, 4);
        TextField inputVehiculo = new TextField();
        this.setConstraints(inputVehiculo, 1,4);

        Button checkLadronBoton = new Button("Buscar ladrones");
        this.setConstraints(checkLadronBoton,1, 5);

        checkLadronBoton.setOnAction(e -> System.out.println("Buscar ladrones"));

        this.getChildren().addAll(labelSexo,inputSexo,labelHobby,inputHobby,labelCabello,inputCabello,labelSenia,inputSenia,labelVehiculo,inputVehiculo,checkLadronBoton);

        //Scene scene = new Scene(this, ancho,alto);



    }
}

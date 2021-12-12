package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBotonInvestigar;
import edu.fiuba.algo3.modelo.Nivel;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class VistaOpcionesJuego extends VBox {
    public VistaOpcionesJuego(Nivel nivelActual, VentanaPrincipal ventanaPrincipal, double ancho, double alto) {
        Button botonConexiones = new Button("Ver conexiones");
        botonConexiones.setPrefHeight(alto * 0.25);
        botonConexiones.setPrefWidth(ancho);

        Button botonMapa;
        botonMapa = new Button("Viajar");
        botonMapa.setPrefHeight(alto * 0.25);
        botonMapa.setPrefWidth(ancho);

        Button botonEdificios;
        botonEdificios = new Button("Investigar");
        botonEdificios.setPrefHeight(alto * 0.25);
        botonEdificios.setPrefWidth(ancho);
        botonEdificios.setOnAction(new ControladorBotonInvestigar(nivelActual, ventanaPrincipal));

        Button botonCompu;
        botonCompu = new Button("Visitar Interpol");
        botonCompu.setPrefHeight(alto * 0.25);
        botonCompu.setPrefWidth(ancho);

        getChildren().addAll(botonConexiones, botonMapa, botonEdificios, botonCompu);
    }
}

package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Nivel;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class VistaOpcionesJuego extends VBox {
    public VistaOpcionesJuego(VentanaPrincipal ventanaPrincipal, double ancho, double alto) {

        Button botonConexiones = new Button("Ver conexiones");
        botonConexiones.setPrefHeight(alto * 0.25);
        botonConexiones.setPrefWidth(ancho);
        botonConexiones.setOnAction(e -> ventanaPrincipal.mostrarConexiones());

        Button botonMapa;
        botonMapa = new Button("Viajar");
        botonMapa.setPrefHeight(alto * 0.25);
        botonMapa.setPrefWidth(ancho);
        botonMapa.setOnAction(e -> ventanaPrincipal.mostrarCiudades());

        Button botonEdificios;
        botonEdificios = new Button("Investigar");
        botonEdificios.setPrefHeight(alto * 0.25);
        botonEdificios.setPrefWidth(ancho);
        botonEdificios.setOnAction(e -> ventanaPrincipal.mostrarEdificios());

        Button botonCompu;
        botonCompu = new Button("Visitar Interpol");
        botonCompu.setPrefHeight(alto * 0.25);
        botonCompu.setPrefWidth(ancho);
        botonCompu.setOnAction(e -> ventanaPrincipal.mostrarComputadoraInterpol());

        getChildren().addAll(botonConexiones, botonMapa, botonEdificios, botonCompu);
    }
}

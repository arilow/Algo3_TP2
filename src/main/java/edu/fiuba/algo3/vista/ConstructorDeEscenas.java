package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Ladron;
import edu.fiuba.algo3.modelo.Nivel;
import edu.fiuba.algo3.modelo.Pista;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.List;

public class ConstructorDeEscenas {
    VentanaPrincipal ventanaPrincipal;
    Stage stage;
    Juego juego;
    int anchoVentana;
    int altoVentana;

    double anchoPantalla;
    double altoPantallaIzquierdaActual;
    double altoPantallaDerechaActual;

    Node pantallaDatos;
    Node pantallaOpciones;
    Node pantallaIzquierdaActual;
    Node pantallaDerechaActual;

    public ConstructorDeEscenas(VentanaPrincipal ventanaPrincipal, Juego juego, int anchoVentana, int altoVentana) {
        this.ventanaPrincipal = ventanaPrincipal;
        this.stage = stage;
        this.juego = juego;
        this.anchoVentana = anchoVentana;
        this.altoVentana = altoVentana;
        anchoPantalla = anchoVentana * 0.5;
        altoPantallaIzquierdaActual = altoVentana * 0.9;
        altoPantallaDerechaActual = altoVentana * 0.75;
    }

    public HBox construirPantallaInicioCiudad() {
        // Pantalla Izquierda
        System.out.println(juego.nivelActual().obtenerCiudadActual().obtenerNombre());
        System.out.println(juego.nivelActual().obtenerCiudadActual());
        System.out.println(juego.nivelActual().obtenerCiudadActual().obtenerImagen());
        pantallaIzquierdaActual = new VistaImagenCiudad(juego.nivelActual().obtenerCiudadActual(), anchoPantalla, altoPantallaIzquierdaActual);
        VBox infoFecha = construirPantallaDatos(juego.nivelActual().obtenerCiudadActual().obtenerNombre(), juego.nivelActual().obtenerFecha());
        VBox pantallaizquierda = new VBox(infoFecha, pantallaIzquierdaActual);

        // Pantalla Derecha
        pantallaDerechaActual = new VistaDescripcionCiudad(juego.nivelActual().obtenerCiudadActual().obtenerDescripcion(), anchoPantalla, altoPantallaDerechaActual);
        VBox pantallaDerecha = new VBox(pantallaDerechaActual, construirPantallaOpciones());

        return new HBox(pantallaizquierda, pantallaDerecha);
    }

    public HBox construirPantallaSeleccionEdificios() {
        // Pantalla izquierda
        pantallaIzquierdaActual = new VistaListaEdificios(juego.nivelActual(), anchoPantalla, altoPantallaIzquierdaActual);
        VBox infoFecha = construirPantallaDatos(juego.nivelActual().obtenerCiudadActual().obtenerNombre(), juego.nivelActual().obtenerFecha());
        VBox pantallaizquierda = new VBox(infoFecha, pantallaIzquierdaActual);

        // Pantalla derecha no cambia (Por ahora)
        VBox pantallaDerecha = new VBox(pantallaDerechaActual, construirPantallaOpciones());

        return new HBox(pantallaizquierda, pantallaDerecha);
    }

    public HBox construirPantallaComputadoraInterpol() {
        // Pantalla izquierda (no cambia por ahora)
        pantallaIzquierdaActual = new VistaIzquierdaComputadoraInterpol(anchoPantalla, altoPantallaIzquierdaActual);
        VBox infoFecha = construirPantallaDatos(juego.nivelActual().obtenerCiudadActual().obtenerNombre(), juego.nivelActual().obtenerFecha());
        VBox pantallaizquierda = new VBox(infoFecha, pantallaIzquierdaActual);

        // Pantalla derecha
        pantallaDerechaActual = new VistaComputadoraInterpol(juego.nivelActual(), anchoPantalla, altoPantallaDerechaActual, pantallaIzquierdaActual);
        VBox pantallaDerecha = new VBox(pantallaDerechaActual, construirPantallaOpciones());

        return new HBox(pantallaizquierda, pantallaDerecha);
    }

    public HBox construirPantallaEdificio(Pista pista) {
        //Pantalla derecha
        pantallaDerechaActual = new VistaEdificio(pista, anchoPantalla, altoPantallaDerechaActual);
        VBox infoFecha = construirPantallaDatos(juego.nivelActual().obtenerCiudadActual().obtenerNombre(), juego.nivelActual().obtenerFecha());
        VBox pantallaizquierda = new VBox(infoFecha, pantallaIzquierdaActual);

        // Pantalla Derecha no cambia (En principio)
        VBox pantallaDerecha = new VBox(pantallaDerechaActual, construirPantallaOpciones());

        return new HBox(pantallaizquierda, pantallaDerecha);
    }

    public HBox construirPantallaInterpol() {
        //Pantalla izquierda
        List<Ladron> listaSospechosos = juego.nivelActual().obtenerListaSospechosos();
        pantallaIzquierdaActual = new VistaSospechosos(listaSospechosos, anchoPantalla, altoPantallaIzquierdaActual);
        VBox infoFecha = construirPantallaDatos(juego.nivelActual().obtenerCiudadActual().obtenerNombre(), juego.nivelActual().obtenerFecha());
        VBox pantallaIzquierda = new VBox(infoFecha, pantallaIzquierdaActual);

        // Pantalla Derecha no cambia
        VBox pantallaDerecha = new VBox(pantallaDerechaActual, construirPantallaOpciones());

        return new HBox(pantallaIzquierda, pantallaDerecha);
    }

    public HBox construirPantallaRegistroJugador() {
        // Pantalla izquierda.
        pantallaIzquierdaActual = new VistaRegistroJugador(juego.partidaActual(), anchoPantalla, altoPantallaIzquierdaActual, this);
        VBox infoFecha = construirPantallaDatos("Cuartel General", "Lunes, 7hs");
        VBox pantallaizquierda = new VBox(infoFecha, pantallaIzquierdaActual);

        // Patalla derecha
        double anchoCanvas = anchoPantalla;
        double altoCanvas = altoVentana;
        Canvas canvas = new Canvas(anchoCanvas, altoCanvas);
        GraphicsContext gcD = canvas.getGraphicsContext2D();
        gcD.setFill(Color.BLACK);
        gcD.fillRect(0,0, anchoCanvas, altoCanvas);
        pantallaDerechaActual = canvas;

        VBox pantallaDerecha = new VBox(pantallaDerechaActual);

        return new HBox(pantallaizquierda, pantallaDerecha);
    }

    public HBox construirPantallaInicioNivel() {
        // Pantalla izquierda
        pantallaIzquierdaActual = new VistaExplicacionNivel(juego.nivelActual(), anchoPantalla, altoPantallaIzquierdaActual);
        // TODO:Se podria hacer un "Actualizar ciudad/ actualizar hora.
        VBox infoFecha = construirPantallaDatos(juego.nivelActual().obtenerCiudadActual().obtenerNombre(), juego.nivelActual().obtenerFecha());
        VBox pantallaizquierda = new VBox(infoFecha, pantallaIzquierdaActual);

        // Pantalla derecha actual pareciera mantenerse constante por ahora
        VBox pantallaDerecha = new VBox(pantallaDerechaActual, construirPantallaOpciones());

        return new HBox(pantallaizquierda, pantallaDerecha);
    }

    private VBox construirPantallaOpciones() {
        double altoVistaBotones = altoVentana - altoPantallaDerechaActual;
        pantallaOpciones = new VistaOpcionesJuego(ventanaPrincipal, anchoPantalla, altoVistaBotones);
        return (VBox) pantallaOpciones;
    }

    private VBox construirPantallaDatos(String ciudad, String fecha) {
        double altoVistaFecha = altoVentana - altoPantallaIzquierdaActual;
        //System.out.println(ciudad + fecha);
        pantallaDatos = new VistaDatos(ciudad, fecha, anchoPantalla, altoVistaFecha);
        return (VBox) pantallaDatos;
    }

    public HBox construirPantallaSeleccionCiudades() {
        // Pantalla izquierda
        pantallaIzquierdaActual = new VistaListaMapa(juego.nivelActual(), anchoPantalla, altoPantallaIzquierdaActual);
        VBox infoFecha = construirPantallaDatos(juego.nivelActual().obtenerCiudadActual().obtenerNombre(), juego.nivelActual().obtenerFecha());
        VBox pantallaizquierda = new VBox(infoFecha, pantallaIzquierdaActual);

        // Pantalla derecha no cambia (Por ahora)
        pantallaDerechaActual = new VistaDescripcionCiudad(juego.nivelActual().obtenerCiudadActual().obtenerDescripcion(), anchoPantalla, altoPantallaDerechaActual);
        VBox pantallaDerecha = new VBox(pantallaDerechaActual, construirPantallaOpciones());

        return new HBox(pantallaizquierda, pantallaDerecha);
    }

    public HBox construirPantallaMapa(Ciudad ciudad) {
        //Pantalla izquierda
        pantallaIzquierdaActual = new VistaMapa(ciudad, anchoPantalla, altoPantallaDerechaActual);
        VBox infoFecha = construirPantallaDatos(juego.nivelActual().obtenerCiudadActual().obtenerNombre(), juego.nivelActual().obtenerFecha());
        VBox pantallaizquierda = new VBox(infoFecha, pantallaIzquierdaActual);

        // Pantalla Derecha no cambia (En principio)
        pantallaDerechaActual = new VistaDescripcionCiudad(juego.nivelActual().obtenerCiudadActual().obtenerDescripcion(), anchoPantalla, altoPantallaDerechaActual);
        VBox pantallaDerecha = new VBox(pantallaDerechaActual, construirPantallaOpciones());

        return new HBox(pantallaizquierda, pantallaDerecha);
    }

    public HBox construirPantallaGanadorNivel() {

        //Pantalla izquierda
        VBox infoFecha = construirPantallaDatos(juego.nivelActual().obtenerCiudadActual().obtenerNombre(), juego.nivelActual().obtenerFecha());
        pantallaIzquierdaActual= new vistaLadronEncarceladoIzquierda(juego.partidaActual(),anchoPantalla,altoPantallaIzquierdaActual);
        VBox pantallaizquierda = new VBox(infoFecha, pantallaIzquierdaActual);

        // Pantalla Derecha no cambia (En principio)
        pantallaDerechaActual = new vistaLadronEncarcelado(anchoPantalla, altoPantallaDerechaActual);
        VBox pantallaDerecha = new VBox(pantallaDerechaActual, construirPantallaOpciones());

        return new HBox(pantallaizquierda, pantallaDerecha);

    }

    public HBox construirPantallaPerdedorNivel() {
        //Pantalla izquierda
        VBox infoFecha = construirPantallaDatos(juego.nivelActual().obtenerCiudadActual().obtenerNombre(), juego.nivelActual().obtenerFecha());
        pantallaIzquierdaActual= new vistaLadronEscapadoIzquierda(juego.partidaActual(),anchoPantalla,altoPantallaIzquierdaActual);
        VBox pantallaizquierda = new VBox(infoFecha, pantallaIzquierdaActual);


        pantallaDerechaActual = new vistaCarcelSinLadron(anchoPantalla, altoPantallaDerechaActual);
        VBox pantallaDerecha = new VBox(pantallaDerechaActual, construirPantallaOpciones());

        return new HBox(pantallaizquierda, pantallaDerecha);
    }

    public HBox construirPantallaPerdedorNivelPorTiempo() {
        //Pantalla izquierda
        VBox infoFecha = construirPantallaDatos(juego.nivelActual().obtenerCiudadActual().obtenerNombre(), juego.nivelActual().obtenerFecha());
        pantallaIzquierdaActual= new vistaIzquierdaPerderPorTiempo(juego.partidaActual(),anchoPantalla,altoPantallaIzquierdaActual);
        VBox pantallaizquierda = new VBox(infoFecha, pantallaIzquierdaActual);

        System.out.println("Antes de la vista CarcelSinLadron (derecha)");
        pantallaDerechaActual = new vistaCarcelSinLadron(anchoPantalla, altoPantallaDerechaActual);
        VBox pantallaDerecha = new VBox(pantallaDerechaActual, construirPantallaOpciones());

        return new HBox(pantallaizquierda, pantallaDerecha);
    }
}

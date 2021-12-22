package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.ComunicadorEstadoPartida;
import edu.fiuba.algo3.modelo.EstadoPartida;

import java.util.Observable;
import java.util.Observer;

public class OyenteEstadoPartida implements Observer {

    VentanaPrincipal ventana;
    public OyenteEstadoPartida(VentanaPrincipal ventana) {
        this.ventana = ventana;
    }

    @Override
    public void update(Observable o, Object arg) {
        EstadoPartida estadoPartida = ((ComunicadorEstadoPartida) o).obtenerEstado();

        switch (estadoPartida) {
            case EMPEZAR:
                System.out.println("EMPEZAR");
                ventana.abrirPantallaRegistroJugador();
                break;
            case COMIENZA_NIVEL:
                ventana.mostrarPantallaInicioNivel();
                System.out.println("JUGADOR_REGISTRADO");
                break;
            case ARRIBADO_A_CIUDAD_ACTUAL:
                ventana.mostrarPantallaInicioCiudad();
                System.out.println("ARRIBADO_A_CIUDAD_ACTUAL");
                break;
            case ENTRAR_A_EDIFICIO:
                ventana.mostrarPantallaEdificio();
                System.out.println("ENTRAR_A_EDIFICIO");
                break;
            case BUSCAR_SOSPECHOSOS:
                ventana.mostrarPantallaInterpol();
                System.out.println("BUSCAR_SOSPECHOSOS");
                break;
            case VIAJAR:
                ventana.mostrarPantallaMapa();
                System.out.println("VIAJAR");
                break;
            default:
                System.out.println("Ninguno");
        }
    }
}

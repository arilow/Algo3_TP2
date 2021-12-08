package edu.fiuba.algo3.modelo.objetos;

public class ObjetoMuyValioso implements ObjetoRobado {
    String nombre;
    int cantidadCiudadesEscape;

    public ObjetoMuyValioso(String nombre) {
        this.nombre = nombre;
        this.cantidadCiudadesEscape = 7;
    }

    public boolean es(String nombre) {
        return  this.nombre == nombre;
    }

    public int obtenerCantidadCiudadesEscape(){
        return cantidadCiudadesEscape;
    }
}
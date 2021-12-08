package edu.fiuba.algo3.modelo.objetos;

public class ObjetoValioso implements ObjetoRobado{
    String nombre;
    int cantidadCiudadesEscape;

    public ObjetoValioso(String nombre) {
        this.nombre = nombre;
        this.cantidadCiudadesEscape = 5;
    }

    public boolean es(String nombre) {
        return  this.nombre == nombre;
    }

    public int getCantidadCiudadesEscape(){
        return cantidadCiudadesEscape;
    }
}

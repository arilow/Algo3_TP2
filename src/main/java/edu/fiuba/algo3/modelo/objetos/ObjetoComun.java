package edu.fiuba.algo3.modelo.objetos;

public class ObjetoComun implements ObjetoRobado{
    String nombre;
    public ObjetoComun(String nombre) {
        this.nombre = nombre;
    }

    public boolean es(String nombre) {
        return  this.nombre == nombre;
    }

}

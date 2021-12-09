package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.objetos.ObjetoRobado;

public class Ladron {

    private DatosLadron datos;

    public Ladron(String sexo, String hobby, String cabello, String senia, String vehiculo){
        datos = new DatosLadron(sexo, hobby, cabello, senia, vehiculo);
    };

    public DatosLadron obtenerDatos()
    {
        return this.datos;
    }
    public String toString() // es una buena práctica que se llame toString y no "convertirACadenaCaracteres"
    {
        return datos.toString();
    }
    public boolean constatarDatos(DatosLadron datos) {
        return this.datos.constatar(datos);
    }
}

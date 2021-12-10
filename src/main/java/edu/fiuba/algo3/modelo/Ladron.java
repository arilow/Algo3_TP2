package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.objetos.ObjetoRobado;

public class Ladron {

    private DatosLadron datos;
    private Ciudad ciudadActual;
    private int edificioActual;
    private String nombreLadron;
    private boolean esLibre;

    private String nombre;
    public Ladron(String sexo, String hobby, String cabello, String senia, String vehiculo){
        datos = new DatosLadron(sexo, hobby, cabello, senia, vehiculo);
    };

    /*public Ladron(String sexo, String hobby, String cabello, String senia, String vehiculo, Ciudad ciudadActual){
        datos = new DatosLadron(sexo, hobby, cabello, senia, vehiculo);
        this.ciudadActual = ciudadActual;
        Random rand = new Random();
        rand.nextInt(4);
        this.edificioActual = rand.nextInt();
    };*/

    public Ladron(String sexo, String hobby, String cabello, String senia, String vehiculo, Ciudad ciudadActual, int edificio, String nombre){
        datos = new DatosLadron(sexo, hobby, cabello, senia, vehiculo);
        this.ciudadActual = ciudadActual;
        this.edificioActual = edificio;
        this.nombreLadron = nombre;
        this.esLibre = true;
    };

    public Ciudad obtenerCiudadActual(){
        return this.ciudadActual;
    }

    public int obtenerEdificioActual(){
        return this.edificioActual;
    }

    public String obtenerNombre(){
        return nombreLadron;
    }

    public Ladron(String nombre, String sexo, String hobby, String cabello, String senia, String vehiculo) {
        this.nombre = nombre;
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

    public boolean estaEn(String ciudad, int edificio){
        return ciudadActual.es(ciudad) && edificioActual == edificio;
    }

    public void moverserA(Ciudad ciudad, int edificio) {
        ciudadActual = ciudad;
        edificioActual = edificio;
    }

    public void arrestar(){
        this.esLibre = false;
    }

    public boolean estaLibre(){
        return this.esLibre;
    }
}

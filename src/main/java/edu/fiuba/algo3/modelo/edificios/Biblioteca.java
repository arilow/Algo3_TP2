package edu.fiuba.algo3.modelo.edificios;

public class Biblioteca implements Edificio{

    String pista;
    public String mostrarPista() {
        return pista;
    }
    public Biblioteca(String pista){
        this.pista = pista;
    }
}

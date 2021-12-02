package edu.fiuba.algo3.modelo.edificios;

public class Banco implements Edificio{
    String pista;
    public String mostrarPista() {

        return pista;
    }
    public Banco(String pista){
        this.pista = pista;
    }
}

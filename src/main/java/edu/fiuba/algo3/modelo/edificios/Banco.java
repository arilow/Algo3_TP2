package edu.fiuba.algo3.modelo.edificios;

public class Banco implements Edificio{
    String pista;
    public void mostrarPista() {
        System.out.println(pista);
    }
    public Banco(String pista){
        this.pista = pista;
    }
}

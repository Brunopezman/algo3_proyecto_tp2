package edu.fiuba.algo3.modelo;

public class Comodin {
    private int adicional;

    public Comodin(int valor) {
        this.adicional = valor;
    }

    public int modificarValor(int valor) {
        return valor + this.adicional;
    }
}

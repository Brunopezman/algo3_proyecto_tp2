package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.juego.Jugada;

import java.util.Random;

public class ComodinAleatorio extends Comodin{

    private int valorParaEjecucion;

    public ComodinAleatorio(int valorMultiplicador,int valorPuntos, estrategiaModificador estrategia) {
        this.multiplicador = valorMultiplicador;
        this.puntos = valorPuntos;
        this.estrategia = estrategia;
        //this.valorParaEjecucion = algo;
    }


    @Override
    public void aplicarEfecto(Jugada jugada) {
        Random aleatorio = new Random();
        int randomActual = aleatorio.nextInt(5);
        if(valorParaEjecucion == randomActual){ estrategia.realizarModificacion(jugada,multiplicador,puntos); }
    }
}

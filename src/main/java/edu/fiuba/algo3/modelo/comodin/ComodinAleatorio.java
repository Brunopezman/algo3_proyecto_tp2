package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.juego.Jugada;

import java.util.Random;

public class ComodinAleatorio extends Comodin{
    private Comodin comodin;
    private int valorParaEjecucion;

    public ComodinAleatorio(Comodin comodin) {
        Random aleatorio = new Random();
        this.comodin = comodin;
        //this.valorParaEjecucion = aleatorio.nextInt(5);
        this.valorParaEjecucion = 1;
    }


    @Override
    public void aplicarEfecto(Jugada jugada) {
        //Random aleatorio = new Random();
        //int randomActual = aleatorio.nextInt(5);
        //if(valorParaEjecucion == randomActual){ comodin.aplicarEfecto(jugada); }
        if(valorParaEjecucion == 1){ comodin.aplicarEfecto(jugada); }
    }
}

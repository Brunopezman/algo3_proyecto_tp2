package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.mano.Mano;

import java.util.Random;

public class ComodinAleatorio extends Comodin{

    private int probabilidad;
    private int valorParaEjecucion;

    public ComodinAleatorio(int valorMultiplicador,int valorPuntos, EstrategiaModificador estrategia, int probabilidad) {
        this.multiplicador = valorMultiplicador;
        this.puntos = valorPuntos;
        this.estrategia = estrategia;
        this.valorParaEjecucion = 0;
        this.probabilidad = probabilidad;
    }

    @Override
    public void aplicarEfecto(Mano mano) {
        Random aleatorio = new Random();
        int randomActual = aleatorio.nextInt(probabilidad);
        if(valorParaEjecucion == randomActual){ estrategia.realizarModificacion(mano,multiplicador,puntos); }
    }
}

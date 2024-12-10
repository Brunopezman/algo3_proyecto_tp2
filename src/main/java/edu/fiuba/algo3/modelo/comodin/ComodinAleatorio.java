package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.mano.Mano;

import java.util.Random;

public class ComodinAleatorio extends Comodin{

    private int probabilidad;
    private int valorParaEjecucion;

    public ComodinAleatorio(String nombre, String descripcion, int puntajeDelComodin, int multiplicadorDelComodin, EstrategiaComodin estrategia, int probabilidad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.puntos = puntajeDelComodin;
        this.multiplicador = multiplicadorDelComodin;
        this.estrategia = estrategia;
        this.valorParaEjecucion = 0;
        this.probabilidad = probabilidad;
    }

    @Override
    public void aplicarEfecto(Mano mano) {
        Random aleatorio = new Random();
        int randomActual = aleatorio.nextInt(probabilidad);
        if(valorParaEjecucion == randomActual){ estrategia.realizarModificacion(puntos, multiplicador, mano); }
    }
}

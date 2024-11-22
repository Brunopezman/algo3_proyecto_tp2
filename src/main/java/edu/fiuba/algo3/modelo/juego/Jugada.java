package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.mano.Mano;

public class Jugada {

    private final Mano mano;
    private boolean huboDescartes;
    private int puntaje;

    public Jugada(Mano mano, int cantidadDescartes, int puntaje){
        this.mano = mano;
        if(cantidadDescartes > 0){this.huboDescartes = true;}
        this.puntaje = puntaje;
    }

    public boolean seDescarto(){return this.huboDescartes;}

    public int calcularPuntaje(){ return mano.calcularPuntaje(puntaje); }

    public boolean jugoEstaMano(Mano manoRecibida) {
        return mano.esMismaMano(manoRecibida);
    }

    public void sumarMultiplicador(int multiplicador) {
        mano.sumarMultiplicador(multiplicador);
    }

    public void multiplicarMultiplicador(int multiplicador) {
        mano.multiplicarMultiplicador(multiplicador);
    }

    public void sumarPuntos(int puntos){
        mano.sumarPuntos(puntos);
    }
}

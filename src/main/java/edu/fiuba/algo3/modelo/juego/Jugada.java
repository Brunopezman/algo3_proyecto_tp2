package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.comodin.Comodin;
import edu.fiuba.algo3.modelo.comodin.ComodinDescarte;
import edu.fiuba.algo3.modelo.comodin.ComodinPuntaje;
import edu.fiuba.algo3.modelo.mano.Mano;

import java.util.List;

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

    public void modificarMultiplicadorMano(char operador, int modificador){
        int nuevoValor;
        if (operador == '+') {
            nuevoValor = mano.getMultiplicador() + modificador;
        }else {
            nuevoValor = mano.getMultiplicador() * modificador;
        }
        mano.modificarMultiplicador(nuevoValor);
    }

    public void modificarPuntajeMano(char operador, int modificador){
        int nuevoValor;
        if (operador == '+') {
            nuevoValor = mano.getPuntaje() + modificador;
        }else {
            nuevoValor = mano.getPuntaje() * modificador;
        }
        mano.modificarPuntaje(nuevoValor);
    }

    public int calcularPuntaje(){ return mano.calcularPuntaje(puntaje); }

    public boolean jugoEstaMano(Mano manoRecibida) {
        return mano.esMismaMano(manoRecibida);
    }
}

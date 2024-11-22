package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.juego.Jugada;
import edu.fiuba.algo3.modelo.mano.Mano;

public class ComodinManoEspecifica extends Comodin{

    private Mano manoQueAfecta;

    public ComodinManoEspecifica(int valorMultiplicador,int valorPuntos, EstrategiaModificador estrategia) {
        this.multiplicador = valorMultiplicador;
        this.puntos = valorPuntos;
        this.estrategia = estrategia;
    }

    @Override
    public void aplicarEfecto(Jugada jugada) {
        if(jugada.jugoEstaMano(manoQueAfecta)){
            estrategia.realizarModificacion(jugada, multiplicador, puntos);
        }
    }
}

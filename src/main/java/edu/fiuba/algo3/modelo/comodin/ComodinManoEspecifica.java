package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.mano.Mano;

public class ComodinManoEspecifica extends Comodin{

    private Mano manoQueAfecta;

    public ComodinManoEspecifica(int valorMultiplicador,int valorPuntos, estrategiaModificador estrategia) {
        this.multiplicador = valorMultiplicador;
        this.puntos = valorPuntos;
        this.estrategia = estrategia;
    }

    @Override
    public void aplicarEfecto(Mano mano) {
        if(mano.esMismaMano(manoQueAfecta)){
            estrategia.realizarModificacion(mano, multiplicador, puntos);
        }
    }
}

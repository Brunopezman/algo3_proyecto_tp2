package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.mano.Mano;

public class ComodinManoEspecifica extends Comodin{

    private String manoQueAfecta;

    public ComodinManoEspecifica(int valorMultiplicador, int valorPuntos, EstrategiaComodin estrategia, String nombreMano) {
        this.multiplicador = valorMultiplicador;
        this.puntos = valorPuntos;
        this.estrategia = estrategia;
        this.manoQueAfecta = nombreMano;
    }

    @Override
    public void aplicarEfecto(Mano mano) {
        if(mano.esMismaMano(manoQueAfecta)){
            estrategia.realizarModificacion(puntos, multiplicador, mano);
        }
    }
}

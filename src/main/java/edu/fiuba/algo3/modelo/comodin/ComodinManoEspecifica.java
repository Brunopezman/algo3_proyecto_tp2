package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.mano.Mano;

public class ComodinManoEspecifica extends Comodin{

    private String manoQueAfecta;

    public ComodinManoEspecifica(String nombre, String descripcion, int valorPuntos, int valorMultiplicador, EstrategiaComodin estrategia, String nombreMano) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.puntos = valorPuntos;
        this.multiplicador = valorMultiplicador;
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

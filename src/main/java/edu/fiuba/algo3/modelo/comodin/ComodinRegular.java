package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.mano.Mano;

public class ComodinRegular extends Comodin {

    public ComodinRegular(String nombre, String descripcion, int valorPuntos, int valorMultiplicador,EstrategiaComodin estrategia) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.puntos = valorPuntos;
        this.multiplicador = valorMultiplicador;
        this.estrategia = estrategia;
    }

    @Override
    public void aplicarEfecto(Mano mano) {
        estrategia.realizarModificacion(puntos, multiplicador, mano);
    }
}

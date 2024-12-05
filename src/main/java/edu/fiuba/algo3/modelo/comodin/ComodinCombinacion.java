package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.mano.Mano;

import java.util.List;

public class ComodinCombinacion extends Comodin{



    public ComodinCombinacion(String nombre, String descripcion, List<Comodin> internos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.comodinesInternos = internos;
    }

    @Override
    public void aplicarEfecto(Mano mano) {
        for (Comodin comodin : comodinesInternos) {
            comodin.aplicarEfecto(mano);
        }
    }
}

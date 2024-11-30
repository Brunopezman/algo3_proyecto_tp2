package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.mano.Mano;
import edu.fiuba.algo3.modelo.mano.Trio;

public abstract class Comodin {
    protected String nombre;
    protected String descripcion;
    protected int multiplicador;
    protected int  puntos;
    protected EstrategiaComodin estrategia;

    public static Comodin con (String nombre, String descripcion, String activacion, int puntajeDelComodin, int multiplicadorDelComodin){
        if (activacion.equals("Descarte")){
            return new ComodinDescarte(multiplicadorDelComodin,puntajeDelComodin,new EstrategiaSumarMultiplicar());
        }else if (activacion.equals("Siempre")){
            return new ComodinRegular(multiplicadorDelComodin,puntajeDelComodin,new EstrategiaSumarMultiplicar());
        }
        try {
            // Convertir un String numérico a int
            int probabilidad = Integer.parseInt(activacion);
            return new ComodinAleatorio(multiplicadorDelComodin,puntajeDelComodin,new EstrategiaSumarMultiplicar(), probabilidad);
        } catch (NumberFormatException e) {
            return new ComodinManoEspecifica(multiplicadorDelComodin,puntajeDelComodin, new EstrategiaSumaSuma(), activacion);
        }

    }

    public void setEstrategia(EstrategiaComodin estrategia) { this.estrategia = estrategia; }

    public abstract void aplicarEfecto(Mano mano);
}

package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.mano.Mano;
import edu.fiuba.algo3.modelo.mano.Trio;

import java.util.List;

public abstract class Comodin {
    protected String nombre;
    protected String descripcion;
    protected int multiplicador;
    protected int  puntos;
    protected EstrategiaComodin estrategia;
    protected List<Comodin> comodinesInternos;

    public static Comodin con (String nombre, String descripcion, String activacion, int puntajeDelComodin, int multiplicadorDelComodin, List<Comodin> internos) {
        if(!internos.isEmpty()){
            return new ComodinCombinacion(nombre,descripcion,internos);
        }else if (activacion.equals("Descarte")){
            return new ComodinDescarte(nombre,descripcion,puntajeDelComodin,multiplicadorDelComodin,new EstrategiaSumarMultiplicar());
        }else if (activacion.equals("Siempre")){
            return new ComodinRegular(nombre,descripcion,puntajeDelComodin,multiplicadorDelComodin,new EstrategiaSumarMultiplicar());
        }
        try {
            // Convertir un String numérico a int
            int probabilidad = Integer.parseInt(activacion);
            return new ComodinAleatorio(nombre,descripcion,puntajeDelComodin,multiplicadorDelComodin,new EstrategiaSumarMultiplicar(),probabilidad);
        } catch (NumberFormatException e) {
            return new ComodinManoEspecifica(nombre,descripcion,puntajeDelComodin,multiplicadorDelComodin,new EstrategiaSumaSuma(),activacion);
        }

    }

    public void setEstrategia(EstrategiaComodin estrategia) { this.estrategia = estrategia; }

    public abstract void aplicarEfecto(Mano mano);

    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public int getMultiplicador() { return multiplicador; }
    public int getPuntos() { return puntos; }
    public EstrategiaComodin getEstrategia() { return estrategia; }
    public List<Comodin> getComodinesInternos() { return comodinesInternos; }
}

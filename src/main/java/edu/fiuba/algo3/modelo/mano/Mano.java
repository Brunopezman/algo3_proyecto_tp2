package edu.fiuba.algo3.modelo.mano;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.comodin.Comodin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Mano {

    abstract public boolean esJugable(List<Carta> cartas);

    abstract protected void setPuntaje(int nuevoPuntaje);

    abstract protected void setMultiplicador (int nuevoMultiplicador);

    abstract public int getPuntaje();

    abstract public int getMultiplicador();

    abstract public int calcularPuntaje(int valor);


//    public Map<String, Integer> contarPorValor(List<Carta> cartas) {
//        Map<String, Integer> conteoValores = new HashMap<>();
//        for (Carta carta : cartas) {
//            String palo = carta.getValor();
//            conteoValores.put(palo, conteoValores.getOrDefault(palo, 0) + 1);
//        }
//        return conteoValores;
//    }
//    public void aplicarComodin(Comodin comodin){
//        int valorModificado = comodin.modificarValor(this.getPuntaje(),this.getMultiplicador());
//        this.setPuntaje(valorModificado);
//    }

    public void modificarPuntaje (int valor){
        this.setPuntaje(valor);
    }

    public void modificarMultiplicador(int valor){
        this.setMultiplicador(valor);
    }

}


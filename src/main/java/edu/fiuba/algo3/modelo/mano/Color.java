package edu.fiuba.algo3.modelo.mano;

import edu.fiuba.algo3.modelo.carta.Carta;

import java.util.List;
import java.util.Map;

public class Color extends Mano{
    // Constantes
    public static int PUNTAJE_INICIAL = 35;
    public static int MULTIPLICADOR_INICIAL = 4;

    public Color(){
        this.puntaje = PUNTAJE_INICIAL;
        this.multiplicador = MULTIPLICADOR_INICIAL;
        this.operador = new Operador();
    }

    @Override
    public boolean esJugable(List<Carta> cartas) {
        // Mapa para contar la cantidad de cartas por cada palo
        Map<String, Integer> conteoPalos = this.operador.contarPorPalo(cartas);
        // Verificar si alguno de los palos tiene al menos 5 cartas
        for (int cantidad : conteoPalos.values()) {
            if (cantidad >= 5) {
                return true;
            }
        }
        return false;
    }

}

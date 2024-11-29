package edu.fiuba.algo3.modelo.mano;

import edu.fiuba.algo3.modelo.carta.Carta;

import java.util.List;
import java.util.Map;

public class Poker extends Mano{
    // Constantes
    public static int PUNTAJE_INICIAL = 60;
    public static int MULTIPLICADOR_INICIAL = 7;

    public Poker(){
        this.nombre = "poker";
        this.puntaje = PUNTAJE_INICIAL;
        this.multiplicador = MULTIPLICADOR_INICIAL;
        this.operador = new Operador();
    }
    @Override
    public boolean esJugable(List<Carta> cartas) {
        // Mapa para contar la cantidad de cartas por cada valor
        Map<String, Integer> conteoValores = this.operador.contarPorValor(cartas);

        // Verificar si hay un valor con al menos 4 cartas
        for (int cantidad : conteoValores.values()) {
            if (cantidad >= 4) {
                return true;  // Se puede formar un Four of a Kind
            }
        }

        return false;
    }
}

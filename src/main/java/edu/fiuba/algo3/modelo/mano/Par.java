package edu.fiuba.algo3.modelo.mano;

import edu.fiuba.algo3.modelo.carta.Carta;

import java.util.List;
import java.util.Map;

public class Par extends Mano{
    // Constantes
    public static int PUNTAJE_INICIAL = 10;
    public static int MULTIPLICADOR_INICIAL = 2;

    public Par(){
        this.puntaje = PUNTAJE_INICIAL;
        this.multiplicador = MULTIPLICADOR_INICIAL;
        this.operador = new Operador();
    }
    @Override
    public boolean esJugable(List<Carta> cartas) {
        // Mapa para contar la cantidad de cartas por cada valor
        Map<String, Integer> conteoValores = this.operador.contarPorValor(cartas);
        // Verificar si hay al menos un valor con exactamente 2 cartas
        for (int cantidad : conteoValores.values()) {
            if (cantidad == 2) {
                return true;  // Se puede formar un par
            }
        }

        return false;
    }
}

package edu.fiuba.algo3.modelo.mano;

import edu.fiuba.algo3.modelo.carta.Carta;

import java.util.List;
import java.util.Map;

public class Trio extends Mano{
    // Constantes
    public static int PUNTAJE_INICIAL = 30;
    public static int MULTIPLICADOR_INICIAL = 3;

    public Trio() {
        this.nombre = "trio";
        this.puntaje = PUNTAJE_INICIAL;
        this.multiplicador = MULTIPLICADOR_INICIAL;
        this.operador = new Operador();
    }

    @Override
    public Mano esJugable(List<Carta> cartas) {
        // Mapa para contar la cantidad de cartas por cada valor
        Map<String, Integer> conteoValores = this.operador.contarPorValor(cartas);

        // Verificar si hay al menos un valor con exactamente 3 cartas
        for (int cantidad : conteoValores.values()) {
            if (cantidad == 3) {
                return new Trio();  // Se puede formar un Three of a Kind
            }
        }
        return null;  // No se puede formar un Three of a Kind
    }
}



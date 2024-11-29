package edu.fiuba.algo3.modelo.mano;

import edu.fiuba.algo3.modelo.carta.Carta;

import java.util.List;
import java.util.Map;

public class DoblePar extends Mano{
    // Constantes
    public static int PUNTAJE_INICIAL = 20;
    public static int MULTIPLICADOR_INICIAL = 2;

    public DoblePar() {
        this.nombre = "doble par";
        this.puntaje = PUNTAJE_INICIAL;
        this.multiplicador = MULTIPLICADOR_INICIAL;
        this.operador = new Operador();
    }

    @Override
    public boolean esJugable(List<Carta> cartas) {
        // Mapa para contar la cantidad de cartas por cada valor
        Map<String, Integer> conteoValores = this.operador.contarPorValor(cartas);
        // Contar cuántos pares tenemos
        int pares = 0;

        // Recorrer el mapa para contar los pares
        for (int cantidad : conteoValores.values()) {
            if (cantidad == 2) {
                pares++;
            }
        }

        // Si encontramos exactamente 2 pares, devolvemos true
        return pares == 2;
    }
}

package edu.fiuba.algo3.modelo.mano;

import edu.fiuba.algo3.modelo.carta.Carta;

import java.util.List;
import java.util.Map;

public class FullHouse extends Mano {
    // Constantes
    public static int PUNTAJE_INICIAL = 40;
    public static int MULTIPLICADOR_INICIAL = 4;

    public FullHouse() {
        this.nombre = "full";
        this.puntaje = PUNTAJE_INICIAL;
        this.multiplicador = MULTIPLICADOR_INICIAL;
        this.operador = new Operador();
    }

    @Override
    public Mano esJugable(List<Carta> cartas) {
        // Mapa para contar la cantidad de cartas por cada valor
        Map<String, Integer> conteoValores = this.operador.contarPorValor(cartas);

        // Variables para contar la presencia de una "triple" y un "par"
        boolean tieneTres = false;
        boolean tieneDos = false;

        // Verificar las cantidades en el mapa
        for (int cantidad : conteoValores.values()) {
            if (cantidad == 3) {
                tieneTres = true;
            } else if (cantidad == 2) {
                tieneDos = true;
            } else if (cantidad >= 5) {
                // Si tienes más de tres del mismo valor (por ejemplo, 4), esto podría ser parte de una triple
                // y un par al mismo tiempo, por lo que lo dividimos
                tieneTres = true;
                tieneDos = true;
            }
        }
        if(tieneTres && tieneDos){
            return new FullHouse();
        }
        return null;
    }
}
package edu.fiuba.algo3.modelo;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Map;

public class RoyalFlush implements Mano{
    private int puntaje;
    private int multiplicador;

    public RoyalFlush(){
        this.puntaje = 60;
        this.multiplicador = 7;
    }

    @Override
    public boolean esJugable(List<Carta> cartas) {
        Map<String, List<Carta>> cartasPorPalo = cartas.stream()
                .collect(Collectors.groupingBy(Carta::getPalo));

        for (List<Carta> cartasDelMismoPalo : cartasPorPalo.values()) {
            List<String> valoresRequeridos = List.of("10", "J", "Q", "K", "A");
            List<String> valoresEnPalo = cartasDelMismoPalo.stream()
                    .map(Carta::getValor)
                    .collect(Collectors.toList());
            if (valoresEnPalo.containsAll(valoresRequeridos)) {
                return true;
            }
        }
        return false;
    }
}

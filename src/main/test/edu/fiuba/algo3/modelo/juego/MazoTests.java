package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.carta.Carta;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MazoTests {

    @Test
    public void testUnMazoSeCreaConLaCantidadDeCartasCorrecta() {
        Mazo mazo = new Mazo();
        int cantidadCartasMazo = mazo.cartasRestantes();
        int cantidadEsperada = 52;
        assertEquals(cantidadCartasMazo, cantidadEsperada);
    }

    @Test
    public void testUnMazoDaLaCantidadDeCartasCorrecta() {
        Mazo mazo = new Mazo();
        List<Carta> cartas = mazo.darCartas(10);
        int catidadRecibida = cartas.size();
        int cantidadEsperada = 10;
        assertEquals(cantidadEsperada,catidadRecibida);
    }
}

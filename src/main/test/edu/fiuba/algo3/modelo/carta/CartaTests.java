package edu.fiuba.algo3.modelo.carta;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartaTests {

    @Test
    public void testUnaCartaSeCreaConElValorEsperado() {
        //arrange
        Carta carta = new Carta("10 de Corazones", "Corazones", "10", "Jota", 10);
        String valorEsperado = "10";
        //act
        String valorObtenido = carta.numero();
        //assert
        assertEquals(valorEsperado, valorObtenido);
    }


    @Test
    public void testUnaCartaSeCreaConElPuntajeEsperado() {
        //arrange
        Carta carta = new Carta("9 de Corazones", "Corazones", "9", "10", 9);
        int valorEsperado = 9;
        //act
        int valorObtenido = carta.puntaje();
        //assert
        assertEquals(valorEsperado, valorObtenido);
    }

    @Test
    public void testUnaCartaSeCreaConElPaloEsperado() {
        //arrange
        Carta carta = new Carta("9 de Corazones", "Corazones", "9", "10", 9);
        String valorEsperado = "Corazones";
        //act
        String valorObtenido = carta.getPalo();
        //assert
        assertEquals(valorEsperado, valorObtenido);
    }

    @Test
    public void testUnaCartaReconoceOtraCartaConsecutiva() {
        //arrange
        Carta carta = new Carta("10 de Corazones", "Corazones", "10", "Jota", 10);
        Carta carta2 = new Carta("9 de Corazones", "Corazones", "9", "10", 9);
        //act
        boolean resultado = carta.esConsecutiva(carta2);
        //assert
        assert (resultado);
    }

    @Test
    public void testUnaCartaReconoceOtraCartaNoConsecutiva() {
        //arrange
        Carta carta = new Carta("7 de Corazones", "Corazones", "7", "8", 7);
        Carta carta2 = new Carta("2 de Corazones", "Corazones", "2", "3", 2);
        //act
        boolean resultado = carta.esConsecutiva(carta2);
        //assert
        assert (!resultado);
    }

    @Test
    public void testUnaCartaReconoceOtraCartaConElMismoPalo() {
        //arrange
        Carta carta = new Carta("7 de Corazones", "Corazones", "7", "8", 7);
        Carta carta2 = new Carta("2 de Corazones", "Corazones", "2", "3", 2);
        //act
        boolean resultado = carta.tieneMismoPalo(carta2);
        //assert
        assert (resultado);
    }

    @Test
    public void testUnaCartaReconoceOtraCartaConDistintoPalo() {
        //arrange
        Carta carta = new Carta("7 de Diamantes", "Diamantes", "7", "8", 7);
        Carta carta2 = new Carta("2 de Corazones", "Corazones", "2", "3", 2);
        //act
        boolean resultado = carta.tieneMismoPalo(carta2);
        //assert
        assert (!resultado);
    }

    @Test
    public void testUnaCartaReconoceOtraCartaConElMismoValor() {
        //arrange
        Carta carta = new Carta("2 de Diamantes", "Diamantes", "2", "3", 2);
        Carta carta2 = new Carta("2 de Corazones", "Corazones", "2", "3", 2);
        //act
        boolean resultado = carta.tieneMismoNumero(carta2);
        //assert
        assert (resultado);
    }

    @Test
    public void testUnaCartaReconoceOtraCartaConDistintoValor() {
        //arrange
        Carta carta = new Carta("3 de Diamantes", "Diamantes", "3", "4", 3);
        Carta carta2 = new Carta("2 de Corazones", "Corazones", "2", "3", 2);
        //act
        boolean resultado = carta.tieneMismoNumero(carta2);
        //assert
        assert (!resultado);
    }

    @Test
    public void testUnaCartaReconoceOtraCartaIgualAElla() {
        //arrange
        Carta carta = new Carta("3 de Diamantes", "Diamantes", "3", "4", 3);
        Carta carta2 = new Carta("3 de Diamantes", "Diamantes", "3", "4", 3);
        //act
        boolean resultado = carta.esIgual(carta2.getNombre());
        //assert
        assert (resultado);
    }

    @Test
    public void testUnaCartaReconoceOtraCartaDistintaDeElla() {
        //arrange
        Carta carta = new Carta("5 de Diamantes", "Diamantes", "5", "6", 5);
        Carta carta2 = new Carta("3 de Diamantes", "Diamantes", "3", "4", 3);
        //act
        boolean resultado = carta.esIgual(carta2.getNombre());
        //assert
        assert (!resultado);
    }
}
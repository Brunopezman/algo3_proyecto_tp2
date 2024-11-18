package edu.fiuba.algo3.test_unitarios;

import edu.fiuba.algo3.modelo.carta.CartaNumerica;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartaTests {

    @Test
    public void testUnaCartaSeCreaConElValorEsperado() {
        //arrange
        CartaNumerica carta = new CartaNumerica("10","Corazones");
        String valorEsperado = "10";
        //act
        String valorObtenido = carta.getValor();
        //assert
        assertEquals(valorEsperado, valorObtenido);
    }

    @Test
    public void testUnaCartaSeCreaConElPuntajeEsperado() {
        //arrange
        CartaNumerica carta = new CartaNumerica("10","Corazones");
        int puntajeEsperado = 10;
        //act
        int puntajeObtenido = carta.getPuntaje();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void testUnaCartaSeCreaConElPaloEsperado() {
        //arrange
        CartaNumerica carta = new CartaNumerica("10","Corazones");
        String paloEsperado = "Corazones";
        //act
        String paloObtenido = carta.getPalo();
        //assert
        assertEquals(paloEsperado, paloObtenido);
    }

    //PROBAR EXCEPCIONES DE CADA UNO

    @Test
    public void testUnaCartaReconoceOtraCartaConsecutiva() {
        //arrange
        CartaNumerica carta = new CartaNumerica("10","Diamantes");
        CartaNumerica carta2 = new CartaNumerica("9","Diamantes");
        //act
        boolean resultado = carta.esConsecutiva(carta2);
        //assert
        assert(resultado);
    }

    @Test
    public void testUnaCartaReconoceOtraCartaNoConsecutiva() {
        //arrange
        CartaNumerica carta = new CartaNumerica("8","Corazones");
        CartaNumerica carta2 = new CartaNumerica("3","Corazones");
        //act
        boolean resultado = carta.esConsecutiva(carta2);
        //assert
        assert(!resultado);
    }

    @Test
    public void testUnaCartaReconoceOtraCartaConElMismoPalo() {
        //arrange
        CartaNumerica carta = new CartaNumerica("2","Corazones");
        CartaNumerica carta2 = new CartaNumerica("8","Corazones");
        //act
        boolean resultado = carta.tieneMismoPalo(carta2);
        //assert
        assert(resultado);
    }

    @Test
    public void testUnaCartaReconoceOtraCartaConDistintoPalo() {
        //arrange
        CartaNumerica carta = new CartaNumerica("2","Corazones");
        CartaNumerica carta2 = new CartaNumerica("8","Diamantes");
        //act
        boolean resultado = carta.tieneMismoPalo(carta2);
        //assert
        assert(!resultado);
    }

    @Test
    public void testUnaCartaReconoceOtraCartaConElMismoValor() {
        //arrange
        CartaNumerica carta = new CartaNumerica("2","Diamantes");
        CartaNumerica carta2 = new CartaNumerica("2","Corazones");
        //act
        boolean resultado = carta.tieneMismoValor(carta2);
        //assert
        assert(resultado);
    }

    @Test
    public void testUnaCartaReconoceOtraCartaConDistintoValor() {
        //arrange
        CartaNumerica carta = new CartaNumerica("2","Diamantes");
        CartaNumerica carta2 = new CartaNumerica("3","Corazones");
        //act
        boolean resultado = carta.tieneMismoValor(carta2);
        //assert
        assert(!resultado);
    }

    @Test
    public void testUnaCartaReconoceOtraCartaIgualAElla() {
        //arrange
        CartaNumerica carta = new CartaNumerica("2","Corazones");
        CartaNumerica carta2 = new CartaNumerica("2","Corazones");
        //act
        boolean resultado = carta.esIgual(carta2);
        //assert
        assert(carta.esIgual(carta2));
    }

    @Test
    public void testUnaCartaReconoceOtraCartaDistintaDeElla() {
        //arrange
        CartaNumerica carta = new CartaNumerica("2","Corazones");
        CartaNumerica carta2 = new CartaNumerica("3","Corazones");
        //act
        boolean resultado = carta.esIgual(carta2);
        //assert
        assert(!resultado);
    }

    //PROBAR CASOS COMBINADOS DE CARTAS NUMERICAS Y NONUMERICAS
}

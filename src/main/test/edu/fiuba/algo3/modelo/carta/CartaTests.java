package edu.fiuba.algo3.modelo.carta;

import edu.fiuba.algo3.modelo.ValorInvalidoException;
import edu.fiuba.algo3.modelo.PaloInvalidoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CartaTests {

    @Test
    public void testUnaCartaNumericaSeCreaConElValorEsperado() {
        //arrange
        CartaNumerica carta = new CartaNumerica("10","Corazones");
        String valorEsperado = "10";
        //act
        String valorObtenido = carta.getValor();
        //assert
        assertEquals(valorEsperado, valorObtenido);
    }

    @Test
    public void testUnaCartaNumericaSeCreaConElPuntajeEsperado() {
        //arrange
        CartaNumerica carta = new CartaNumerica("10","Corazones");
        int puntajeEsperado = 10;
        //act
        int puntajeObtenido = carta.getPuntaje();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void testUnaCartaNumericaSeCreaConElPaloEsperado() {
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
    public void testUnaCartaNumericaReconoceOtraCartaConsecutiva() {
        //arrange
        CartaNumerica carta = new CartaNumerica("10","Diamantes");
        CartaNumerica carta2 = new CartaNumerica("9","Diamantes");
        //act
        boolean resultado = carta.esConsecutiva(carta2);
        //assert
        assert(resultado);
    }

    @Test
    public void testUnaCartaNoNumericaReconoceUnaCartaNumericaConsecutiva() {
        //arrange
        CartaNoNumerica carta = new CartaNoNumerica("A","Diamantes");
        CartaNumerica carta2 = new CartaNumerica("2","Diamantes");
        //act
        boolean resultado = carta2.esConsecutiva(carta);
        //assert
        assert(resultado);
    }

    @Test
    public void testUnaCartaNumericaReconoceOtraCartaNoConsecutiva() {
        //arrange
        CartaNumerica carta = new CartaNumerica("8","Corazones");
        CartaNumerica carta2 = new CartaNumerica("3","Corazones");
        //act
        boolean resultado = carta.esConsecutiva(carta2);
        //assert
        assert(!resultado);
    }

    @Test
    public void testUnaCartaNoNumericaReconoceUnaCartaNumericaNoConsecutiva() {
        //arrange
        CartaNoNumerica carta = new CartaNoNumerica("A","Corazones");
        CartaNumerica carta2 = new CartaNumerica("3","Corazones");
        //act
        boolean resultado = carta.esConsecutiva(carta2);
        //assert
        assert(!resultado);
    }

    @Test
    public void testUnaCartaNumericaReconoceOtraCartaConElMismoPalo() {
        //arrange
        CartaNumerica carta = new CartaNumerica("2","Corazones");
        CartaNumerica carta2 = new CartaNumerica("8","Corazones");
        //act
        boolean resultado = carta.tieneMismoPalo(carta2);
        //assert
        assert(resultado);
    }

    @Test
    public void testUnaCartaNumericaReconoceOtraCartaConDistintoPalo() {
        //arrange
        CartaNumerica carta = new CartaNumerica("2","Corazones");
        CartaNumerica carta2 = new CartaNumerica("8","Diamantes");
        //act
        boolean resultado = carta.tieneMismoPalo(carta2);
        //assert
        assert(!resultado);
    }

    @Test
    public void testUnaCartaNumericaReconoceOtraCartaConElMismoValor() {
        //arrange
        CartaNumerica carta = new CartaNumerica("2","Diamantes");
        CartaNumerica carta2 = new CartaNumerica("2","Corazones");
        //act
        boolean resultado = carta.tieneMismoValor(carta2);
        //assert
        assert(resultado);
    }

    @Test
    public void testUnaCartaNumericaReconoceOtraCartaConDistintoValor() {
        //arrange
        CartaNumerica carta = new CartaNumerica("2","Diamantes");
        CartaNumerica carta2 = new CartaNumerica("3","Corazones");
        //act
        boolean resultado = carta.tieneMismoValor(carta2);
        //assert
        assert(!resultado);
    }

    @Test
    public void testUnaCartaNumericaReconoceOtraCartaIgualAElla() {
        //arrange
        CartaNumerica carta = new CartaNumerica("2","Corazones");
        CartaNumerica carta2 = new CartaNumerica("2","Corazones");
        //act
        boolean resultado = carta.esIgual(carta2);
        //assert
        assert(carta.esIgual(carta2));
    }

    @Test
    public void testUnaCartaNumericaReconoceOtraCartaDistintaDeElla() {
        //arrange
        CartaNumerica carta = new CartaNumerica("2", "Corazones");
        CartaNumerica carta2 = new CartaNumerica("3", "Corazones");
        //act
        boolean resultado = carta.esIgual(carta2);
        //assert
        assert (!resultado);
    }

    @Test
    public void testUnaCartaNoNumericaSeCreaConElValorEsperado() {
        //arrange
        CartaNoNumerica carta = new CartaNoNumerica("J","Corazones");
        String valorEsperado = "J";
        //act
        String valorObtenido = carta.getValor();
        //assert
        assertEquals(valorEsperado, valorObtenido);
    }

    @Test
    public void testUnaCartaNoNumericaSeCreaConElPuntajeEsperado() {
        //arrange
        CartaNoNumerica carta = new CartaNoNumerica("J","Corazones");
        int puntajeEsperado = 10;
        //act
        int puntajeObtenido = carta.getPuntaje();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void testUnaNoNumericaCartaSeCreaConElPaloEsperado() {
        //arrange
        CartaNoNumerica carta = new CartaNoNumerica("J","Corazones");
        String paloEsperado = "Corazones";
        //act
        String paloObtenido = carta.getPalo();
        //assert
        assertEquals(paloEsperado, paloObtenido);
    }

    @Test
    public void testUnaCartaNoNumericaReconoceOtraCartaConsecutivaNumerica() {
        //arrange
        CartaNoNumerica carta = new CartaNoNumerica("A","Diamantes");
        CartaNumerica carta2 = new CartaNumerica("2","Diamantes");
        //act
        boolean resultado = carta2.esConsecutiva(carta);
        //assert
        assert(resultado);
    }

    @Test
    public void testUnaCartaNoNumericaReconoceOtraCartaConsecutiva() {
        //arrange
        CartaNoNumerica carta = new CartaNoNumerica("J","Diamantes");
        CartaNoNumerica carta2 = new CartaNoNumerica("Q","Diamantes");
        //act
        boolean resultado = carta2.esConsecutiva(carta);
        //assert
        assert(resultado);
    }

    @Test
    public void testUnaCartaNoNumericaReconoceOtraCartaNoConsecutiva() {
        //arrange
        CartaNoNumerica carta = new CartaNoNumerica("J","Corazones");
        CartaNoNumerica carta2 = new CartaNoNumerica("A","Corazones");
        //act
        boolean resultado = carta.esConsecutiva(carta2);
        //assert
        assert(!resultado);
    }

    @Test
    public void testUnaCartaNoNumericaReconoceOtraCartaConElMismoPalo() {
        //arrange
        CartaNoNumerica carta = new CartaNoNumerica("A","Corazones");
        CartaNoNumerica carta2 = new CartaNoNumerica("J","Corazones");
        //act
        boolean resultado = carta.tieneMismoPalo(carta2);
        //assert
        assert(resultado);
    }

    @Test
    public void testUnaCartaNoNumericaReconoceOtraCartaConDistintoPalo() {
        //arrange
        CartaNoNumerica carta = new CartaNoNumerica("A","Corazones");
        CartaNoNumerica carta2 = new CartaNoNumerica("J","Diamantes");
        //act
        boolean resultado = carta.tieneMismoPalo(carta2);
        //assert
        assert(!resultado);
    }

    @Test
    public void testUnaCartaNoNumericaReconoceOtraCartaConElMismoValor() {
        //arrange
        CartaNoNumerica carta = new CartaNoNumerica("J","Diamantes");
        CartaNoNumerica carta2 = new CartaNoNumerica("J","Corazones");
        //act
        boolean resultado = carta.tieneMismoValor(carta2);
        //assert
        assert(resultado);
    }

    @Test
    public void testUnaCartaNoNumericaReconoceOtraCartaConDistintoValor() {
        //arrange
        CartaNoNumerica carta = new CartaNoNumerica("J","Diamantes");
        CartaNoNumerica carta2 = new CartaNoNumerica("K","Corazones");
        //act
        boolean resultado = carta.tieneMismoValor(carta2);
        //assert
        assert(!resultado);
    }

    @Test
    public void testUnaCartaNoNumericaReconoceOtraCartaIgualAElla() {
        //arrange
        CartaNoNumerica carta = new CartaNoNumerica("J","Corazones");
        CartaNoNumerica carta2 = new CartaNoNumerica("J","Corazones");
        //act
        boolean resultado = carta.esIgual(carta2);
        //assert
        assert(carta.esIgual(carta2));
    }

    @Test
    public void testUnaCartaNoNumericaReconoceOtraCartaDistintaDeElla() {
        //arrange
        CartaNoNumerica carta = new CartaNoNumerica("J","Corazones");
        CartaNoNumerica carta2 = new CartaNoNumerica("K","Corazones");
        //act
        boolean resultado = carta.esIgual(carta2);
        //assert
        assert(!resultado);
    }

    //deberian ir en una clase aparte
    @Test
    public void testUnaCartaNumericaSeCreaConUnValorInvalido() {
        assertThrows(ValorInvalidoException.class, () ->
        {new CartaNumerica("12","Corazones");});
    }

    @Test
    public void testUnaCartaNumericaSeCreaConPaloInvalido() {
        assertThrows(PaloInvalidoException.class, () ->
        {new CartaNumerica("2","Reina");});
    }

    @Test
    public void testUnaCartaNoNumericaSeCreaConUnValorInvalido() {
        assertThrows(ValorInvalidoException.class, () ->
        {new CartaNoNumerica("F","Corazones");});
    }

    @Test
    public void testUnaCartaNoNumericaSeCreaConPaloInvalido() {
        assertThrows(PaloInvalidoException.class, () ->
        {new CartaNoNumerica("J","Reina");});
    }
}

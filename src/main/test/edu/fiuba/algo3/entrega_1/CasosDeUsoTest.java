package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Mazo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasosDeUsoTest {

    @Test
    public void testJugadorPoseeCartasSuficientesParaEmpezar() {
        //arrange
        Mazo mazo = new Mazo();
        int esperado = 52;

        //act
        int obtenido = mazo.cartasRestantes();

        //assert
        assertEquals(esperado, obtenido);
    }

//    @Test
//    public void testJugadorRecibe8CartasDeMazo() {
//        "arrange"
//        Jugador jugador = new Jugador();
//        Mazo mazo = new Mazo();
//        int esperado = 8;
//
//        "act"
//        List<Carta> cartas = jugador.recibirCartas(mazo);
//        int obtenido = cartas.size();
//
//        "assert"
//        assertEquals(obtenido, esperado);
//    }

    @Test
    public void testSePuedeJugarManoDeUnMazo() {

    }

    @Test
    public void testJugarManoAplicaValorCorrespondiente() {}

    @Test
    public void testImportaOrdenDeCartas() {}

    @Test
    public void modificarCartaConTarotCambiaPuntos() {}

    @Test
    public void modificarCartaConTarotCambiarMultiplicador() {}
}

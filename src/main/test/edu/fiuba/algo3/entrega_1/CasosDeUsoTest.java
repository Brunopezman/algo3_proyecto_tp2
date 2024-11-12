package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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

    @Test
    public void testJugadorRecibe8CartasDeMazo() {
        //arrange
        Jugador jugador = new Jugador("Franco");
        Mazo mazo = new Mazo();
        int esperado = 8;
        //act
        List<Carta> obtenido = jugador.recibirCartas(mazo);
        //DESCOMENTEN SI QUIEREN PROBAR EJEMPLO QUE FUNCIONA
        //Carta ejemplo = obtenido.get(0);
        //System.out.printf("Carta 0 => Palo: %s Valor: %s Puntaje: %d", ejemplo.getPalo(), ejemplo.getValor(), ejemplo.getPuntaje());
        //assert
        assertEquals(esperado, obtenido.size());
    }

    @Test
    public void testSePuedeJugarManoDeUnMazo() {
        //arrange
        Jugador jugador = new Jugador("Bruno");
        Mazo mazo = new Mazo();
        Turno turno = new Turno();
        //act
        List<Carta> cartas = jugador.recibirCartas(mazo);
        boolean respuesta = turno.existeManoJugable(cartas);
        //assert
        assert(respuesta);
    }

    @Test
    public void testJugarManoAplicaValorCorrespondiente() {

        Jugador jugador = new Jugador("Migliore");
        List<Carta> cartas = new ArrayList();
        Flush flush = new Flush();
        Carta carta1 = new Carta("2", "picas");
        Carta carta2 = new Carta("3", "picas");
        Carta carta3 = new Carta("4", "picas");
        Carta carta4 = new Carta("5", "picas");
        Carta carta5 = new Carta("6", "picas");
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        int esperado = 220;
        //act
        int obtenido = jugador.jugarMano(cartas, flush);
        //assert
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testImportaOrdenDeCartas() {
        Jugador jugador = new Jugador("Migliore");
        Comodin comodin = new Comodin();
        List<Carta> cartas = new ArrayList();
        Flush flush = new Flush();
        Carta carta1 = new Carta("2", "picas");
        Carta carta2 = new Carta("3", "picas");
        Carta carta3 = new Carta("4", "picas");
        Carta carta4 = new Carta("5", "picas");
        Carta carta5 = new Carta("6", "picas");
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        int esperado = 220;
        //act
        int obtenido = jugador.jugarMano(cartas, flush);
        //assert
        assertEquals(esperado, obtenido);
    }

    @Test
    public void modificarCartaConTarotCambiaPuntos() {}

    @Test
    public void modificarCartaConTarotCambiarMultiplicador() {}
}

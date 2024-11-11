package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Mazo;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Carta;
import edu.fiuba.algo3.modelo.Turno;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;


public class CasosDeUsoTest {

    @Test
    public void testJugadorPoseeCartasSuficientesParaEmpezar() {
        //arrange
        Mazo mazo = new Mazo();
        int esperado = 52;
        int obtenido;
        //act
        obtenido = mazo.cartasRestantes();
        //assert
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testJugadorRecibe8CartasDeMazo() {
        //arrange
        Jugador jugador = new Jugador("Franco");
        Mazo mazo = new Mazo();
        int esperado = 8;
        List<Carta> obtenido;
        //act
        obtenido = jugador.recibirCartas(mazo);
        // DESCOMENTEN SI QUIEREN PROBAR EJEMPLO QUE FUNCIONA
        // Carta ejemplo = obtenido.get(0);
        // System.out.printf("Carta 0 => Palo: %s Valor: %s Puntaje: %d", ejemplo.getPalo(), ejemplo.getValor(), ejemplo.getPuntaje());
        //assert
        assertEquals(esperado, obtenido.size());
    }

    @Test
    public void testSePuedeJugarManoDeUnMazo() {
        //arrange
        Jugador jugador = new Jugador("Bruno");
        Mazo mazo = new Mazo();
        Turno turno = new Turno();
        boolean respuesta;
        List<Carta> cartas;
        //act
        cartas = jugador.recibirCartas(mazo);
        respuesta = turno.existeManoJugable(cartas);
        //assert
        assert(respuesta);
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

package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.mano.Mano;
import edu.fiuba.algo3.vistas.pantalla.PantallaFinal;
import edu.fiuba.algo3.vistas.pantalla.ParteDerecha;
import edu.fiuba.algo3.vistas.pantalla.ParteIzquierda;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.nio.file.Paths;
import java.util.List;

import static edu.fiuba.algo3.vistas.pantalla.PantallaFinal.mostrarPantallaFinal;

public class BotonJugarManoHandler implements EventHandler<ActionEvent> {
    private static final String MENSAJE_GANASTE = "GANASTE";
    private static final String MENSAJE_PERDISTE = "PERDISTE";
    private final Juego juego;
    private final List<Carta> cartasSeleccionadas;
    private final ParteIzquierda parteIzquierda;
    private Text cartasRestantesText;

    public BotonJugarManoHandler(Juego juego, List<Carta> cartasSeleccionadas, ParteIzquierda parteIzquierda, Text cartasRestantesText) {
        this.juego = juego;
        this.cartasSeleccionadas = cartasSeleccionadas;
        this.parteIzquierda = parteIzquierda;
        this.cartasRestantesText = cartasRestantesText;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (cartasSeleccionadas.size() == 5) {
            Mano mano = juego.queManoEs(cartasSeleccionadas); // Se debe almacenar dado que se lo pasaremos por parametro a parteIzquierda.actualizar() para que pueda actualizar tambien el bloque que muestra que Mano es junto con su respectivo multiplicador.
            juego.jugarMano(cartasSeleccionadas, mano);
            if (juego.avanzarTurno()){
                juego.quitarCartasUsadas(cartasSeleccionadas);
                juego.repartirCartasJugador(cartasSeleccionadas.size());
            }else{
                if (juego.avanzarRonda()){
                    juego.eliminarTodasLasCartas();
                    juego.repartirCartasParaIniciar();
                }else{
                    String mensajeFinal;
                    if (juego.seGanoPartida()) {
                        mensajeFinal = MENSAJE_GANASTE;
                    } else {
                        mensajeFinal = MENSAJE_PERDISTE;
                    }
                    mostrarPantallaFinal(mensajeFinal);
                }
            }
            parteIzquierda.cuadroParaManoPorJugar("","0","0");
            cartasSeleccionadas.clear();
            parteIzquierda.actualizar();
            ParteDerecha.actualizarVisualMazo();
            ParteDerecha.actualizarVisualCartas(cartasSeleccionadas);
        } else {
            System.out.println("No has seleccionado ninguna carta.");
        }
    }

}

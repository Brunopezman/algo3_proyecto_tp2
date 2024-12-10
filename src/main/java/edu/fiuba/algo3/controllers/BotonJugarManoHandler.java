package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.mano.Mano;
import edu.fiuba.algo3.vistas.pantalla.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.util.List;

public class BotonJugarManoHandler implements EventHandler<ActionEvent> {
    private static final String MENSAJE_GANASTE = "GANASTE";
    private static final String MENSAJE_PERDISTE = "PERDISTE";

    private final Juego juego;
    private final List<Carta> cartasSeleccionadas;
    private final ParteIzquierda parteIzquierda;
    private Text cartasRestantesText;
    private final Label mensajeTemporal;

    public BotonJugarManoHandler(Juego juego, List<Carta> cartasSeleccionadas, ParteIzquierda parteIzquierda, Text cartasRestantesText, Label mensajeTemporal) {
        this.juego = juego;
        this.cartasSeleccionadas = cartasSeleccionadas;
        this.parteIzquierda = parteIzquierda;
        this.cartasRestantesText = cartasRestantesText;
        this.mensajeTemporal = mensajeTemporal;
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
                    PantallaTienda.mostrarTienda();
                }else{
                    if (juego.seGanoPartida()) {
                        PantallaFinal.mostrarPantallaFinal(MENSAJE_GANASTE);
                    } else {
                        PantallaFinal.mostrarPantallaFinal(MENSAJE_PERDISTE);
                    }
                }
            }
            parteIzquierda.cuadroParaManoPorJugar("","0","0");
            cartasSeleccionadas.clear();
            parteIzquierda.actualizar();
            ParteDerecha.actualizarVisualMazo();
            ParteDerecha.actualizarVisualCartas(cartasSeleccionadas);
        } else {
            mostrarMensajeTemporal("No has seleccionado cartas suficientes para jugar una mano.");
        }
    }

    private void mostrarMensajeTemporal(String mensaje) {
        mensajeTemporal.setText(mensaje);
        mensajeTemporal.setVisible(true);

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> mensajeTemporal.setVisible(false)));
        timeline.setCycleCount(1);
        timeline.play();
    }
}

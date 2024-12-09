package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.vistas.pantalla.ParteDerecha;
import edu.fiuba.algo3.vistas.pantalla.ParteIzquierda;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.util.List;

public class BotonDescartarHandler implements EventHandler<ActionEvent> {

    private final Juego juego;
    private List<Carta> cartasSeleccionadas;
    private final ParteIzquierda parteIzquierda;
    private Text cartasRestantesText;
    private final Label mensajeTemporal;

    public BotonDescartarHandler(Juego juego, List<Carta> cartasSeleccionadas, ParteIzquierda parteIzquierda, Text cartasRestantesText, Label mensajeTemporal) {
        this.juego = juego;
        this.cartasSeleccionadas = cartasSeleccionadas;
        this.parteIzquierda = parteIzquierda;
        this.cartasRestantesText = cartasRestantesText;
        this.mensajeTemporal = mensajeTemporal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (!cartasSeleccionadas.isEmpty()) {
            List<Carta> nuevas = juego.descartarCartas(cartasSeleccionadas);
            if (nuevas.isEmpty()) {
                mostrarMensajeTemporal("No te quedan descartes!!!");
            }else {
                cartasSeleccionadas.clear();
                parteIzquierda.actualizar();
                ParteDerecha.actualizarVisualCartas(cartasSeleccionadas);
            }
            ParteDerecha.actualizarVisualMazo();
            ParteDerecha.actualizarVisualCartas(cartasSeleccionadas);
        } else {
            mostrarMensajeTemporal("No has seleccionado ninguna carta.");
        }
    }

    public void mostrarMensajeTemporal(String mensaje) {
        mensajeTemporal.setText(mensaje);
        mensajeTemporal.setVisible(true);

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> mensajeTemporal.setVisible(false)));
        timeline.setCycleCount(1);
        timeline.play();
    }
}

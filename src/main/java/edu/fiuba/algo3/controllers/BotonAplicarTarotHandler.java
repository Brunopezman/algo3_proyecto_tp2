package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.juego.Ronda;
import edu.fiuba.algo3.modelo.tarot.Tarot;
import edu.fiuba.algo3.vistas.pantalla.ParteDerecha;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.util.List;

public class BotonAplicarTarotHandler implements EventHandler<ActionEvent> {

    private final List<Tarot> tarots;
    private final Label mensajeTemporal;

    public BotonAplicarTarotHandler(List<Tarot> tarots, Label mensajeTemporal){
        this.tarots = tarots;
        this.mensajeTemporal = mensajeTemporal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        if (tarots.size() == 1){
            Tarot tarot = tarots.get(0);
            Juego juego = Juego.getInstance();
            Ronda rondaActual = juego.getRondaActual();
            rondaActual.usarTarotEnEsteTurno(tarot);
            mostrarMensajeTemporal("Use un tarot");
            ParteDerecha.actualizarVisualTarot();
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

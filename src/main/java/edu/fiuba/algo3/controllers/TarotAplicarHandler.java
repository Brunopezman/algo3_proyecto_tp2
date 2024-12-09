package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.tarot.Tarot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.util.List;

public class TarotAplicarHandler implements EventHandler<ActionEvent> {

    private final List<Tarot> tarotSeleccionados;
    private final Tarot tarot;
    private final ImageView imagenCarta;
    private final Label mensajeTemporal;

    public TarotAplicarHandler(List<Tarot> tarotSeleccionados, Tarot tarot, ImageView imagenCarta, Label mensajeTemporal) {
        this.tarotSeleccionados = tarotSeleccionados;
        this.tarot = tarot;
        this.imagenCarta = imagenCarta;
        this.mensajeTemporal = mensajeTemporal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (tarotSeleccionados.contains(tarot)) {
            tarotSeleccionados.remove(tarot);
            imagenCarta.setStyle("");
        }else if(tarotSeleccionados.isEmpty()){
            tarotSeleccionados.add(tarot);
            imagenCarta.setStyle("-fx-effect: dropshadow(gaussian, blue, 10, 0.5, 0, 0);");
        }else{
            mostrarMensajeTemporal("Solo un tarot puede ser seleccionado para usarse!!!");
        }
        System.out.println(tarotSeleccionados.size());
    }

    private void mostrarMensajeTemporal(String mensaje) {
        mensajeTemporal.setText(mensaje);
        mensajeTemporal.setVisible(true);

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> mensajeTemporal.setVisible(false)));
        timeline.setCycleCount(1); // Solo ejecutar una vez
        timeline.play();
    }
}

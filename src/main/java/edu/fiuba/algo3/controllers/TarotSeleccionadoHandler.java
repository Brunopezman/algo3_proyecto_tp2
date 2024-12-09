package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.tarot.Tarot;
import edu.fiuba.algo3.vistas.pantalla.PantallaTienda;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.util.List;

public class TarotSeleccionadoHandler implements EventHandler<ActionEvent> {

    private final Tarot tarot;
    private final ImageView cartaView;
    private List<Tarot> tarotsSeleccionados;
    private final AudioClip sonido;
    private final Label mensajeTemporal;

    public TarotSeleccionadoHandler(Tarot tarot, ImageView cartaView, AudioClip sonido, List<Tarot> tarotsSeleccionados, Label mensajeTemporal) {
        this.tarot = tarot;
        this.cartaView = cartaView;
        this.sonido = sonido;
        this.tarotsSeleccionados = tarotsSeleccionados;
        this.mensajeTemporal = mensajeTemporal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (tarotsSeleccionados.contains(tarot)) {
            tarotsSeleccionados.remove(tarot); //sacar efecto azul
            cartaView.setStyle("");
            PantallaTienda.reducirContador();
        } else if(PantallaTienda.sePuedeSeguirEligiendo()){
            tarotsSeleccionados.add(tarot); //poner efecto azul
            sonido.play();
            cartaView.setStyle("-fx-effect: dropshadow(gaussian, blue, 15, 0.8, 0, 0);");
            PantallaTienda.aumentarContador();
        } else {
            mostrarMensajeTemporal("No se puede seleccionar una tarot, ya seleccionaste 3 de las opciones de la tienda!");
        }
    }

    private void mostrarMensajeTemporal(String mensaje) {
        mensajeTemporal.setText(mensaje);
        mensajeTemporal.setVisible(true);

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> mensajeTemporal.setVisible(false)));
        timeline.setCycleCount(1); // Solo ejecutar una vez
        timeline.play();
    }
}


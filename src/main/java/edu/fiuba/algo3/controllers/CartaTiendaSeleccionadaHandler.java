package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.carta.Carta;
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

public class CartaTiendaSeleccionadaHandler implements EventHandler<ActionEvent> {

    private final Carta carta;
    private final ImageView cartaView;
    private List<Carta> cartasEspecificas;
    private final AudioClip sonido;
    private final Label mensajeTemporal;

    public CartaTiendaSeleccionadaHandler(Carta carta, ImageView cartaView, AudioClip sonido, List<Carta> cartasEspecificas, Label mensajeTemporal) {
        this.carta = carta;
        this.cartaView = cartaView;
        this.sonido = sonido;
        this.cartasEspecificas = cartasEspecificas;
        this.mensajeTemporal = mensajeTemporal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (cartasEspecificas.contains(carta)) {
            cartasEspecificas.remove(carta); //sacar efecto azul
            cartaView.setStyle("");
            PantallaTienda.reducirContador();
        } else if (PantallaTienda.sePuedeSeguirEligiendo()) {
            cartasEspecificas.add(carta); //poner efecto azul
            sonido.play();
            cartaView.setStyle("-fx-effect: dropshadow(gaussian, blue, 15, 0.8, 0, 0);");
            PantallaTienda.aumentarContador();
        }else {
            mostrarMensajeTemporal("No se puede seleccionar una carta, ya seleccionaste 3 de las opciones de la tienda!");
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
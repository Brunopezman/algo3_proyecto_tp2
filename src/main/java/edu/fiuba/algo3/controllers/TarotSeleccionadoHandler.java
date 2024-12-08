package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.comodin.Comodin;
import edu.fiuba.algo3.modelo.tarot.Tarot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class TarotSeleccionadoHandler {

    private final Tarot tarot;
    private final ImageView cartaView;
    private final AudioClip sonido;
    private boolean estaSeleccionado = false;

    public TarotSeleccionadoHandler(Tarot tarot, ImageView cartaView, AudioClip sonido) {
        this.tarot = tarot;
        this.cartaView = cartaView;
        this.sonido = sonido;
    }

    public void handle(MouseEvent event) {
        // Reproducir el sonido de clic
        sonido.play();

        if (estaSeleccionado) {
            // Deseleccionar: quitar el efecto azul
            cartaView.setStyle("");
        } else {
            // Seleccionar: añadir efecto azul
            cartaView.setStyle("-fx-effect: dropshadow(gaussian, blue, 15, 0.8, 0, 0);");
        }

        // Cambiar el estado de selección
        estaSeleccionado = !estaSeleccionado;
    }
}



/**
public class TarotSeleccionadoHandler implements EventHandler<ActionEvent> {

    private final List<Tarot> tarotsSeleccionados;
    private final ImageView imagenCarta;
    private final AudioClip sonido;

    public TarotSeleccionadoHandler(List<Tarot> tarotsSeleccionados, ImageView imagenTarot, AudioClip sonido) {
        this.tarotsSeleccionados = tarotsSeleccionados;
        this.imagenCarta = imagenTarot;
        this.sonido = sonido;
    }
    @Override
    public void handle(ActionEvent actionEvent) {

    }
}
*/
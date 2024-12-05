package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.carta.Carta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;

import java.util.List;

public class CartaSeleccionadaHandler implements EventHandler<ActionEvent> {
    private final List<Carta> cartasSeleccionadas;
    private final Carta carta;
    private final ImageView imagenCarta;
    private final AudioClip sonido;

    public CartaSeleccionadaHandler(List<Carta> cartasSeleccionadas, Carta carta, ImageView imagenCarta, AudioClip sonido) {
        this.cartasSeleccionadas = cartasSeleccionadas;
        this.carta = carta;
        this.imagenCarta = imagenCarta;
        this.sonido = sonido;
    }

    @Override
    public void handle(ActionEvent event) {
        if (cartasSeleccionadas.contains(carta)) {
            // Deseleccionar carta
            cartasSeleccionadas.remove(carta);
            imagenCarta.setStyle("-fx-effect: null;");
        } else if (cartasSeleccionadas.size() < 5) {
            // Seleccionar carta
            cartasSeleccionadas.add(carta);
            imagenCarta.setStyle("-fx-effect: dropshadow(gaussian, blue, 10, 0.5, 0, 0);");
            sonido.play();
        } else {
            System.out.println("No puedes seleccionar más de 5 cartas.");
        }
    }
}

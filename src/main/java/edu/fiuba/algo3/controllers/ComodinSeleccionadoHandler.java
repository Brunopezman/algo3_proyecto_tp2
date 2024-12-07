package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.comodin.Comodin;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class ComodinSeleccionadoHandler {

    private final int posicion;
    private final ImageView cartaView;
    private final AudioClip sonido;
    private boolean estaSeleccionado = false;

    public ComodinSeleccionadoHandler(int posicion, ImageView cartaView, AudioClip sonido) {
        this.posicion = posicion;
        this.cartaView = cartaView;
        this.sonido = sonido;
    }

    public void handle(MouseEvent event) {
        System.out.println("Comodín en posición " + posicion + (estaSeleccionado ? " deseleccionado" : " seleccionado"));
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
public class ComodinSeleccionadoHandler implements EventHandler<ActionEvent> {

    private final List<Comodin> comodinesSeleccionados;
    private final ImageView imagenCarta;
    private final AudioClip sonido;

    public ComodinSeleccionadoHandler(List<Comodin> comodinesSeleccionados, ImageView imagenComodin, AudioClip sonido) {
        this.comodinesSeleccionados = comodinesSeleccionados;
        this.imagenCarta = imagenComodin;
        this.sonido = sonido;
    }
    @Override
    public void handle(ActionEvent actionEvent) {

    }
}
*/
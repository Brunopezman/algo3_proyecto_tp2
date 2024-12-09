package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.vistas.pantalla.PantallaTienda;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;

import java.util.List;

public class CartaTiendaSeleccionadaHandler implements EventHandler<ActionEvent> {

    private final Carta carta;
    private final ImageView cartaView;
    private final AudioClip sonido;
    private List<Carta> cartasEspecificas;

    public CartaTiendaSeleccionadaHandler(Carta carta, List<Carta> cartasEspecificas, ImageView cartaView, AudioClip sonido) {
        this.carta = carta;
        this.cartaView = cartaView;
        this.sonido = sonido;
        this.cartasEspecificas = cartasEspecificas;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        // Reproducir el sonido de clic
        sonido.play();

        if (cartasEspecificas.contains(carta)) {
            // Deseleccionar: quitar el efecto azul
            cartasEspecificas.remove(carta);
            cartaView.setStyle("");
            PantallaTienda.reducirContador();
        } else if (!PantallaTienda.sePuedeSeguirEligiendo()) {
            System.out.println("No se puede seleccionar una carta, ya seleccionaste 3 de las opciones de la tienda!");
        }else {
            // Seleccionar: añadir efecto azul
            cartaView.setStyle("-fx-effect: dropshadow(gaussian, blue, 15, 0.8, 0, 0);");
            cartasEspecificas.add(carta);
            PantallaTienda.aumentarContador();
        }
    }
}
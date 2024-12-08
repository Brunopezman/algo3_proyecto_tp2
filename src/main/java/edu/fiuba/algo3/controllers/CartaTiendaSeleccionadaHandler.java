package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.carta.Carta;
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
    private boolean estaSeleccionada = false;
    private int contador;

    public CartaTiendaSeleccionadaHandler(Carta carta, List<Carta> cartasEspecificas, ImageView cartaView, AudioClip sonido) {
        this.carta = carta;
        this.cartaView = cartaView;
        this.sonido = sonido;
        this.cartasEspecificas = cartasEspecificas;
        this.contador = contador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        // Reproducir el sonido de clic
        sonido.play();

        if (estaSeleccionada) {
            // Deseleccionar: quitar el efecto azul
            cartasEspecificas.remove(carta);
            cartaView.setStyle("");
        } else {
            // Seleccionar: añadir efecto azul
            cartaView.setStyle("-fx-effect: dropshadow(gaussian, blue, 15, 0.8, 0, 0);");
            cartasEspecificas.add(carta);
        }

        // Cambiar el estado de selección
        estaSeleccionada = !estaSeleccionada;

        // Log de selección/deselección (opcional para depuración)
        System.out.println((estaSeleccionada ? "Seleccionada: " : "Deseleccionada: ") + carta.getNombre());
    }

}
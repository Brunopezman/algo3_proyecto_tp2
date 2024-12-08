package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.comodin.Comodin;
import edu.fiuba.algo3.vistas.pantalla.ParteDerecha;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class ComodinSeleccionadoHandler {

    private final ImageView cartaView;
    private final ParteDerecha parteDerecha;
    private final List<Comodin> comodinesSeleccionados;
    private final Comodin comodin;
    private boolean estaSeleccionado = false;

    public ComodinSeleccionadoHandler(Comodin comodin, ImageView cartaView, Image cartaImagen, AudioClip sonidoClick, List<Comodin> comodinesSeleccionados, ParteDerecha parteDerecha) {
        this.comodin = comodin;
        this.cartaView = cartaView;
        this.parteDerecha = parteDerecha;
        this.comodinesSeleccionados = comodinesSeleccionados;
    }

    public void handle(MouseEvent event) {

        if (estaSeleccionado) {
            // Deseleccionar: quitar el efecto azul
            comodinesSeleccionados.remove(comodin);
            cartaView.setStyle("");
        } else {
            // Seleccionar: añadir efecto azul
            if (!comodinesSeleccionados.contains(comodin)) {
                comodinesSeleccionados.add(comodin);
                cartaView.setStyle("-fx-effect: dropshadow(gaussian, blue, 15, 0.8, 0, 0);");
            }
        }

        // Actualizar la parte derecha solo si se ha realizado una selección
        if (!comodinesSeleccionados.isEmpty()) {
            parteDerecha.actualizar(comodinesSeleccionados);
        }

        // Cambiar el estado de selección
        estaSeleccionado = !estaSeleccionado;
    }
}

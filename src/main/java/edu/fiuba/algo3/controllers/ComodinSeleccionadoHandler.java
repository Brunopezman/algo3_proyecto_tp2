package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.comodin.Comodin;
import edu.fiuba.algo3.vistas.pantalla.ParteDerecha;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class ComodinSeleccionadoHandler {

    private  ImageView cartaView;
    private  ParteDerecha parteDerecha;
    private  List<Comodin> comodinesSeleccionados;
    private Comodin comodin;
    private boolean estaSeleccionado = false;

    public ComodinSeleccionadoHandler(String s, ImageView cartaView, Image cartaImagen, AudioClip sonidoClick, List<Comodin> comodinesSeleccionados, ParteDerecha parteDerecha) {
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
            comodinesSeleccionados.add(comodin);
            cartaView.setStyle("-fx-effect: dropshadow(gaussian, blue, 15, 0.8, 0, 0);");

            comodinesSeleccionados.clear();
            parteDerecha.actualizar(comodinesSeleccionados);
        }

        // Cambiar el estado de selección
        estaSeleccionado = !estaSeleccionado;
    }

}
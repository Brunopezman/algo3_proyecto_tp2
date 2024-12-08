package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.comodin.Comodin;
import edu.fiuba.algo3.vistas.pantalla.ParteDerecha;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;

import java.util.List;

public class ComodinSeleccionadoHandler implements EventHandler<ActionEvent> {

    private final ImageView cartaView;
    private final ParteDerecha parteDerecha;
    private final List<Comodin> comodinesSeleccionados;
    private final Comodin comodin;
    private int contador;
    private boolean estaSeleccionado = false;

    public ComodinSeleccionadoHandler(int contador, Comodin comodin, ImageView cartaView, Image cartaImagen, AudioClip sonidoClick, List<Comodin> comodinesSeleccionados, ParteDerecha parteDerecha) {
        this.comodin = comodin;
        this.cartaView = cartaView;
        this.parteDerecha = parteDerecha;
        this.comodinesSeleccionados = comodinesSeleccionados;
        this.contador = contador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println(comodinesSeleccionados.size());
        if (comodinesSeleccionados.contains(comodin)) {
            // Deseleccionar: quitar el efecto azul
            comodinesSeleccionados.remove(comodin);
        } else if (contador < 3) {
            comodinesSeleccionados.add(comodin);
            cartaView.setStyle("-fx-effect: dropshadow(gaussian, blue, 15, 0.8, 0, 0);");
            contador++;
        }
        //Actualizar la parte derecha solo si se ha realizado una selección
        if (!comodinesSeleccionados.isEmpty()) {
            parteDerecha.actualizarComodines(comodinesSeleccionados);
        }

    }
}

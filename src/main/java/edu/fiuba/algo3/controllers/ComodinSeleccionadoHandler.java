package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.comodin.Comodin;
import edu.fiuba.algo3.vistas.pantalla.PantallaTienda;
import edu.fiuba.algo3.vistas.pantalla.ParteDerecha;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;

import java.util.List;

public class ComodinSeleccionadoHandler implements EventHandler<ActionEvent> {

    private final ImageView cartaView;
    private final List<Comodin> comodinesSeleccionados;
    private final Comodin comodin;
    private final AudioClip sonido;

    public ComodinSeleccionadoHandler(Comodin comodin, ImageView cartaView, AudioClip sonidoClick, List<Comodin> comodinesSeleccionados) {
        this.comodin = comodin;
        this.cartaView = cartaView;
        this.sonido = sonidoClick;
        this.comodinesSeleccionados = comodinesSeleccionados;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        //System.out.println(comodinesSeleccionados.size());
        if (comodinesSeleccionados.contains(comodin)) {
            // Deseleccionar: quitar el efecto azul
            comodinesSeleccionados.remove(comodin);
            cartaView.setStyle("");
            PantallaTienda.reducirContador();
        } else if (PantallaTienda.sePuedeSeguirEligiendo()) {
            comodinesSeleccionados.add(comodin);
            sonido.play();
            cartaView.setStyle("-fx-effect: dropshadow(gaussian, blue, 15, 0.8, 0, 0);");
            PantallaTienda.aumentarContador();

        }else{
            System.out.println("No se puede seleccionar un comodin, ya seleccionaste 3 de las opciones de la tienda!");
        }
        //Actualizar la parte derecha solo si se ha realizado una selección
        /*
        if (!comodinesSeleccionados.isEmpty()) {
            parteDerecha.actualizarComodines(comodinesSeleccionados);
        }
        */

    }
}

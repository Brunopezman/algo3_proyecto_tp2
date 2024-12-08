package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.comodin.Comodin;
import edu.fiuba.algo3.modelo.tarot.Tarot;
import edu.fiuba.algo3.vistas.pantalla.PantallaTienda;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class TarotSeleccionadoHandler implements EventHandler<ActionEvent> {

    private final Tarot tarot;
    private final ImageView cartaView;
    private final AudioClip sonido;
    private List<Tarot> tarotsSeleccionados;
    //private boolean estaSeleccionado = false;

    public TarotSeleccionadoHandler( Tarot tarot, List<Tarot> tarotsSeleccionados, ImageView cartaView, AudioClip sonido) {
        this.tarot = tarot;
        this.cartaView = cartaView;
        this.sonido = sonido;
        this.tarotsSeleccionados = tarotsSeleccionados;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        // Reproducir el sonido de clic
        sonido.play();

        if (tarotsSeleccionados.contains(tarot)) {
            tarotsSeleccionados.remove(tarot);
            // Deseleccionar: quitar el efecto azul
            cartaView.setStyle("");
            PantallaTienda.reducirContador();
        } else if(PantallaTienda.sePuedeSeguirEligiendo()){
            tarotsSeleccionados.add(tarot);
            // Seleccionar: añadir efecto azul
            sonido.play();
            cartaView.setStyle("-fx-effect: dropshadow(gaussian, blue, 15, 0.8, 0, 0);");
            PantallaTienda.aumentarContador();
        } else {
            System.out.println("No se puede seleccionar una tarot, ya seleccionaste 3 de las opciones de la tienda!");
        }

        // Cambiar el estado de selección
        //estaSeleccionado = !estaSeleccionado;
    }
}


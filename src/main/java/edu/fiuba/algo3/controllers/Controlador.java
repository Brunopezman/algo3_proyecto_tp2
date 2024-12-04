package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.vistas.pantalla.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controlador {

    private final Juego juego;
    private static Controlador controlador;
    private final Stage stage;

    public Controlador() {
        this.juego = Juego.getInstance();
        this.stage = VistaBalatro.getInstance(null).getStage();
    }

    public static Controlador getInstance() {
        if (controlador == null) {
            controlador = new Controlador();
        }
        return controlador;
    }

    /**
     * Inicia el flujo del juego mostrando la pantalla inicial.
     */
    public void iniciar() {
        mostrarPantallaInicial();
    }

    /**
     * Muestra la pantalla inicial del juego.
     */
    public void mostrarPantallaInicial() {
        EventoPantallaInicial eventosPantallaInicial = new EventoPantallaInicial();
        PantallaInicial pantallaInicial = new PantallaInicial(eventosPantallaInicial);
        Scene escenaInicial = new Scene(pantallaInicial.getRoot(), 800, 600);
        stage.setScene(escenaInicial);
    }
}





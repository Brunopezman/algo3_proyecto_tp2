package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.vistas.pantalla.PantallaJuego;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class BotonConfirmarHandler implements EventHandler<ActionEvent>{

    private final TextField campoNombre;
    private final Text textoIngreseNombre;
    private Stage stage;

    public BotonConfirmarHandler(Stage stage, TextField campoNombre, Text textoIngreseNombre) {
        this.stage = stage;
        this.campoNombre = campoNombre;
        this.textoIngreseNombre = textoIngreseNombre;
    }

    @Override
    public void handle(ActionEvent event) {

        String nombreIngresado = campoNombre.getText().trim();
        if (nombreIngresado.isEmpty()) {
            textoIngreseNombre.setText("Por favor ingresa tu nombre");
        }else{
            mostrarPantallaJuego(nombreIngresado);
        }
    }

    public void mostrarPantallaJuego(String nombre) {
        Juego juego = Juego.getInstance();
        juego.inicializarJugador(nombre);
        PantallaJuego pantallaJuego = new PantallaJuego(juego, stage);
        Scene escenaJuego = new Scene(pantallaJuego.getRoot(), 800, 600);
        stage.setScene(escenaJuego);
    }
}
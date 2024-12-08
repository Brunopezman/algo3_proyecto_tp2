package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.vistas.pantalla.PantallaJuego;
import edu.fiuba.algo3.vistas.pantalla.PantallaTienda;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.nio.file.Paths;

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

        // Cargar y reproducir el sonido al hacer clic en el botón
        String rutaSonido = "src/main/java/edu/fiuba/algo3/resources/sonidos/click.mp3"; // Cambia "click.mp3" por tu archivo de sonido
        AudioClip sonido = new AudioClip(Paths.get(rutaSonido).toUri().toString());

        String nombreIngresado = campoNombre.getText().trim();
        sonido.play();
        if (nombreIngresado.isEmpty()) {
            textoIngreseNombre.setText("Por favor ingresa tu nombre");
            sonido.play();
        }else{
            mostrarPantallaJuego(nombreIngresado);
            PantallaTienda.mostrarTienda();
        }
    }

    public void mostrarPantallaJuego(String nombre) {
        Juego juego = Juego.updateInstance();
        juego.inicializarJugador(nombre);
        PantallaJuego pantallaJuego = new PantallaJuego(juego, stage);
        Scene escenaJuego = new Scene(pantallaJuego.getRoot(), 800, 600);
        stage.setScene(escenaJuego);
    }
}
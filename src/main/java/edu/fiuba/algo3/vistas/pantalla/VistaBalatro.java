package edu.fiuba.algo3.vistas.pantalla;

import edu.fiuba.algo3.controllers.ControladorPantallaInicial;
import edu.fiuba.algo3.eventos.EventoPantallaInicial;


import edu.fiuba.algo3.modelo.juego.Juego;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Timer;

public class VistaBalatro {

    private static final int ANCHO = 800;
    private static final int ALTO = 600;
    private final Stage stage;

    private final Juego juego;
    private final Timer timer;

    /**
     * Constructor de la vista principal del juego Balatro
     * @param stage el escenario donde se mostrará el juego
     * @param juego el modelo del juego
     */

    public VistaBalatro(Stage stage, Juego juego) {
        this.stage = stage;
        this.juego = juego;
        timer = new Timer();
        stage.setTitle("Balatro");

        stage.setWidth(ANCHO);
        stage.setHeight(ALTO);
        stage.setResizable(false);

        mostrarPantallaInicial();

        stage.show();
    }

    /**
     * Habria dejar de arrancar el juego con mostrar pantalla inicial
     * Es decir, lo unico que deberia hacer pantalla es mostrarse.
     * En controlador habria que hacer las cosas pasen y se vayan actualizando.
     */

    /**
     * Muestra la pantalla inicial.
     */
    public void mostrarPantallaInicial() {
        ControladorPantallaInicial controladorPantallaInicial = new ControladorPantallaInicial(this); // 'this' si VistaBalatro implementa la interfaz necesaria
        EventoPantallaInicial eventosPantallaInicial = new EventoPantallaInicial(controladorPantallaInicial);

        PantallaInicial pantallaInicial = new PantallaInicial(eventosPantallaInicial);
        Scene escenaInicial = new Scene(pantallaInicial.getRoot(), ANCHO, ALTO);
        stage.setScene(escenaInicial);
    }

    public void mostrarPantallaUser() {
        PantallaUser pantallaUser = new PantallaUser(nombre -> mostrarPantallaJuego(nombre));
        Scene escenaUser = new Scene(pantallaUser.getRoot(), ANCHO, ALTO);
        stage.setScene(escenaUser);
    }

    public void mostrarPantallaJuego(String nombre) {
        juego.inicializarJugador(nombre);
        PantallaJuego pantallaJuego = new PantallaJuego(nombre,juego, stage);
        Scene escenaJuego = new Scene(pantallaJuego.getRoot(), ANCHO, ALTO);
        stage.setScene(escenaJuego);
    }

    public void detenerTimer() {
        timer.cancel();
    }
}

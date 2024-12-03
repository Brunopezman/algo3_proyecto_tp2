package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.vistas.pantalla.PantallaInicial;
import edu.fiuba.algo3.vistas.pantalla.PantallaJuego;
import edu.fiuba.algo3.vistas.pantalla.PantallaUser;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static final int ANCHO = 800;
    private static final int ALTO = 600;

    private Stage stage;
    private Juego juego;

    @Override
    public void start(Stage stage) {
        this.stage = stage;

        configurarStage(stage);
        this.juego = new Juego("src/main/java/edu/fiuba/algo3/resources/archivosJson/balatro.json");

        mostrarPantallaInicial();
        stage.show();
    }

    private void configurarStage(Stage stage) {
        stage.setWidth(ANCHO);
        stage.setHeight(ALTO);
        stage.setResizable(false);
        stage.setTitle("Balatro");
    }

    public void mostrarPantallaInicial() {
        Runnable accionComenzar = this::mostrarPantallaUser;
        PantallaInicial pantallaInicial = new PantallaInicial(accionComenzar);
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

    public static void main(String[] args) {
        launch(args);
    }
}

package edu.fiuba.algo3;

import edu.fiuba.algo3.vistas.pantalla.PantallaInicial;
import edu.fiuba.algo3.vistas.pantalla.PantallaJuego;
import edu.fiuba.algo3.vistas.pantalla.PantallaUser;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.vistas.App;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage stage;

    @Override
    public void start(Stage stage) {
        this.stage = stage;

        mostrarPantallaInicial();

        stage.setTitle("Balatro");
        stage.show();
    }

    public void mostrarPantallaInicial() {
        PantallaInicial pantallaInicial = new PantallaInicial(this::mostrarPantallaUser);
        Scene escenaInicial = new Scene(pantallaInicial.getRoot(), 800, 600);
        stage.setScene(escenaInicial);
    }

    public void mostrarPantallaUser() {
        PantallaUser pantallaUser = new PantallaUser(nombre -> mostrarPantallaJuego(nombre));
        Scene escenaUser = new Scene(pantallaUser.getRoot(), 800, 600);
        stage.setScene(escenaUser);
    }

    public void mostrarPantallaJuego(String nombre) {
        Jugador jugador = new Jugador(nombre);
        PantallaJuego pantallaJuego = new PantallaJuego(jugador, stage);
        Scene escenaJuego = new Scene(pantallaJuego.getRoot(), 800, 600);
        stage.setScene(escenaJuego);
    }

    public static void main(String[] args) {
        launch(args);
        App.main(args);
    }
}
package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.interfaz.PantallaInicial;
import edu.fiuba.algo3.modelo.interfaz.PantallaJuego;
import edu.fiuba.algo3.modelo.interfaz.PantallaUser;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.vistas.App;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage stage;
    private Jugador jugador;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;

        mostrarPantallaInicial();

        stage.setTitle("Balatro");
        stage.show();
    }

    public void mostrarPantallaInicial() {
        PantallaInicial pantallaInicial = new PantallaInicial(this);
        Scene escenaInicial = new Scene(pantallaInicial.getRoot(), 800, 600);
        stage.setScene(escenaInicial);
    }

    public void mostrarPantallaUser() {
        PantallaUser pantallaUser = new PantallaUser(this);
        Scene escenaJuego = new Scene(pantallaUser.getRoot(), 800, 600);
        stage.setScene(escenaJuego);
    }
    public void mostrarPantallaJuego(String nombre) {
        Jugador jugador = new Jugador(nombre);
        PantallaJuego pantallaJuego = new PantallaJuego(this, jugador);
        Scene escenaJuego = new Scene(pantallaJuego.getRoot(), 800, 600);
        stage.setScene(escenaJuego);
    }

    public static void main(String[] args) {
        launch(args);
        App.main(args);
    }
}
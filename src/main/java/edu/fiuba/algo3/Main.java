package edu.fiuba.algo3;

import edu.fiuba.algo3.vistas.boton.Salir;
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

        //configuración de tamaño
        stage.setWidth(800); //por ahora lo dejo asi, se va a cambiar
        stage.setHeight(600);
        stage.setResizable(false); //evita el redimensionamiento manual

        mostrarPantallaInicial();

        stage.setTitle("Balatro");
        stage.show();
    }

    public void mostrarPantallaInicial() {
        // Acción para el botón "COMENCEMOS"
        Runnable accionComenzar = this::mostrarPantallaUser;

        // Crear la pantalla inicial con ambas acciones
        PantallaInicial pantallaInicial = new PantallaInicial(accionComenzar);
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


//Anterior main con tomaños variables en pantalla
//package edu.fiuba.algo3;
//
//import edu.fiuba.algo3.vistas.pantalla.PantallaInicial;
//import edu.fiuba.algo3.vistas.pantalla.PantallaJuego;
//import edu.fiuba.algo3.vistas.pantalla.PantallaUser;
//import edu.fiuba.algo3.vistas.pantalla.PantallaReglas;
//import edu.fiuba.algo3.modelo.juego.Jugador;
//import edu.fiuba.algo3.vistas.App;
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//
//public class Main extends Application {
//
//    private Stage stage;
//
//    @Override
//    public void start(Stage stage) {
//        this.stage = stage;
//
//        mostrarPantallaInicial();
//
//        stage.setTitle("Balatro");
//        stage.show();
//    }
//
//    public void mostrarPantallaInicial() {
//        // Acción para el botón "COMENCEMOS"
//        Runnable accionComenzar = this::mostrarPantallaUser;
//
//        // Acción para el botón "¿CÓMO JUGAR?"
//        Runnable accionComoJugar = () -> { mostrarTextoReglas(); };
//
//        // Pasar ambas acciones al constructor de PantallaInicial
//        PantallaInicial pantallaInicial = new PantallaInicial(accionComenzar, accionComoJugar);
//        Scene escenaInicial = new Scene(pantallaInicial.getRoot(), 800, 600);
//        stage.setScene(escenaInicial);
//    }
//
//    public void mostrarTextoReglas() {
//        PantallaReglas pantallaReglas = new PantallaReglas(() -> mostrarPantallaInicial());
//        Scene escenaReglas = new Scene(pantallaReglas.getRoot(), 800, 600);
//        stage.setScene(escenaReglas);
//    }
//
//    public void mostrarPantallaUser() {
//        PantallaUser pantallaUser = new PantallaUser(nombre -> mostrarPantallaJuego(nombre));
//        Scene escenaUser = new Scene(pantallaUser.getRoot(), 800, 600);
//        stage.setScene(escenaUser);
//    }
//
//    public void mostrarPantallaJuego(String nombre) {
//        Jugador jugador = new Jugador(nombre);
//        PantallaJuego pantallaJuego = new PantallaJuego(jugador, stage);
//        Scene escenaJuego = new Scene(pantallaJuego.getRoot(), 800, 600);
//        stage.setScene(escenaJuego);
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//        App.main(args);
//    }
//}

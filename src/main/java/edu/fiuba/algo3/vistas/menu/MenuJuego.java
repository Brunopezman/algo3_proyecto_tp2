package edu.fiuba.algo3.vistas.menu;

import edu.fiuba.algo3.vistas.boton.AccionBoton;
import edu.fiuba.algo3.vistas.boton.BotonHandler;
import edu.fiuba.algo3.vistas.boton.MostrarReglas;
import edu.fiuba.algo3.vistas.boton.Salir;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import java.nio.file.Paths;

public class MenuJuego {
    private final MenuBar menuBar;
    private MediaPlayer mediaPlayer;
    private boolean musicaReproduciendose; // Variable de estado

    public MenuJuego(Stage stage) {
        this.menuBar = new MenuBar();
        this.menuBar.getMenus().add(crearMenuOpciones(stage));
        this.menuBar.getMenus().add(crearMenuMusica());
        this.musicaReproduciendose = false; // Inicializamos como false
    }

    private Menu crearMenuOpciones(Stage stage) {
        Menu menuOpciones = new Menu("Opciones");
        menuOpciones.getItems().addAll(
                crearMenuItemReglas(stage),
                crearMenuItemSalir(stage)
        );
        return menuOpciones;
    }

    private MenuItem crearMenuItemReglas(Stage stage) {
        MenuItem menuReglas = new MenuItem("Reglas");
        menuReglas.setOnAction(event -> {
            MostrarReglas accionMostrarReglas = new MostrarReglas(stage);
            accionMostrarReglas.ejecutar();
        });
        return menuReglas;
    }

    private MenuItem crearMenuItemSalir(Stage stage) {
        MenuItem menuSalir = new MenuItem("Salir del Juego");
        AccionBoton accionSalir = new Salir(stage);
        menuSalir.setOnAction(new BotonHandler(accionSalir));
        return menuSalir;
    }

    private Menu crearMenuMusica() {
        Menu menuMusica = new Menu("Música");

        MenuItem reproducirMusica1 = new MenuItem("Música 1");
        reproducirMusica1.setOnAction(event -> reproducirMusica("src/main/java/edu/fiuba/algo3/resources/musica1.mp3"));

        MenuItem reproducirMusica2 = new MenuItem("Música 2");
        reproducirMusica2.setOnAction(event -> reproducirMusica("src/main/java/edu/fiuba/algo3/resources/musica2.mp3"));

        MenuItem reproducirMusica3 = new MenuItem("Música 3");
        reproducirMusica3.setOnAction(event -> reproducirMusica("src/main/java/edu/fiuba/algo3/resources/musica3.mp3"));

        MenuItem detenerMusica = new MenuItem("Detener Música");
        detenerMusica.setOnAction(event -> detenerMusica());

        menuMusica.getItems().addAll(reproducirMusica1, reproducirMusica2, reproducirMusica3, detenerMusica);
        return menuMusica;
    }

    private void reproducirMusica(String rutaMusica) {
        if (mediaPlayer != null && musicaReproduciendose) {
            mediaPlayer.stop();
        }

        Media media = new Media(Paths.get(rutaMusica).toUri().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.play();

        musicaReproduciendose = true; //música está reproduciéndose
    }

    private void detenerMusica() {
        if (mediaPlayer != null && musicaReproduciendose) {
            mediaPlayer.stop();
            musicaReproduciendose = false; //música se ha detenido
        }
    }

    public MenuBar getMenuBar() {
        return menuBar;
    }
}
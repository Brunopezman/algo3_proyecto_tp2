package edu.fiuba.algo3.vistas.pantalla;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.vistas.menu.MenuJuego;

import java.nio.file.Paths;
import java.util.*;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class PantallaJuego {
    private VBox root;
    private GridPane contenidoJuego;
    private final MenuJuego menuJuego;
    private Juego juego;
    private List<Carta> cartas;
    private List<Carta> cartasSeleccionadas;
    private Stage stage;

    public PantallaJuego(String nombre, Juego juego, Stage stage) {
        this.stage = stage;
        this.root = new VBox();
        this.contenidoJuego = new GridPane();
        this.menuJuego = new MenuJuego(stage);
        this.juego = juego;
        this.cartas = juego.repartirCartasJugador();
        this.cartasSeleccionadas = new ArrayList<>(); // Vacío al inicio

        //Division de la pantalla segun lo que poseen
        ParteDerecha parteDerecha = new ParteDerecha(juego, cartas, cartasSeleccionadas);
        ParteIzquierda parteIzquierda = new ParteIzquierda(nombre, juego.puntajeNecesarioRonda(),juego.puntajeRonda(), juego.turnosTotales(), juego.descartesActuales(),juego.rondaActual());

        // Configuración inicial del GridPane
        contenidoJuego.setHgap(10);
        contenidoJuego.setVgap(10);

        // Crear las áreas izquierda y derecha
        contenidoJuego.add(parteIzquierda.crearParteIzquierda(), 0, 0);
        contenidoJuego.add(parteDerecha.crearParteDerecha(), 1, 0);

        root.getChildren().addAll(menuJuego.getMenuBar(), contenidoJuego);

        setFondoConTransparenciaOscura(contenidoJuego);
    }

    private void setFondoConTransparenciaOscura(Pane pane) {
        String rutaImagen = "src/main/java/edu/fiuba/algo3/resources/fondo_rya.jpeg";
        Image imagenFondo = new Image(Paths.get(rutaImagen).toUri().toString());
        Background background = new Background(new BackgroundImage(imagenFondo, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT));
        pane.setBackground(background);
    }

    public VBox getRoot() {
        return root;
    }
}
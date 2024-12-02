package edu.fiuba.algo3.vistas.pantalla;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Mazo;
import edu.fiuba.algo3.modelo.juego.Ronda;
import edu.fiuba.algo3.vistas.menu.MenuJuego;
import javafx.geometry.Insets;
import javafx.scene.control.*;

import java.nio.file.Paths;
import java.util.*;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PantallaJuego {
    private VBox root;
    private GridPane contenidoJuego;
    private final MenuJuego menuJuego;
    private Mazo mazo;
    private Ronda ronda;
    private Jugador jugador;
    private List<Carta> cartas;
    private List<Carta> cartasSeleccionadas;
    private Stage stage;

    public PantallaJuego(Jugador jugador, Stage stage) {
        this.stage = new Stage();
        this.root = new VBox();
        this.contenidoJuego = new GridPane();
        this.menuJuego = new MenuJuego(stage);
        Juego juego = new Juego("src/main/java/edu/fiuba/algo3/resources/archivosJson/balatro.json");
        this.mazo = juego.getMazo();
        this.ronda = juego.getRondas().get(0);
        this.jugador = jugador;
        this.cartas = new ArrayList<>(); // Vacío al inicio
        this.cartasSeleccionadas = new ArrayList<>();

        //Division de la pantalla segun lo que poseen
        ParteDerecha parteDerecha = new ParteDerecha(mazo, ronda, jugador, cartas, cartasSeleccionadas);
        ParteIzquierda parteIzquierda = new ParteIzquierda(ronda, jugador);

        // Configuración inicial del GridPane
        contenidoJuego.setHgap(10);
        contenidoJuego.setVgap(10);

        // Crear las áreas izquierda y derecha
        contenidoJuego.add(parteIzquierda.crearParteIzquierda(), 0, 0);
        contenidoJuego.add(parteDerecha.crearParteDerecha(), 1, 0);

        root.getChildren().addAll(menuJuego.getMenuBar(), contenidoJuego);

        ScrollPane scrollPane = new ScrollPane(root);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        setFondoConTransparenciaOscura();
    }

    private void setFondoConTransparenciaOscura() {

        String rutaImagen = "src/main/java/edu/fiuba/algo3/resources/fondo_rya.jpeg";
        Image imagenFondo = new Image(Paths.get(rutaImagen).toUri().toString());
        BackgroundImage backgroundImage = new BackgroundImage(
                imagenFondo,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(
                        BackgroundSize.AUTO,
                        BackgroundSize.AUTO,
                        false,
                        false,
                        true,
                        true
                )
        );

        BackgroundFill backgroundFill = new BackgroundFill(
                Color.rgb(70, 130, 180, 0.7), CornerRadii.EMPTY, Insets.EMPTY
        );

        // Crear el Background combinando la imagen y el color de fondo oscuro
        Background background = new Background(
                new BackgroundFill[] {backgroundFill}, new BackgroundImage[] {backgroundImage}
        );

        // Aplicar el fondo al GridPane
        contenidoJuego.setBackground(background);
    }

    public VBox getRoot() {
        return root;
    }
}
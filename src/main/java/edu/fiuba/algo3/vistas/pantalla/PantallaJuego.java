package edu.fiuba.algo3.vistas.pantalla;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Mazo;
import edu.fiuba.algo3.modelo.juego.Ronda;
import edu.fiuba.algo3.vistas.menu.MenuJuego;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import java.util.*;
import java.util.List;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

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
    private Text cartasRestantesText;
    private Stage stage;
    private HBox visualCartas;

    public PantallaJuego(Jugador jugador, Stage stage) {
        this.stage = new Stage();
        this.root = new VBox();
        this.contenidoJuego = new GridPane();
        this.menuJuego = new MenuJuego(stage);
        //this.mazo = new Mazo();
        //this.ronda = new Ronda(8, 3, 300, jugador);
        Juego juego = new Juego("src/main/java/edu/fiuba/algo3/resources/archivosJson/balatro.json");
        this.mazo = juego.getMazo();
        this.ronda = juego.getRondas().get(0);
        this.jugador = jugador;
        this.cartas = new ArrayList<>(); // Vacío al inicio
        this.cartasSeleccionadas = new ArrayList<>();
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

        contenidoJuego.setStyle("-fx-background-color: #28a745;");
    }

    public VBox getRoot() {
        return root;
    }
}
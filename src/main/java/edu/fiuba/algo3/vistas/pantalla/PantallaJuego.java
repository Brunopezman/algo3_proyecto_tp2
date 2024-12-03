package edu.fiuba.algo3.vistas.pantalla;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.vistas.menu.MenuJuego;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.nio.file.Paths;
import java.util.List;

public class PantallaJuego {

    private final MenuJuego menuJuego;
    private VBox root;
    private GridPane contenidoJuego;
    private ParteIzquierda parteIzquierda;
    private ParteDerecha parteDerecha;

    public PantallaJuego(String nombre, Juego juego, Stage stage) {
        this.root = new VBox();
        this.contenidoJuego = new GridPane();
        this.menuJuego = new MenuJuego(stage);
        // Inicializar las partes
        this.parteIzquierda = new ParteIzquierda(nombre, juego.puntajeNecesarioRonda(), juego.puntajeRonda(), juego.turnosTotales(), juego.descartesActuales(), juego.rondaActual());
        this.parteDerecha = new ParteDerecha(juego, this.parteIzquierda);

        // Configurar la interfaz inicial
        setupInterfaz();
    }

    // Configuración inicial de la interfaz
    private void setupInterfaz() {
        contenidoJuego.setHgap(10);
        contenidoJuego.setVgap(10);

        contenidoJuego.add(parteIzquierda.crearParteIzquierda(), 0, 0);
        contenidoJuego.add(parteDerecha.crearParteDerecha(), 1, 0);
        setFondoConTransparenciaOscura(contenidoJuego);
        root.getChildren().addAll(menuJuego.getMenuBar(), contenidoJuego);

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


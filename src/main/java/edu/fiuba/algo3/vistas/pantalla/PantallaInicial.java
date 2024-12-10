package edu.fiuba.algo3.vistas.pantalla;

import edu.fiuba.algo3.controllers.BotonComencemosHandler;
import edu.fiuba.algo3.controllers.EventoPantallaInicial;
import edu.fiuba.algo3.vistas.boton.BotonComencemos;
import edu.fiuba.algo3.vistas.menu.MenuJuego;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.nio.file.Paths;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PantallaInicial {
    private final BorderPane root;
    private final MenuJuego menuJuego;
    private final EventoPantallaInicial eventosPantallaInicial;

    public PantallaInicial(EventoPantallaInicial eventosPantallaInicial) {
        VistaBalatro vistaBalatro = VistaBalatro.getInstance(null);
        this.eventosPantallaInicial = eventosPantallaInicial;
        Font fuenteTitulo = cargarFuente("src/main/java/edu/fiuba/algo3/resources/fuentes/fuente.ttf", 120);

        String rutaImagen = "src/main/java/edu/fiuba/algo3/resources/fondos/fondo_rya.jpeg";
        Image imagenFondo = new Image(Paths.get(rutaImagen).toUri().toString());
        Background background = new Background(new BackgroundImage(imagenFondo, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT));

        // Crear el menú de juego
        this.menuJuego = vistaBalatro.getMenuJuego();

        VBox contenido = new VBox();
        contenido.setAlignment(Pos.CENTER);
        contenido.setSpacing(50);

        Text titulo = new Text("B A L A T R O");
        titulo.setFont(fuenteTitulo);
        titulo.setFill(Color.YELLOW);
        titulo.setStyle("-fx-effect: dropshadow(gaussian, darkred, 5, 0.5, 0, 0);");

        BotonComencemosHandler handler = new BotonComencemosHandler(vistaBalatro.getStage());
        BotonComencemos botonComencemos = new BotonComencemos(handler);

        contenido.getChildren().addAll(titulo, botonComencemos);

        root = new BorderPane();
        root.setBackground(background);
        root.setTop(menuJuego.getMenuBar());
        root.setCenter(contenido);
    }

    private Font cargarFuente(String rutaFuente, int tamaño) {
        try {
            return Font.loadFont(new FileInputStream(rutaFuente), tamaño);
        } catch (FileNotFoundException e) {
            System.err.println("Fuente no encontrada: " + rutaFuente);
            return Font.font("Arial", tamaño);
        }
    }

    public BorderPane getRoot() {
        return root;
    }
}
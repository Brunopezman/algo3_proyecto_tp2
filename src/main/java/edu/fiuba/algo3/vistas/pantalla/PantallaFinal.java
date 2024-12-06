package edu.fiuba.algo3.vistas.pantalla;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Paths;

public class PantallaFinal extends Parent {
    private StackPane root;
    
    public PantallaFinal(String resultado) {
        StackPane fondo = new StackPane();

        // Cargar las fuentes
        Font fuenteGanaste = cargarFuente("src/main/java/edu/fiuba/algo3/resources/fuentes/fuente2.otf", 40);
        Font fuenteConfirmar = cargarFuente("src/main/java/edu/fiuba/algo3/resources/fuentes/fuente2.otf", 30);

        // Cargar la imagen de fondo
        String rutaImagen = "src/main/java/edu/fiuba/algo3/resources/fondos/fondo_rya2.jpeg";
        Image imagenFondo = new Image(Paths.get(rutaImagen).toUri().toString());

        // Configurar el fondo
        Background background = new Background(new BackgroundImage(imagenFondo, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT));
        fondo.setBackground(background);

        // Crear el VBox para el contenido y hacer que ocupe todo el espacio disponible
        VBox contenido = new VBox();
        //contenido.setStyle("-fx-background-color: rgba(70, 130, 180, 0.5);");
        contenido.setAlignment(Pos.CENTER);
        contenido.setSpacing(30);
        contenido.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        contenido.setPrefSize(800, 600); // Tamaño preferido del contenido, ajusta según tus necesidades

        // Texto de encabezado
        Text textoGanaste = new Text(resultado);
        textoGanaste.setFont(fuenteGanaste);
        textoGanaste.setFill(Color.YELLOW);
        textoGanaste.setStyle("-fx-fill: white;");

        // Añadir elementos al VBox
        contenido.getChildren().add(textoGanaste);

        // Configurar el root de la pantalla
        this.root = fondo;
    }

    private Font cargarFuente(String rutaFuente, int tamanio) {
        try {
            return Font.loadFont(new FileInputStream(rutaFuente), tamanio);
        } catch (FileNotFoundException e) {
            System.err.println("Fuente no encontrada: " + rutaFuente);
            return Font.font("Arial", tamanio);
        }
    }

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }
}

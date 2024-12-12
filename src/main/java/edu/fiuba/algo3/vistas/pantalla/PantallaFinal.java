package edu.fiuba.algo3.vistas.pantalla;

import edu.fiuba.algo3.controllers.BotonReinicioHandler;
import edu.fiuba.algo3.vistas.boton.BotonReinicio;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Paths;

public class PantallaFinal extends Parent {
    private String resultado;
    private BorderPane root;
    private static final String MENSAJE_GANASTE = "GANASTE";

    private static final String PANTALLA_GANASTE ="src/main/java/edu/fiuba/algo3/resources/fondos/fondos_pantalla_ganada.jpg";
    private static final String PANTALLA_PERDISTE ="src/main/java/edu/fiuba/algo3/resources/fondos/fondos_pantalla_perdida.jpg";

    public PantallaFinal(String resultado) {
        Stage popupStage = new Stage();
        this.resultado = resultado;
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle("Resultado de la Partida");
        popupStage.setResizable(false);

        // Cargar la fuente
        Font fuente= cargarFuente("src/main/java/edu/fiuba/algo3/resources/fuentes/fuente2.otf", 40);
        Image imagenFondo;
        if (MENSAJE_GANASTE.equals(resultado)) {
            imagenFondo = new Image(Paths.get(PANTALLA_GANASTE).toUri().toString());
        } else {
            imagenFondo = new Image(Paths.get(PANTALLA_PERDISTE).toUri().toString());
        }

        // Configurar el fondo
        Background background = new Background(new BackgroundImage(imagenFondo, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT));

        // Crear el VBox para el contenido y hacer que ocupe todo el espacio disponible
        VBox contenido = new VBox();
        contenido.setAlignment(Pos.CENTER);
        contenido.setSpacing(30);
        contenido.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        contenido.setPrefSize(800, 600); // Tamaño preferido del contenido, ajusta según tus necesidades

        // Texto de encabezado
        Text texto= new Text(resultado);
        texto.setFont(fuente);
        texto.setFill(Color.YELLOW);
        texto.setStyle("-fx-fill: white;");

        //Boton para reiniciar el juego
        BotonReinicioHandler botonReinicioHandler = new BotonReinicioHandler(popupStage);
        BotonReinicio botonReinicio = new BotonReinicio(botonReinicioHandler);

        // Añadir elementos al VBox
        contenido.getChildren().addAll(texto, botonReinicio);

        root = new BorderPane();
        root.setBackground(background);
        root.setCenter(contenido);

        Scene scene = new Scene(root, 640, 480);
        popupStage.setScene(scene);
        popupStage.centerOnScreen();
        popupStage.showAndWait(); // Espera a que se cierre antes de continuar
    }

    private Font cargarFuente(String rutaFuente, int tamanio) {
        try {
            return Font.loadFont(new FileInputStream(rutaFuente), tamanio);
        } catch (FileNotFoundException e) {
            System.err.println("Fuente no encontrada: " + rutaFuente);
            return Font.font("Arial", tamanio);
        }
    }

    public static void mostrarPantallaFinal(String resultado) {
        new PantallaFinal(resultado);
    }
}

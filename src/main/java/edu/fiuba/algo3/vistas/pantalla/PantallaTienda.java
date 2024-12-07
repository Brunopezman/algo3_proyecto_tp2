/*
package edu.fiuba.algo3.vistas.pantalla;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Paths;

public class PantallaTienda {

    private StackPane root;

    public PantallaTienda() {
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
        Text textoGanaste = new Text("TIENDA");
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
}
**/

package edu.fiuba.algo3.vistas.pantalla;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PantallaTienda {

    public static void mostrarTienda() {
        Stage tiendaStage = new Stage();
        tiendaStage.setTitle("Tienda");

        VBox layout = new VBox(20);
        layout.setStyle("-fx-background-color: #FFFFFF;");

        // Agregar elementos de la tienda
        Button comprarItem = new Button("Comprar Item");
        comprarItem.setOnAction(e -> {
            // Lógica de compra aquí
            System.out.println("Item comprado");
        });

        Button cerrarTienda = new Button("Cerrar");
        cerrarTienda.setOnAction(e -> tiendaStage.close());

        layout.getChildren().addAll(comprarItem, cerrarTienda);

        Scene scene = new Scene(layout, 300, 200);
        tiendaStage.setScene(scene);
        tiendaStage.show();
    }
}

package edu.fiuba.algo3.vistas.pantalla;

import edu.fiuba.algo3.controllers.ComodinSeleccionadoHandler;
import edu.fiuba.algo3.controllers.TarotSeleccionadoHandler;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.media.AudioClip;

import java.io.FileInputStream;
import java.nio.file.Paths;

public class PantallaTienda {

    public static void mostrarTienda() {
        Stage tiendaStage = new Stage();
        tiendaStage.setTitle("Tienda");

        Font fuenteTitulo = cargarFuente("src/main/java/edu/fiuba/algo3/resources/fuentes/fuente2.otf", 40);

        // Título de la tienda
        Text titulo = new Text("Tienda de Cartas");
        titulo.setFont(fuenteTitulo);
        titulo.setFill(Color.YELLOW);
        titulo.setStyle("-fx-effect: dropshadow(gaussian, darkred, 5, 0.5, 0, 0);");

        // Crear un GridPane para las cartas
        GridPane cartasGrid = new GridPane();
        cartasGrid.setHgap(10); // Espacio horizontal entre columnas
        cartasGrid.setVgap(10); // Espacio vertical entre filas
        cartasGrid.setPadding(new Insets(10));
        cartasGrid.setAlignment(Pos.TOP_CENTER);

        // Cargar las imágenes de las cartas desde recursos
        String[] cartasComodin = {
                "src/main/java/edu/fiuba/algo3/resources/comodines/comodin_1.png",
                "src/main/java/edu/fiuba/algo3/resources/comodines/comodin_2.png",
                "src/main/java/edu/fiuba/algo3/resources/comodines/comodin_3.png",
                "src/main/java/edu/fiuba/algo3/resources/comodines/comodin_4.png",
                "src/main/java/edu/fiuba/algo3/resources/comodines/comodin_5.png",
                "src/main/java/edu/fiuba/algo3/resources/comodines/comodin_6.png",
                "src/main/java/edu/fiuba/algo3/resources/comodines/comodin_7.png",
                "src/main/java/edu/fiuba/algo3/resources/comodines/comodin_8.png",
                "src/main/java/edu/fiuba/algo3/resources/comodines/comodin_9.png",
                "src/main/java/edu/fiuba/algo3/resources/comodines/comodin_10.png",
                "src/main/java/edu/fiuba/algo3/resources/comodines/comodin_11.png",
                "src/main/java/edu/fiuba/algo3/resources/comodines/comodin_12.png"
        };

        String[] cartasTarot = {
                "src/main/java/edu/fiuba/algo3/resources/tarots/tarot_1.png",
                "src/main/java/edu/fiuba/algo3/resources/tarots/tarot_2.png",
                "src/main/java/edu/fiuba/algo3/resources/tarots/tarot_3.png",
                "src/main/java/edu/fiuba/algo3/resources/tarots/tarot_4.png",
                "src/main/java/edu/fiuba/algo3/resources/tarots/tarot_5.png",
                "src/main/java/edu/fiuba/algo3/resources/tarots/tarot_6.png",
                "src/main/java/edu/fiuba/algo3/resources/tarots/tarot_7.png"
        };

        String rutaSonido = "src/main/java/edu/fiuba/algo3/resources/sonidos/click.mp3";
        AudioClip sonidoClick = new AudioClip(Paths.get(rutaSonido).toUri().toString());

        // Agregar las cartas comodín a la primera fila del GridPane con ComodinSeleccionadoHandler
        for (int i = 0; i < cartasComodin.length; i++) {
            Image cartaImagen = new Image(Paths.get(cartasComodin[i]).toUri().toString());
            ImageView cartaView = new ImageView(cartaImagen);
            cartaView.setFitWidth(100); // Ancho de las cartas
            cartaView.setFitHeight(150); // Alto de las cartas

            // Instanciar el handler específico para cartas comodín
            ComodinSeleccionadoHandler handler = new ComodinSeleccionadoHandler(i, cartaView, sonidoClick);
            cartaView.setOnMouseClicked(event -> handler.handle(event));
            cartasGrid.add(cartaView, i, 0); // Columna i, fila 0
        }

        // Agregar las cartas tarot a la segunda fila del GridPane con TarotSeleccionadoHandler
        for (int i = 0; i < cartasTarot.length; i++) {
            Image cartaImagen = new Image(Paths.get(cartasTarot[i]).toUri().toString());
            ImageView cartaView = new ImageView(cartaImagen);
            cartaView.setFitWidth(100); // Ancho de las cartas
            cartaView.setFitHeight(150); // Alto de las cartas

            // Instanciar el handler específico para cartas tarot
            TarotSeleccionadoHandler handler = new TarotSeleccionadoHandler(i, cartaView, sonidoClick);
            cartaView.setOnMouseClicked(event -> handler.handle(event));
            cartasGrid.add(cartaView, i, 1); // Columna i, fila 1
        }

        ScrollPane scrollPane = new ScrollPane(cartasGrid);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(false); //desplazamiento horizontal
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        // Botón para comprar cartas
        Button botonComprar = new Button("Comprar");
        botonComprar.setOnAction(e -> System.out.println("¡Has comprado las cartas seleccionadas!"));

        // Botón para cerrar la tienda
        Button cerrarTienda = new Button("Cerrar");
        cerrarTienda.setOnAction(e -> tiendaStage.close());

        // Organizar botones en un HBox
        HBox botonesBox = new HBox(20, botonComprar, cerrarTienda);
        botonesBox.setAlignment(Pos.CENTER);

        // Layout principal
        VBox layout = new VBox(20, titulo, scrollPane, botonesBox);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10));
        layout.setStyle("-fx-background-color: #f0f0f0;");

        // Crear la escena y mostrarla
        Scene scene = new Scene(layout, 800, 600);
        tiendaStage.setScene(scene);
        tiendaStage.show();
    }

    private static Font cargarFuente(String rutaFuente, int tamano) {
        try {
            return Font.loadFont(new FileInputStream(rutaFuente), tamano);
        } catch (Exception e) {
            System.out.println("No se pudo cargar la fuente: " + rutaFuente);
            return Font.font("Arial", tamano); // Fuente por defecto
        }
    }
}

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
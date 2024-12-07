package edu.fiuba.algo3.vistas.pantalla;

import edu.fiuba.algo3.controllers.BotonComprarHandler;
import edu.fiuba.algo3.controllers.BotonOmitirHandler;
import edu.fiuba.algo3.controllers.ComodinSeleccionadoHandler;
import edu.fiuba.algo3.controllers.TarotSeleccionadoHandler;

import edu.fiuba.algo3.modelo.comodin.Comodin;
import edu.fiuba.algo3.vistas.boton.BotonComprar;
import edu.fiuba.algo3.vistas.boton.BotonOmitir;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class PantallaTienda {

    private static List<Comodin> comodinesSeleccionados;
    private static ParteDerecha parteDerecha ;

    public PantallaTienda(ParteDerecha parteDerecha) {
        this.parteDerecha = parteDerecha;
    }

    public static void mostrarTienda() {
        Stage tiendaStage = new Stage();
        tiendaStage.setTitle("Tienda");

        Font fuenteTitulo = cargarFuente("src/main/java/edu/fiuba/algo3/resources/fuentes/fuente2.otf", 60);

        // Título de la tienda
        Text titulo = new Text("Tienda");
        titulo.setFont(fuenteTitulo);
        titulo.setFill(Color.YELLOW);
        titulo.setStyle("-fx-effect: dropshadow(gaussian, darkred, 5, 0.5, 0, 0);");

        // Crear un HBox para las cartas de comodines y tarot
        HBox contenedorCartas = new HBox(20);
        contenedorCartas.setAlignment(Pos.CENTER);
        contenedorCartas.setPadding(new Insets(10));

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

        // Seleccionar 2 cartas aleatorias de los comodines
        Set<Integer> indicesComodin = obtenerIndicesAleatorios(cartasComodin.length, 2);
        VBox contenedorComodines = new VBox(10);
        contenedorComodines.setAlignment(Pos.CENTER);
        for (Integer indice : indicesComodin) {
            Image cartaImagen = new Image(Paths.get(cartasComodin[indice]).toUri().toString());
            ImageView cartaView = new ImageView(cartaImagen);
            cartaView.setFitWidth(100); // Ancho de las cartas
            cartaView.setFitHeight(150); // Alto de las cartas

            // Instanciar el handler específico para cartas comodín
            ComodinSeleccionadoHandler handler = new ComodinSeleccionadoHandler(cartasComodin[indice], cartaView,cartaImagen, sonidoClick, comodinesSeleccionados, parteDerecha);
            cartaView.setOnMouseClicked(handler::handle);
            contenedorComodines.getChildren().add(cartaView);
        }

        // Seleccionar 2 cartas aleatorias de los tarots
        Set<Integer> indicesTarot = obtenerIndicesAleatorios(cartasTarot.length, 2);
        VBox contenedorTarot = new VBox(10);
        contenedorTarot.setAlignment(Pos.CENTER);
        for (Integer indice : indicesTarot) {
            Image cartaImagen = new Image(Paths.get(cartasTarot[indice]).toUri().toString());
            ImageView cartaView = new ImageView(cartaImagen);
            cartaView.setFitWidth(100); // Ancho de las cartas
            cartaView.setFitHeight(150); // Alto de las cartas

            // Instanciar el handler específico para cartas tarot
            TarotSeleccionadoHandler handler = new TarotSeleccionadoHandler(indice, cartaView, sonidoClick);
            cartaView.setOnMouseClicked(handler::handle);
            contenedorTarot.getChildren().add(cartaView);
        }

        // Añadir los contenedores de comodines y tarot al contenedor principal
        contenedorCartas.getChildren().addAll(contenedorComodines, contenedorTarot);

        // Crear un StackPane para añadir el fondo de pantalla
        StackPane stackPane = new StackPane();

        // Cargar la imagen de fondo
        String rutaFondo = "src/main/java/edu/fiuba/algo3/resources/fondos/fondo_rya.jpeg";
        Image imagenFondo = new Image(Paths.get(rutaFondo).toUri().toString());
        BackgroundImage fondo = new BackgroundImage(imagenFondo, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background background = new Background(fondo);

        // Establecer el fondo en el StackPane
        stackPane.setBackground(background);

        // Organizar botones
        BotonComprarHandler botonComprarHandler = new BotonComprarHandler();
        BotonComprar botonComprar = new BotonComprar(botonComprarHandler);

        BotonOmitirHandler botonOmitirHandler = new BotonOmitirHandler(tiendaStage);
        BotonOmitir botonOmitir = new BotonOmitir(botonOmitirHandler);

        // Organizar botones en un HBox
        HBox botonesBox = new HBox(20, botonComprar, botonOmitir);
        botonesBox.setAlignment(Pos.CENTER);

        // Layout principal dentro del StackPane
        VBox layout = new VBox(10, titulo, contenedorCartas, botonesBox);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10));

        // Añadir el layout al StackPane
        stackPane.getChildren().add(layout);

        // Crear la escena y mostrarla
        Scene scene = new Scene(stackPane, 640, 480);
        tiendaStage.setScene(scene);
        tiendaStage.show();
    }

    private static Set<Integer> obtenerIndicesAleatorios(int rango, int cantidad) {
        Random random = new Random();
        Set<Integer> indices = new HashSet<>();
        while (indices.size() < cantidad) {
            indices.add(random.nextInt(rango));
        }
        return indices;
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
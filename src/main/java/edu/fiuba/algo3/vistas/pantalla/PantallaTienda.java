/*
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
                "src/main/java/edu/fiuba/algo3/resources/comodines/Comodin Real.png",
                "src/main/java/edu/fiuba/algo3/resources/comodines/Descarte Dorado.png",
                "src/main/java/edu/fiuba/algo3/resources/comodines/Comodin Poderoso.png",
                "src/main/java/edu/fiuba/algo3/resources/comodines/Suerte Suprema.png",
                "src/main/java/edu/fiuba/algo3/resources/comodines/comodin_5.png",
                "src/main/java/edu/fiuba/algo3/resources/comodines/comodin_6.png",
                "src/main/java/edu/fiuba/algo3/resources/comodines/comodin_7.png",
                "src/main/java/edu/fiuba/algo3/resources/comodines/comodin_8.png",
                "src/main/java/edu/fiuba/algo3/resources/comodines/comodin_9.png",
                "src/main/java/edu/fiuba/algo3/resources/comodines/comodin_10.png",
                "src/main/java/edu/fiuba/algo3/resources/comodines/Gros Michel.png",
                "src/main/java/edu/fiuba/algo3/resources/comodines/Destino Explosivo.png"
        };

        String[] cartasTarot = {
                "src/main/java/edu/fiuba/algo3/resources/tarots/La Suma Sacerdotisa.png",
                "src/main/java/edu/fiuba/algo3/resources/tarots/El Tonto.png",
                "src/main/java/edu/fiuba/algo3/resources/tarots/El Carro.png",
                "src/main/java/edu/fiuba/algo3/resources/tarots/El Mago.png",
                "src/main/java/edu/fiuba/algo3/resources/tarots/El Emperador.png",
                "src/main/java/edu/fiuba/algo3/resources/tarots/La Emperatriz.png",
                "src/main/java/edu/fiuba/algo3/resources/tarots/El Hierofante.png"
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
 */

package edu.fiuba.algo3.vistas.pantalla;

import edu.fiuba.algo3.controllers.*;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.comodin.Comodin;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.juego.Ronda;
import edu.fiuba.algo3.modelo.tarot.Tarot;
import edu.fiuba.algo3.modelo.juego.Tienda;
import edu.fiuba.algo3.vistas.boton.BotonComprar;
import edu.fiuba.algo3.vistas.boton.BotonOmitir;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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

import java.util.ArrayList;
import java.util.List;

public class PantallaTienda {

    private static List<Comodin> comodinesSeleccionados;
    private static ParteDerecha parteDerecha;
    private static int contador;

    public PantallaTienda(ParteDerecha parteDerecha) {
        this.parteDerecha = parteDerecha;
        this.contador = 0;
    }

    public static void mostrarTienda() {
        Stage tiendaStage = new Stage();
        tiendaStage.setTitle("Tienda");

        // Cargar fuente personalizada
        Font fuenteTitulo = cargarFuente("src/main/java/edu/fiuba/algo3/resources/fuentes/fuente2.otf", 60);

        // Crear el título de la tienda
        Text titulo = new Text("Tienda");
        titulo.setFont(fuenteTitulo);
        titulo.setFill(Color.YELLOW);
        titulo.setStyle("-fx-effect: dropshadow(gaussian, darkred, 5, 0.5, 0, 0);");

        // Crear el contenedor de cartas
        HBox contenedorCartas = new HBox(20);
        contenedorCartas.setAlignment(Pos.CENTER);
        contenedorCartas.setPadding(new Insets(10));

        // Obtener la tienda de la ronda actual
        Juego juego = Juego.getInstance();
        Ronda rondaActual = juego.getRondaActual();
        Tienda tienda = rondaActual.getTienda();

        // Obtener las cartas de comodines y tarots de la tienda
        List<Comodin> comodines = tienda.getComodines();
        List<Comodin> comodinesSeleccionados = new ArrayList<>();
        List<Tarot> tarots = tienda.getTarots();
        List<Tarot> tarotsSeleccionados = new ArrayList<>();
        Carta cartaEspecifica = tienda.getCarta();
        List<Carta> cartasEspecificas = new ArrayList<>();

        String rutaSonido = "src/main/java/edu/fiuba/algo3/resources/sonidos/click.mp3";
        AudioClip sonidoClick = new AudioClip(Paths.get(rutaSonido).toUri().toString());

        // Mostrar cartas de comodines
        VBox contenedorComodines = new VBox(10);
        contenedorComodines.setAlignment(Pos.CENTER);

        for (Comodin comodin : comodines) {
            Image cartaImagen = new Image(Paths.get("src/main/java/edu/fiuba/algo3/resources/comodines/" + comodin.getNombre() + ".png").toUri().toString());
            ImageView cartaView = new ImageView(cartaImagen);
            cartaView.setFitWidth(100);
            cartaView.setFitHeight(150);

            ComodinSeleccionadoHandler handler = new ComodinSeleccionadoHandler(comodin, cartaView, sonidoClick, comodinesSeleccionados);
            cartaView.setOnMouseClicked(event -> handler.handle(new ActionEvent()));
            contenedorComodines.getChildren().add(cartaView);
        }

        // Mostrar cartas de tarots
        VBox contenedorTarot = new VBox(10);
        contenedorTarot.setAlignment(Pos.CENTER);
        for (Tarot tarot : tarots) {
            Image cartaImagen = new Image(Paths.get("src/main/java/edu/fiuba/algo3/resources/tarots/" + tarot.getNombre() + ".png").toUri().toString());
            ImageView cartaView = new ImageView(cartaImagen);
            cartaView.setFitWidth(100);
            cartaView.setFitHeight(150);

            TarotSeleccionadoHandler handler = new TarotSeleccionadoHandler(tarot, tarotsSeleccionados, cartaView, sonidoClick);
            cartaView.setOnMouseClicked(event -> handler.handle(new ActionEvent()));
            contenedorTarot.getChildren().add(cartaView);
        }
        VBox contenedorCartaEspecifica = new VBox(10);
        contenedorCartaEspecifica.setAlignment(Pos.CENTER);

        if (cartaEspecifica != null) {
            // Construir la ruta de la imagen basada en el número y el palo de la carta
            String rutaImagenCarta = "src/main/java/edu/fiuba/algo3/resources/cartas/" +
                    cartaEspecifica.numero() + "_" + cartaEspecifica.getPalo() + ".jpg";
            ImageView cartaView = new ImageView(new Image(Paths.get(rutaImagenCarta).toUri().toString()));
            cartaView.setFitWidth(100);
            cartaView.setFitHeight(150);

            // Agregar evento de clic si es necesario
            CartaTiendaSeleccionadaHandler handler = new CartaTiendaSeleccionadaHandler(cartaEspecifica, cartasEspecificas,cartaView, sonidoClick);
            cartaView.setOnMouseClicked(event -> handler.handle(new ActionEvent()));

            // Añadir la carta específica al contenedor
            contenedorCartaEspecifica.getChildren().add(cartaView);
        } else {
            System.out.println("No hay carta específica en la tienda.");
        }

        // Añadir contenedores de cartas al contenedor principal
        contenedorCartas.getChildren().addAll(contenedorComodines, contenedorTarot,contenedorCartaEspecifica);

        // Crear un StackPane para el fondo de pantalla
        StackPane stackPane = new StackPane();
        String rutaFondo = "src/main/java/edu/fiuba/algo3/resources/fondos/fondo_rya.jpeg";
        Image imagenFondo = new Image(Paths.get(rutaFondo).toUri().toString());
        BackgroundImage fondo = new BackgroundImage(imagenFondo, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background background = new Background(fondo);
        stackPane.setBackground(background);

        // Crear botones de compra y omisión
        BotonComprarHandler botonComprarHandler = new BotonComprarHandler(tiendaStage,comodinesSeleccionados,tarotsSeleccionados,cartasEspecificas);
        BotonComprar botonComprar = new BotonComprar(botonComprarHandler);

        BotonOmitirHandler botonOmitirHandler = new BotonOmitirHandler(tiendaStage);
        BotonOmitir botonOmitir = new BotonOmitir(botonOmitirHandler);

        // Organizar los botones
        HBox botonesBox = new HBox(20, botonComprar, botonOmitir);
        botonesBox.setAlignment(Pos.CENTER);

        // Crear el layout principal y añadir los elementos
        VBox layout = new VBox(10, titulo, contenedorCartas, botonesBox);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10));

        // Añadir el layout al StackPane y mostrar la escena
        stackPane.getChildren().add(layout);
        Scene scene = new Scene(stackPane, 640, 480);
        tiendaStage.setScene(scene);
        tiendaStage.show();
    }

    private static Font cargarFuente(String rutaFuente, int tamano) {
        try {
            return Font.loadFont(new FileInputStream(rutaFuente), tamano);
        } catch (Exception e) {
            System.out.println("No se pudo cargar la fuente: " + rutaFuente);
            return Font.font("Arial", tamano);
        }
    }

    public static boolean sePuedeSeguirEligiendo(){
        return (contador < 3);
    }

    public static void aumentarContador(){
        contador++;
    }

    public static void reducirContador(){
        contador--;
    }

    public static void reiniciarContador(){
        contador = 0;
    }
}

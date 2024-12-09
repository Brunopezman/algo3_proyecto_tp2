package edu.fiuba.algo3.vistas.pantalla;

import edu.fiuba.algo3.controllers.*;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.comodin.Comodin;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.tarot.Tarot;
import edu.fiuba.algo3.vistas.boton.BotonAplicarTarot;
import edu.fiuba.algo3.vistas.boton.BotonDescartar;
import edu.fiuba.algo3.vistas.boton.BotonJugarMano;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.media.AudioClip;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ParteDerecha {
    private final BorderPane parteDerecha;
    private final Juego juego;
    private static ParteIzquierda parteIzquierda;
    private static HBox visualCartas;
    private static Text cartasRestantesText;
    private PantallaJuego pantallaJuego;
    private static HBox comodinesBox;
    private static HBox tarotsBox;
    private static HBox botonAplicar;
    private static List<Tarot> tarotSeleccionados;
    private Label mensajeTemporal;

    public ParteDerecha(Juego juego, ParteIzquierda parteIzquierda) {
        this.juego = juego;
        this.parteIzquierda = parteIzquierda;
        this.parteDerecha = new BorderPane();
        inicializarUI();
    }

    private void inicializarUI() {
        StackPane centro = new StackPane();

        // Cartas del jugador: inicialmente vacío, pero se llenará automáticamente
        visualCartas = new HBox();
        visualCartas.setSpacing(5);
        visualCartas.setAlignment(Pos.CENTER);

        mensajeTemporal = new Label();
        mensajeTemporal.setStyle("-fx-background-color: rgba(0, 0, 0, 0.7); -fx-text-fill: white; -fx-padding: 10px; -fx-font-size: 14px;");
        mensajeTemporal.setVisible(false);

        // Llama a repartirCartas para inicializar las cartas desde el comienzo
        juego.repartirCartasJugador(8);
        List<Carta> cartasSeleccionadas = new ArrayList<>();
        tarotSeleccionados = new ArrayList<>();

        // Comodines y Tarots
        HBox comodinesTarots = crearComodinesTarots();
        parteDerecha.setTop(comodinesTarots);

        // Botones y Mazo
        HBox contenidoInferior = crearContenidoInferior(cartasSeleccionadas);
        parteDerecha.setBottom(contenidoInferior);

        // Visualizacion de cartas en la mano
        actualizarVisualMazo();
        actualizarVisualCartas(cartasSeleccionadas);
        actualizarVisualTarot();

        centro.getChildren().addAll(visualCartas, mensajeTemporal);
        StackPane.setAlignment(mensajeTemporal, Pos.TOP_CENTER);

        parteDerecha.setCenter(centro);
        parteDerecha.setPadding(new Insets(10));
    }

    private HBox crearComodinesTarots() {
        HBox comodinesTarots = new HBox();
        comodinesTarots.setSpacing(20);
        comodinesTarots.setAlignment(Pos.CENTER);

        // Comodines
        Rectangle comodines = new Rectangle(200, 80);
        comodines.setStyle("-fx-fill: #ffffff; -fx-stroke: black; -fx-stroke-width: 1;");
        int cantidadComodines = juego.comodinesRonda();
        Text cantidadComodinesText = new Text(cantidadComodines + "/5");
        cantidadComodinesText.setStyle("-fx-font-size: 0.8em; -fx-fill: #efe7e7;");
        comodinesBox = new HBox(comodines, cantidadComodinesText);

        // Tarots
        Rectangle tarots = new Rectangle(120, 80);
        tarots.setStyle("-fx-fill: #ffffff; -fx-stroke: black; -fx-stroke-width: 1;");
        int cantidadTarots = 0;
        Text cantidadTarotsText = new Text(cantidadTarots + "/2");
        cantidadTarotsText.setStyle("-fx-font-size: 0.8em; -fx-fill: #ffffff;");
        tarotsBox = new HBox(tarots, cantidadTarotsText);

        // Boton para los a tarots
        BotonAplicarTarotHandler handler = new BotonAplicarTarotHandler(tarotSeleccionados, mensajeTemporal);
        BotonAplicarTarot botonAplicarTarot = new BotonAplicarTarot(handler);
        botonAplicar = new HBox(botonAplicarTarot);

        comodinesTarots.getChildren().addAll(comodinesBox, tarotsBox, botonAplicar);
        return comodinesTarots;
    }

    private HBox crearContenidoInferior(List<Carta> cartasSeleccionadas) {
        HBox contenidoInferior = new HBox();
        HBox botones = new HBox();
        botones.setSpacing(20);
        botones.setAlignment(Pos.CENTER);

        // Boton JugarMano
        BotonJugarManoHandler botonJugarManoHandler = new BotonJugarManoHandler(juego,cartasSeleccionadas, parteIzquierda, cartasRestantesText, mensajeTemporal);
        BotonJugarMano botonJugarMano = new BotonJugarMano(botonJugarManoHandler);

        // Boton Descartar
        BotonDescartarHandler botonDescartarHandler = new BotonDescartarHandler(juego,cartasSeleccionadas, parteIzquierda, cartasRestantesText, mensajeTemporal);
        BotonDescartar botonDescartar = new BotonDescartar(botonDescartarHandler);

        botones.getChildren().addAll(botonJugarMano, botonDescartar);

        // Mazo
        String rutaImagen = "src/main/java/edu/fiuba/algo3/resources/cartas/reverso.png";
        Image imagen = new Image(Paths.get(rutaImagen).toUri().toString());
        ImageView imageView = new ImageView(imagen);
        imageView.setFitWidth(100);
        imageView.setFitHeight(150);

        cartasRestantesText = new Text(juego.getMazo().cartasRestantes() + "/" + juego.getCartasTotalesMazo());
        cartasRestantesText.setFont(Font.font("Arial", 16));
        cartasRestantesText.setStyle("-fx-font-size: 0.8em; -fx-fill: #ffffff;");

        VBox imagenYTexto = new VBox(10, imageView, cartasRestantesText);
        imagenYTexto.setAlignment(Pos.CENTER_RIGHT);

        HBox botonesYMazo = new HBox(80, botones, imagenYTexto);
        contenidoInferior.getChildren().add(botonesYMazo);

        return contenidoInferior;
    }

    public static void actualizarVisualMazo(){
        Juego juego = Juego.getInstance();
        cartasRestantesText.setText(juego.getMazo().cartasRestantes() + "/" + juego.getCartasTotalesMazo());
    }

    public static void actualizarVisualCartas(List<Carta> cartasSeleccionadas) {
        visualCartas.getChildren().clear();
        String rutaSonido = "src/main/java/edu/fiuba/algo3/resources/sonidos/click.mp3";
        AudioClip sonido = new AudioClip(Paths.get(rutaSonido).toUri().toString());
        Juego juego = Juego.getInstance();
        for (Carta carta : juego.jugadoresCartasActuales()) {
            ImageView imagenCarta = new ImageView(new Image(Paths.get("src/main/java/edu/fiuba/algo3/resources/cartas/" + carta.numero() + "_" + carta.getPalo() + ".jpg").toUri().toString()));
            imagenCarta.setFitWidth(56);
            imagenCarta.setFitHeight(84);
            CartaSeleccionadaHandler seleccion = new CartaSeleccionadaHandler(cartasSeleccionadas, carta, imagenCarta, sonido, parteIzquierda);
            imagenCarta.setOnMouseClicked(event -> seleccion.handle(new ActionEvent()));
            visualCartas.getChildren().add(imagenCarta);
        }
    }

    public static void actualizarVisualComodines(){
        comodinesBox.getChildren().clear();
        Juego juego = Juego.getInstance();
        List<Comodin> comodines = juego.getRondaActual().getComodines();
        for (Comodin comodin : comodines) {
            Image comodinImagen = new Image(Paths.get("src/main/java/edu/fiuba/algo3/resources/comodines/" + comodin.getNombre() + ".png").toUri().toString());
            ImageView cartaView = new ImageView(comodinImagen);
            cartaView.setFitWidth(56); // Ancho de las cartas
            cartaView.setFitHeight(84); // Alto de las cartas

            comodinesBox.getChildren().add(cartaView);
        }
    }

    public static void actualizarVisualTarot(){
        tarotsBox.getChildren().clear();
        tarotsBox.setSpacing(5);
        tarotsBox.setAlignment(Pos.CENTER);
        String rutaSonido = "src/main/java/edu/fiuba/algo3/resources/sonidos/click.mp3";
        Juego juego = Juego.getInstance();
        List<Tarot> tarots = juego.getRondaActual().getTarots();
        AudioClip sonido = new AudioClip(Paths.get(rutaSonido).toUri().toString());
        for (Tarot tarot : tarots) {
            ImageView imagenTarot = new ImageView(Paths.get("src/main/java/edu/fiuba/algo3/resources/tarots/" + tarot.getNombre() + ".png").toUri().toString());
            imagenTarot.setFitWidth(56); // Ancho de las cartas
            imagenTarot.setFitHeight(84); // Alto de las cartas
            TarotAplicarHandler seleccion = new TarotAplicarHandler(tarotSeleccionados, tarot, imagenTarot, sonido);
            imagenTarot.setOnMouseClicked(event -> seleccion.handle(new ActionEvent()));
            tarotsBox.getChildren().add(imagenTarot);
        }
    }

    public BorderPane crearParteDerecha() {
        return parteDerecha;
    }
}

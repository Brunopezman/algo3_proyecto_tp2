package edu.fiuba.algo3.vistas.pantalla;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Mazo;
import edu.fiuba.algo3.modelo.juego.Ronda;
import edu.fiuba.algo3.vistas.boton.AccionBoton;
import edu.fiuba.algo3.vistas.boton.BotonHandler;
import edu.fiuba.algo3.vistas.boton.Descartar;
import edu.fiuba.algo3.vistas.boton.JugarMano;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParteDerecha {
    private final BorderPane parteDerecha;
    private final Mazo mazo;
    private final Jugador jugador;
    private final Ronda ronda;
    private final List<Carta> cartasSeleccionadas;
    private final List<Carta> cartas;
    private HBox visualCartas;
    private Text cartasRestantesText;

    public ParteDerecha(Mazo mazo, Ronda ronda, Jugador jugador, List<Carta> cartas, List<Carta> cartasSeleccionadas) {
        this.parteDerecha = new BorderPane();
        this.mazo = mazo;
        this.jugador = jugador;
        this.ronda = ronda;
        this.cartas = cartas;
        this.cartasSeleccionadas = cartasSeleccionadas;
        inicializarUI();
    }

    private void inicializarUI() {

        // Crear un StackPane para apilar las cartas y el mensaje
        StackPane centro = new StackPane();

        // Mensaje inicial
        StackPane mensajeCentro = crearMensajeCentro();
        centro.getChildren().add(mensajeCentro);

        // Cartas del jugador: inicialmente vacío
        visualCartas = new HBox();
        visualCartas.setSpacing(5);
        visualCartas.setAlignment(Pos.CENTER);
        centro.getChildren().add(visualCartas);  // Las cartas se agregarán al StackPane

        parteDerecha.setCenter(centro);  // Coloca el StackPane en el centro del BorderPane

        // Comodines y Tarots
        HBox comodinesTarots = crearComodinesTarots();
        parteDerecha.setTop(comodinesTarots);

        // Botones y Mazo
        HBox contenidoInferior = crearContenidoInferior();
        parteDerecha.setBottom(contenidoInferior);

        parteDerecha.setPadding(new Insets(10));
    }


    private StackPane crearMensajeCentro() {
        StackPane mensajeCentro = new StackPane();
        Text mensajeInstruccion = new Text("Tocá el mazo para comenzar");
        mensajeInstruccion.setStyle("-fx-fill: #ffffff; -fx-font-weight: bold;");
        mensajeInstruccion.setFont(new Font(20));
        mensajeCentro.getChildren().add(mensajeInstruccion);
        mensajeCentro.setAlignment(Pos.CENTER);
        return mensajeCentro;
    }

    private HBox crearComodinesTarots() {
        HBox comodinesTarots = new HBox();
        comodinesTarots.setSpacing(20);
        comodinesTarots.setAlignment(Pos.CENTER);

        // Comodines
        Rectangle comodines = new Rectangle(200, 80);
        comodines.setStyle("-fx-fill: #ffffff; -fx-stroke: black; -fx-stroke-width: 1;");
        int cantidadComodines = ronda.cantidadComodines();
        Text cantidadComodinesText = new Text(cantidadComodines + "/5");
        cantidadComodinesText.setStyle("-fx-font-size: 0.8em; -fx-fill: #efe7e7;");
        VBox comodinesBox = new VBox(comodines, cantidadComodinesText);

        // Tarots
        Rectangle tarots = new Rectangle(120, 80);
        tarots.setStyle("-fx-fill: #ffffff; -fx-stroke: black; -fx-stroke-width: 1;");
        int cantidadTarots = 0;
        Text cantidadTarotsText = new Text(cantidadTarots + "/2");
        cantidadTarotsText.setStyle("-fx-font-size: 0.8em; -fx-fill: #ffffff;");
        VBox tarotsBox = new VBox(tarots, cantidadTarotsText);

        comodinesTarots.getChildren().addAll(comodinesBox, tarotsBox);
        return comodinesTarots;
    }

    private HBox crearContenidoInferior() {
        HBox contenidoInferior = new HBox();
        HBox botones = new HBox();
        botones.setSpacing(20);
        botones.setAlignment(Pos.CENTER);

        Button botonJugarMano = new Button("Jugar Mano");
        Button botonDescartar = new Button("Descartar");
        botonJugarMano.setStyle("-fx-font-size: 20px;-fx-background-color: \"#333333\"; -fx-font-weight: bold; -fx-text-fill: white;");
        botonDescartar.setStyle("-fx-font-size: 20px; -fx-background-color: \"#333333\"; -fx-font-weight: bold; -fx-text-fill: white;");

        AccionBoton accionJugarMano = new JugarMano(jugador, cartasSeleccionadas);
        AccionBoton accionDescartar = new Descartar();
        botonJugarMano.setOnAction(new BotonHandler(accionJugarMano));
        botonDescartar.setOnAction(new BotonHandler(accionDescartar));

        botones.getChildren().addAll(botonJugarMano, botonDescartar);

        // Mazo
        String rutaImagen = "src/main/java/edu/fiuba/algo3/resources/reverso.jpg";
        Image imagen = new Image(Paths.get(rutaImagen).toUri().toString());
        ImageView imageView = new ImageView(imagen);
        imageView.setFitWidth(100);
        imageView.setFitHeight(150);

        cartasRestantesText = new Text(mazo.cartasRestantes() + "/52");
        cartasRestantesText.setFont(Font.font("Arial", 16));
        cartasRestantesText.setStyle("-fx-font-size: 0.8em; -fx-fill: #ffffff;");

        imageView.setOnMouseClicked(event -> {
            if (parteDerecha.getCenter() != null) {
                parteDerecha.setCenter(null);
                parteDerecha.setCenter(visualCartas);
                repartirCartas();
            }
        });

        VBox imagenYTexto = new VBox(10, imageView, cartasRestantesText);
        imagenYTexto.setAlignment(Pos.CENTER_RIGHT);

        HBox botonesYMazo = new HBox(80, botones, imagenYTexto);
        contenidoInferior.getChildren().add(botonesYMazo);

        return contenidoInferior;
    }

    private void repartirCartas() {
        if (cartas.size() >= 8) {
            System.out.println("Ya tienes 8 cartas en pantalla, no puedes repartir más.");
            return;
        }

        int cartasNecesarias = 8 - cartas.size();
        Set<String> cartasEnPantalla = new HashSet<>();

        for (Carta carta : cartas) {
            cartasEnPantalla.add(carta.numero() + "_" + carta.getPalo());
        }

        List<Carta> nuevasCartas = new ArrayList<>();
        while (nuevasCartas.size() < cartasNecesarias) {
            Carta carta = mazo.darCartas(1).get(0);
            String idCarta = carta.numero() + "_" + carta.getPalo();

            if (!cartasEnPantalla.contains(idCarta)) {
                nuevasCartas.add(carta);
                cartasEnPantalla.add(idCarta);
            }
        }

        if (!nuevasCartas.isEmpty()) {
            cartas.addAll(nuevasCartas);
            actualizarVisualCartas();
        }

        cartasRestantesText.setText(mazo.cartasRestantes() + "/52");
    }

    private void actualizarVisualCartas() {
        // Limpiar la visualización actual
        visualCartas.getChildren().clear();

        // Agregar las cartas nuevas
        for (Carta carta : cartas) {
            ImageView imagenCarta = new ImageView(new Image(Paths.get("src/main/java/edu/fiuba/algo3/resources/" + carta.numero() + "_" + carta.getPalo() + ".jpg").toUri().toString()));
            imagenCarta.setFitWidth(56);
            imagenCarta.setFitHeight(84);

            imagenCarta.setOnMouseClicked(event -> {
                if (cartasSeleccionadas.contains(carta)) {
                    cartasSeleccionadas.remove(carta);
                    imagenCarta.setStyle("-fx-effect: null;");
                } else if (cartasSeleccionadas.size() < 5) {
                    cartasSeleccionadas.add(carta);
                    imagenCarta.setStyle("-fx-effect: dropshadow(gaussian, blue, 10, 0.5, 0, 0);");
                } else {
                    System.out.println("No puedes seleccionar más de 5 cartas.");
                }
            });

            visualCartas.getChildren().add(imagenCarta);
        }
    }

    public BorderPane crearParteDerecha() {
        return parteDerecha;
    }
}

package edu.fiuba.algo3.vistas.pantalla;

import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.mano.Mano;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Locale;

public class ParteIzquierda {

    private final VBox parteIzquierda;
    private StackPane puntajeBox;
    private StackPane manoConSusCaracteristicasBox;
    private StackPane puntajeAcumuladoBox;
    private StackPane turnosBox;
    private StackPane descartesBox;
    private StackPane rondaBox;

    public ParteIzquierda() {
        this.parteIzquierda = new VBox();
        parteIzquierda.setAlignment(Pos.TOP_CENTER);
        parteIzquierda.setSpacing(15);
        parteIzquierda.setPadding(new Insets(10, 10, 10, 5));
        Juego juego = Juego.getInstance();

        // Estilo y colores definidos
        String estiloTextoBlanco = "-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: white;";

        // Sección puntaje ronda
        VBox puntajeSection = new VBox();
        puntajeSection.setAlignment(Pos.CENTER);
        puntajeSection.setSpacing(5);

        String puntajeMin = String.valueOf(juego.puntajeNecesarioRonda());
        puntajeBox = crearCuadroConValor("Puntaje para avanzar", puntajeMin, 100, 200, "#444444", "#666666");

        puntajeSection.getChildren().add(puntajeBox);

        // Puntaje acumulado
        String puntajeRonda = String.valueOf(juego.puntajeRonda());
        puntajeAcumuladoBox = crearCuadroConValor("Puntaje Ronda", puntajeRonda, 100, 200, "#333333", "#555555");

        // Marcador de cartas
        VBox marcadorSection = new VBox();
        marcadorSection.setAlignment(Pos.CENTER);
        marcadorSection.setSpacing(5);

        HBox valoresCartas = new HBox();
        valoresCartas.setAlignment(Pos.CENTER);
        valoresCartas.setSpacing(10);

        Label valor1 = new Label("0");
        valor1.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #104ec1;");

        Label multiplicador = new Label("x");
        multiplicador.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white;");

        Label valor2 = new Label("0");
        valor2.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #ec1111;");

        valoresCartas.getChildren().addAll(valor1, multiplicador, valor2);
        marcadorSection.getChildren().addAll(valoresCartas);
        manoConSusCaracteristicasBox = crearCuadroConFondo(marcadorSection, 100, 200, "#333333");

        // Turnos y descartes
        HBox turnosDescartes = new HBox();
        turnosDescartes.setAlignment(Pos.CENTER);
        turnosDescartes.setSpacing(10);

        String turnoActual = String.valueOf(juego.turnoActual());
        String turnoTotales = String.valueOf(juego.turnosTotales());
        String descartesActuales = String.valueOf(juego.descartesActuales());
        String descartesTotales = String.valueOf(juego.descartesDisponibles());
        turnosBox = crearCuadroConValor("Turnos", turnoActual + " / " + turnoTotales, 80, 100, "#444444", "#666666");
        descartesBox = crearCuadroConValor("Descartes", descartesActuales + " / " + descartesTotales, 80, 100, "#444444", "#666666");

        turnosDescartes.getChildren().addAll(turnosBox, descartesBox);

        // Ronda y dinero
        HBox rondaYnombre = new HBox();
        rondaYnombre.setAlignment(Pos.CENTER);
        rondaYnombre.setSpacing(10);

        String nombreJugador = juego.getNombreJugador();
        StackPane nombre = crearCuadroConValor("Nombre", nombreJugador, 70, 100, "#444444", "#666666");
        String rondaActual = String.valueOf(juego.rondaActual());
        rondaBox = crearCuadroConValor("Ronda", rondaActual+ " / 8", 70, 100, "#444444", "#666666");

        rondaYnombre.getChildren().addAll(nombre, rondaBox);

        // Agregar todo al contenedor principal
        parteIzquierda.getChildren().addAll(
                puntajeSection,
                puntajeAcumuladoBox,
                manoConSusCaracteristicasBox,
                turnosDescartes,
                rondaYnombre
        );
    }

    public VBox crearParteIzquierda() {
        return parteIzquierda;
    }

    public void cuadroParaManoPorJugar(String nombre, String puntos, String multiplicador){
        manoConSusCaracteristicasBox.getChildren().clear();

        VBox marcadorSection = new VBox();

        marcadorSection.setAlignment(Pos.CENTER);
        marcadorSection.setSpacing(5);

        if (!nombre.isEmpty()) {
            Label manoNombre = new Label(nombre.toUpperCase(Locale.ROOT));
            manoNombre.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: white;");
            marcadorSection.getChildren().addAll(manoNombre);
        }

        HBox valoresCartas = new HBox();
        valoresCartas.setAlignment(Pos.CENTER);
        valoresCartas.setSpacing(10);

        Label valor1 = new Label(puntos);
        valor1.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #104ec1;");
        Label medio = null;
        medio = new Label("x");
        medio.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white;");

        Label valor2 = new Label(multiplicador);
        valor2.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #ec1111;");

        valoresCartas.getChildren().addAll(valor1, medio, valor2);
        marcadorSection.getChildren().addAll(valoresCartas);

        Rectangle fondo = new Rectangle(200, 100);
        fondo.setArcWidth(10);
        fondo.setArcHeight(10);
        fondo.setFill(Color.web("#333333"));
        fondo.setStroke(Color.BLACK);
        fondo.setStrokeWidth(2);

        manoConSusCaracteristicasBox.getChildren().setAll(fondo, marcadorSection);
    }

    private static StackPane crearCuadroConFondo(Node contenido, int alto, int ancho, String colorFondo) {
        Rectangle fondo = new Rectangle(ancho, alto);
        fondo.setArcWidth(10);
        fondo.setArcHeight(10);
        fondo.setFill(Color.web(colorFondo));
        fondo.setStroke(Color.BLACK);
        fondo.setStrokeWidth(2);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(fondo, contenido);
        return stackPane;
    }

    private StackPane crearCuadroConValor(String label, String valor, int alto, int ancho, String colorFondo, String colorValor) {
        // Fondo del contenedor principal
        Rectangle fondoLabel = new Rectangle(ancho, alto);
        fondoLabel.setArcWidth(10);
        fondoLabel.setArcHeight(10);
        fondoLabel.setFill(Color.web(colorFondo));
        fondoLabel.setStroke(Color.BLACK);
        fondoLabel.setStrokeWidth(1);

        // Texto principal
        Label textoLabel = new Label(label);
        textoLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: white; -fx-font-weight: bold;");

        // Fondo para el valor numérico
        Rectangle fondoValor = new Rectangle(ancho - 20, alto / 2);
        fondoValor.setArcWidth(10);
        fondoValor.setArcHeight(10);
        fondoValor.setFill(Color.web(colorValor));
        fondoValor.setStroke(Color.BLACK);
        fondoValor.setStrokeWidth(1);

        // Texto del valor
        Label textoValor = new Label(valor);
        textoValor.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        StackPane contenedorValor = new StackPane(fondoValor, textoValor);
        contenedorValor.setMaxSize(ancho - 20, alto / 2);

        VBox contenido = new VBox(textoLabel, contenedorValor);
        contenido.setAlignment(Pos.CENTER);
        contenido.setSpacing(5);

        return new StackPane(fondoLabel, contenido);
    }

    public void actualizar() {
        // Asumiendo que tienes un Label o un Text para mostrar el puntaje de la ronda
        Juego juego = Juego.getInstance();
        this.puntajeAcumuladoBox.getChildren().clear();// Limpiar contenido anterior
        this.puntajeBox.getChildren().clear();
        this.turnosBox.getChildren().clear();
        this.descartesBox.getChildren().clear();
        this.rondaBox.getChildren().clear();
        this.puntajeAcumuladoBox.getChildren().add(crearCuadroConValor("Puntaje Ronda", String.valueOf(juego.puntajeRonda()), 100, 200, "#333333", "#555555"));
        this.puntajeBox.getChildren().add(crearCuadroConValor("Puntaje Min", String.valueOf(juego.puntajeNecesarioRonda()), 100, 200, "#444444", "#666666"));
        this.turnosBox.getChildren().add(crearCuadroConValor("Turnos", juego.turnoActual() + " / " + juego.turnosTotales(), 80, 100, "#444444", "#666666"));
        this.descartesBox.getChildren().add(crearCuadroConValor("Descartes", juego.descartesActuales() + " / " + juego.descartesDisponibles(), 80, 100, "#444444", "#666666"));
        this.rondaBox.getChildren().add(crearCuadroConValor("Round", juego.rondaActual()+ " / 8", 70, 100, "#444444", "#666666"));
    }

}

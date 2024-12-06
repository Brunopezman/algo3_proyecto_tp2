package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.mano.Mano;
import edu.fiuba.algo3.vistas.pantalla.PantallaFinal;
import edu.fiuba.algo3.vistas.pantalla.ParteDerecha;
import edu.fiuba.algo3.vistas.pantalla.ParteIzquierda;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.List;

public class BotonJugarManoHandler implements EventHandler<ActionEvent> {
    private static final String MENSAJE_GANASTE = "GANASTE";
    private static final String MENSAJE_PERDISTE = "PERDISTE";
    private final Juego juego;
    private final List<Carta> cartasSeleccionadas;
    private final ParteIzquierda parteIzquierda;
    private Text cartasRestantesText;

    public BotonJugarManoHandler(Juego juego, List<Carta> cartasSeleccionadas, ParteIzquierda parteIzquierda, Text cartasRestantesText) {
        this.juego = juego;
        this.cartasSeleccionadas = cartasSeleccionadas;
        this.parteIzquierda = parteIzquierda;
        this.cartasRestantesText = cartasRestantesText;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (cartasSeleccionadas.size() == 5) {
            Mano mano = juego.queManoEs(cartasSeleccionadas); // Se debe almacenar dado que se lo pasaremos por parametro a parteIzquierda.actualizar() para que pueda actualizar tambien el bloque que muestra que Mano es junto con su respectivo multiplicador.
            juego.jugarMano(cartasSeleccionadas, mano);
            juego.quitarCartasUsadas(cartasSeleccionadas);
            juego.repartirCartasJugador(cartasSeleccionadas.size());
            juego.avanzarTurno();

            if (!juego.avanzarRonda()) {
                String mensajeFinal;
                if (juego.seGanoPartida()) {
                    mensajeFinal = MENSAJE_GANASTE;
                } else {
                    mensajeFinal = MENSAJE_PERDISTE;
                }
                mostrarPantallaFinal(mensajeFinal); // Muestra el mensaje final
            }
            cartasSeleccionadas.clear();
            parteIzquierda.actualizar();
            ParteDerecha.actualizarVisualCartas(cartasSeleccionadas);
        } else {
            System.out.println("No has seleccionado ninguna carta.");
        }
    }

    private void mostrarPantallaFinal(String mensaje) {
        PantallaFinal pantallaFinal = new PantallaFinal(mensaje);

        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL); // Hace que sea modal
        popupStage.setTitle("Resultado de la Partida");

        Scene scene = new Scene(pantallaFinal, 400, 200); // Tamaño del pop-up
        popupStage.setScene(scene);

        popupStage.centerOnScreen();
        popupStage.showAndWait(); // Espera a que se cierre antes de continuar
    }


}

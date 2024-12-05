package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.vistas.pantalla.ParteDerecha;
import edu.fiuba.algo3.vistas.pantalla.ParteIzquierda;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class BotonJugarManoHandler implements EventHandler<ActionEvent> {
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
        if (!cartasSeleccionadas.isEmpty()) {
            juego.jugarMano(cartasSeleccionadas, juego.queManoEs(cartasSeleccionadas));
            //cartasRestantesText = new Text(juego.getMazo().cartasRestantes() + "/52");
            juego.quitarCartasUsadas(cartasSeleccionadas);
            juego.repartirCartasJugador(cartasSeleccionadas.size());
            juego.avanzarTurno();
            boolean estado = juego.avanzarRonda();
            if (!estado) {
                if (juego.seGanoPartida()){
                    ///MOSTRAR MENSAJE DE "GANO PARTIDA"
                }
                ///MOSTRAR MENSAJE DE "PERDIO PARTIDA"
            }
            cartasSeleccionadas.clear();
            parteIzquierda.actualizar();
            ParteDerecha.actualizarVisualCartas(cartasSeleccionadas);
        } else {
            System.out.println("No has seleccionado ninguna carta.");
        }
    }
}

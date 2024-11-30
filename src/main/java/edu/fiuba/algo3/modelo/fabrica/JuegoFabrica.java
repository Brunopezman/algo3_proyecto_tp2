package edu.fiuba.algo3.modelo.fabrica;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.comodin.Comodin;
import edu.fiuba.algo3.modelo.dtos.*;
import edu.fiuba.algo3.modelo.juego.Mazo;
import edu.fiuba.algo3.modelo.juego.Ronda;
import edu.fiuba.algo3.modelo.juego.Tienda;
import edu.fiuba.algo3.modelo.lector.LectorJson;
import edu.fiuba.algo3.modelo.tarot.Tarot;

import java.util.ArrayList;
import java.util.List;

public class JuegoFabrica {
    private final static String RONDAS = "rondas";
    private final static String MAZO = "mazo";

    private LectorJson archivo;

    public JuegoFabrica(String rutaDelArchivo){
        this.archivo = new LectorJson(rutaDelArchivo);
    }

    public List<Ronda> inicializarRondas(){
        List<RondaDTO> rondasInformacion = archivo.obtenerInformacionDe(RONDAS);
        List<Ronda> rondas = new ArrayList<>();
        for (RondaDTO rondaParaCargar : rondasInformacion){
            Ronda nuevaRonda =  RondaFabrica.inicializar(rondaParaCargar);
            rondas.add(nuevaRonda);
        }
        return rondas;
    }

    public Mazo inicializarMazo(){
        List<CartaDTO> mazoInformacion = archivo.obtenerInformacionDe(MAZO);
        List<Carta> nuevasCartas = new ArrayList<>();
        for (CartaDTO cartaParaCargar : mazoInformacion){
            Carta nuevaCarta = CartaFabrica.inicializar(cartaParaCargar);
            nuevasCartas.add(nuevaCarta);
        }
        return new Mazo(nuevasCartas);
    }
}

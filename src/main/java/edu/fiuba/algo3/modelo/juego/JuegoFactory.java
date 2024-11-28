package edu.fiuba.algo3.modelo.juego;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.comodin.Comodin;
import edu.fiuba.algo3.modelo.dtos.*;
import edu.fiuba.algo3.modelo.lector.LectorJson;
import edu.fiuba.algo3.modelo.tarot.Tarot;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JuegoFactory {
    private final static String RONDAS = "rondas";
    private final static String MAZO = "mazo";
    private final static String PROBABILIDAD = "1 en";

    private LectorJson archivo;

    public JuegoFactory(String rutaDelArchivo){
        this.archivo = new LectorJson(rutaDelArchivo);
    }

    public List<Ronda> inicializarRondas(){
        List<RondaDTO> rondasInformacion = archivo.obtenerInformacionDe(RONDAS);
        List<Ronda> rondas = new ArrayList<>();
        for (RondaDTO rondaParaCargar : rondasInformacion){
            Ronda nuevaRonda =  this.inicializarUnaRonda(rondaParaCargar);
            rondas.add(nuevaRonda);
        }
        return rondas;
    }

    public Mazo inicializarMazo(){
        List<CartaDTO> mazoInformacion = archivo.obtenerInformacionDe(MAZO);
        List<Carta> nuevasCartas = new ArrayList<>();
        for (CartaDTO cartaParaCargar : mazoInformacion){
            Carta nuevaCarta = this.inicializarCarta(cartaParaCargar);
            nuevasCartas.add(nuevaCarta);
        }
        return new Mazo(nuevasCartas);
    }

    private Ronda inicializarUnaRonda(RondaDTO rondaInformacion){
        int nro = rondaInformacion.getNro();
        int manos = rondaInformacion.getTurnos();
        int descartes = rondaInformacion.getDescartes();
        int puntajeAObtener = rondaInformacion.getPuntajeASuperar();
        Tienda tienda = this.inicializarTienda(rondaInformacion.getTienda());
        return new Ronda(nro,manos,descartes,puntajeAObtener,tienda);
    }

    private Tienda inicializarTienda(TiendaDTO tiendaInformacion){
        List<Comodin> comodines = new ArrayList<>();
        for (ComodinDTO comodinParaCargar : tiendaInformacion.getComodines()){
            Comodin nuevoComodin = this.inicializarComodin(comodinParaCargar);
            comodines.add(nuevoComodin);
        }
        List<Tarot> tarots = new ArrayList<>();
        for (TarotDTO tarotParaCargar : tiendaInformacion.getTarots()){
            Tarot nuevoTarot = this.inicializarTarot(tarotParaCargar);
            tarots.add(nuevoTarot);
        }
        Carta nuevaCarta = this.inicializarCarta(tiendaInformacion.getCarta());
        return new Tienda(comodines,tarots,nuevaCarta);

    }

    private Comodin inicializarComodin(ComodinDTO comodinInformacion){
        String nombre = comodinInformacion.getNombre();
        String descripcion = comodinInformacion.getDescripcion();
        String activacion = this.definirActivacion(comodinInformacion.getActivacion());
        int puntajeDelComodin = comodinInformacion.getEfecto().getPuntaje();
        int multiplicadorDelComodin = comodinInformacion.getEfecto().getMultiplicador();
        return Comodin.con(nombre,descripcion,activacion,puntajeDelComodin,multiplicadorDelComodin);
    }

    /////////////////////////////
    // A CHEQUEAR ESTA FUNCION //
    /////////////////////////////
    private String definirActivacion(JsonElement activacionInformacion){
        if (activacionInformacion.isJsonPrimitive()) {
            // Caso 1: Es una cadena (e.g., "Descarte")
            return activacionInformacion.getAsString();
        } else if (activacionInformacion.isJsonObject()) {
            // Caso 2: Es un objeto JSON (e.g., { "Mano Jugada": "color" } o { "1 en": 250 })
            JsonObject activacionObj = activacionInformacion.getAsJsonObject();
            String clave = activacionObj.entrySet().iterator().next().getKey();
            return activacionObj.get(clave).getAsString();
        } else {
            throw new IllegalArgumentException("Tipo inesperado en activación: " + activacionInformacion);
        }
    }

    private Tarot inicializarTarot(TarotDTO tarotInformacion){
        String nombre = tarotInformacion.getNombre();
        String descripcion = tarotInformacion.getDescripcion();
        int puntajeDelTarot = tarotInformacion.getEfecto().getPuntaje();
        int multiplicadorDelTarot = tarotInformacion.getEfecto().getMultiplicador();
        String sobreQueAfecta = tarotInformacion.getSobre();
        String ejemplarAAfectar = tarotInformacion.getEjemplar();
        return Tarot.con(nombre, descripcion, puntajeDelTarot, multiplicadorDelTarot, sobreQueAfecta, ejemplarAAfectar);
    }

    private Carta inicializarCarta(CartaDTO cartaInformacion){
        String nombre = cartaInformacion.getNombre();
        String palo = cartaInformacion.getPalo();
        String numero = cartaInformacion.getNumero();
        int puntos = cartaInformacion.getPuntos();
        //String multiplicador = cartaInformacion.getMultiplicador();
        String consecutivo = this.definirConsecutivo(numero);
        return new Carta(nombre,palo,numero,consecutivo,puntos);
    }

    private String definirConsecutivo(String numero) {
        switch (numero.toUpperCase()) {
            case "AS": return "2";
            case "2": return "3";
            case "3": return "4";
            case "4": return "5";
            case "5" : return "6";
            case "6": return "7";
            case "7": return "8";
            case "8": return "9";
            case "9": return "10";
            case "10": return"Jota";
            case "JOTA": return "Reina";
            case "REINA": return "Rey";
            case "REY": return "As"; // No hay consecutivo para el Rey
            default: throw new IllegalArgumentException("Valor no válido: " + numero);
        }
    }
}

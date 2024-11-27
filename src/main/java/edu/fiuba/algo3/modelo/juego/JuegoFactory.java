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
    private static String RONDAS = "rondas";
    private static String MAZO = "mazo";

    private LectorJson archivo;

    public JuegoFactory(String rutaDelArchivo){
        this.archivo = new LectorJson(rutaDelArchivo);
    }

    public List<Ronda> inicializarRondas(){
        List<RondaDTO> rondasInformacion = archivo.obtenerInformacionDe(RONDAS);
        List<Ronda> rondas = new ArrayList<>();
        for (RondaDTO rondaParaCargar : rondasInformacion){
            int nro = rondaParaCargar.getNro();
            int manos = rondaParaCargar.getTurnos();
            int descartes = rondaParaCargar.getDescartes();
            int puntajeAObtener = rondaParaCargar.getPuntajeASuperar();
            Tienda tienda = this.inicializarTienda(rondaParaCargar.getTienda());
            Ronda nuevaRonda = Ronda(nro,manos,descartes,puntajeAObtener,tienda);
            rondas.add(nuevaRonda);
        }
        return rondas;
    }

    public Mazo inicializarMazo(){
        List<CartaDTO> mazoInformacion = archivo.obtenerInformacionDe(MAZO);
        List<Carta> nuevasCartas = new ArrayList<>();
        for (CartaDTO cartaParaCargar : mazoInformacion){
            String nombre = cartaParaCargar.getNombre();
            String palo = cartaParaCargar.getPalo();
            String numero = cartaParaCargar.getNumero();
            int puntos = cartaParaCargar.getPuntos();
            String multiplicador = cartaParaCargar.getMultiplicador();
            Carta nuevaCarta = new Carta(nombre,palo,numero,puntos,multiplicador);
            nuevasCartas.add(nuevaCarta);
        }
        return new Mazo(nuevasCartas);
    }

    private Tienda inicializarTienda(TiendaDTO tiendaInformacion){
        List<Comodin> comodines = new ArrayList<>();
        for (ComodinDTO comodinParaCargar : tiendaInformacion.getComodines()){
            String nombre = comodinParaCargar.getNombre();
            String descripcion = comodinParaCargar.getDescripcion();
            Object activacion = this.definirActivacion(comodinParaCargar.getActivacion());
            int puntajeDelComodin = comodinParaCargar.getEfecto().getPuntaje();
            int multiplicadorDelComodin = comodinParaCargar.getEfecto().getMultiplicador();
            Comodin nuevoComodin = Comodin(nombre,descripcion,activacion,puntajeDelComodin,multiplicadorDelComodin);
            comodines.add(nuevoComodin);
        }
        List<Tarot> tarots = new ArrayList<>();
        for (TarotDTO tarotParaCargar : tiendaInformacion.getTarots()){
            String nombre = tarotParaCargar.getNombre();
            String descripcion = tarotParaCargar.getDescripcion();
            int puntajeDelTarot = tarotParaCargar.getEfecto().getPuntaje();
            int multiplicadorDelTarot = tarotParaCargar.getEfecto().getMultiplicador();
            String sobreQueAfecta = tarotParaCargar.getSobre();
            String ejemplarAAfectar = tarotParaCargar.getEjemplar();
            Tarot nuevoTarot = Tarot(nombre,descripcion,puntajeDelTarot,multiplicadorDelTarot,sobreQueAfecta,ejemplarAAfectar);
            tarots.add(nuevoTarot);
        }
        String nombre = tiendaInformacion.getCarta().getNombre();
        String palo = tiendaInformacion.getCarta().getPalo();
        String numero = tiendaInformacion.getCarta().getNumero();
        int puntos = tiendaInformacion.getCarta().getPuntos();
        String multiplicador = tiendaInformacion.getCarta().getMultiplicador();
        Carta nuevaCarta = new Carta(nombre,palo,numero,puntos,multiplicador);
        return new Tienda(comodines,tarots,nuevaCarta);

    }

    /////////////////////////////
    // A CHEQUEAR ESTA FUNCION //
    /////////////////////////////
    private Object definirActivacion(JsonElement activacionInformacion){
        if (activacionInformacion.isJsonPrimitive()) {
            // Caso 1: Es una cadena (e.g., "Descarte")
            return activacionInformacion.getAsString();
        } else if (activacionInformacion.isJsonObject()) {
            // Caso 2: Es un objeto JSON (e.g., { "Mano Jugada": "color" } o { "1 en": 250 })
            JsonObject activacionObj = activacionInformacion.getAsJsonObject();
            // Puedes devolver directamente el JsonObject o procesarlo a un Map<String, Object> si lo prefieres
            return activacionObj.entrySet().stream()
                    .collect(Collectors.toMap(
                            entry -> entry.getKey(),
                            entry -> entry.getValue().isJsonPrimitive()
                                    ? entry.getValue().getAsString()
                                    : entry.getValue().toString()
                    ));
        } else {
            throw new IllegalArgumentException("Tipo inesperado en activación: " + activacionInformacion);
        }
    }
}

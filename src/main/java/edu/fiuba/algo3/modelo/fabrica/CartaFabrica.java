package edu.fiuba.algo3.modelo.fabrica;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.dtos.CartaDTO;

public class CartaFabrica {
    public static Carta inicializar(CartaDTO informacion){
        String nombre = informacion.getNombre();
        String palo = informacion.getPalo();
        String numero = informacion.getNumero();
        int puntos = informacion.getPuntos();
        //String multiplicador = cartaInformacion.getMultiplicador();
        String consecutivo = null;
        switch (numero) {
            case "As": consecutivo = "2"; break;
            case "2": consecutivo =  "3"; break;
            case "3": consecutivo = "4"; break;
            case "4": consecutivo = "5"; break;
            case "5": consecutivo = "6"; break;
            case "6": consecutivo = "7"; break;
            case "7": consecutivo = "8"; break;
            case "8": consecutivo = "9"; break;
            case "9": consecutivo = "10"; break;
            case "10": consecutivo ="Jota"; break;
            case "Jota": consecutivo = "Reina"; break;
            case "Reina": consecutivo = "Rey"; break;
            case "Rey": consecutivo = "As"; break;
            default: throw new IllegalArgumentException("Valor no válido: " + numero);
        }
        return new Carta(nombre,palo,numero,consecutivo,puntos);
    }
}

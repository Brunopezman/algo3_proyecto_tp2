package edu.fiuba.algo3.modelo.fabrica;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.comodin.Comodin;
import edu.fiuba.algo3.modelo.dtos.ComodinBaseDTO;
import edu.fiuba.algo3.modelo.dtos.ComodinCombinacionDTO;

import java.util.ArrayList;
import java.util.List;


public class ComodinFabrica {
    public static Comodin inicializar(ComodinBaseDTO informacion){
//        String nombre = informacion.getNombre();
//        String descripcion = informacion.getDescripcion();
//        JsonElement activacionInfo = informacion.getActivacion();
//        String activacion = null;
//        if (activacionInfo.isJsonPrimitive()) {
//            activacion = activacionInfo.getAsString();
//        } else if (activacionInfo.isJsonObject()) {
//            JsonObject activacionObj = activacionInfo.getAsJsonObject();
//            String clave = activacionObj.entrySet().iterator().next().getKey();
//            activacion = activacionObj.get(clave).getAsString();
//        } else {
//            throw new IllegalArgumentException("Tipo inesperado en activación: " + activacionInfo);
//        }
//        int puntajeDelComodin = informacion.getEfecto().getPuntaje();
//        int multiplicadorDelComodin = informacion.getEfecto().getMultiplicador();
//        String activacion = "Hola";
//        int puntajeDelComodin = 1;
//        int multiplicadorDelComodin = 2;
        String nombre = informacion.getNombre();
        String descripcion = informacion.getDescripcion();
        String activacion = null;
        int puntajeDelComodin = 0;
        int multiplicadorDelComodin = 0;
        List<Comodin> comodinesInternos = new ArrayList<>();
        if (informacion instanceof ComodinCombinacionDTO) {
            for (ComodinBaseDTO infoComodin : informacion.getComodines()){
                Comodin comodin = ComodinFabrica.interno(infoComodin);
                comodinesInternos.add(comodin);
            }
        }else {
            activacion = ComodinFabrica.darActivacion(informacion.getActivacion());
            puntajeDelComodin = informacion.getEfecto().getPuntaje();
            multiplicadorDelComodin = informacion.getEfecto().getMultiplicador();
        }
        return Comodin.con(nombre,descripcion,activacion,puntajeDelComodin,multiplicadorDelComodin,comodinesInternos);
    }

    private static Comodin interno(ComodinBaseDTO informacion){
        List<Comodin> vacio = new ArrayList<>();
        String nombre = informacion.getNombre();
        String descripcion = informacion.getDescripcion();
        //JsonElement activacionInfo = informacion.getActivacion();
        String activacion = ComodinFabrica.darActivacion(informacion.getActivacion());
        /*
        if (activacionInfo.isJsonPrimitive()) {
            activacion = activacionInfo.getAsString();
        } else if (activacionInfo.isJsonObject()) {
            JsonObject activacionObj = activacionInfo.getAsJsonObject();
            String clave = activacionObj.entrySet().iterator().next().getKey();
            activacion = activacionObj.get(clave).getAsString();
        } else {
            throw new IllegalArgumentException("Tipo inesperado en activación: " + activacionInfo);
        }
        */
        int puntajeDelComodin = informacion.getEfecto().getPuntaje();
        int multiplicadorDelComodin = informacion.getEfecto().getMultiplicador();
        return Comodin.con(nombre,descripcion,activacion,puntajeDelComodin,multiplicadorDelComodin,vacio);
    }

    private static String darActivacion(JsonElement activacionInfo){
        String activacion;
        if (activacionInfo.isJsonPrimitive()) {
            activacion = activacionInfo.getAsString();
        } else if (activacionInfo.isJsonObject()) {
            JsonObject activacionObj = activacionInfo.getAsJsonObject();
            String clave = activacionObj.entrySet().iterator().next().getKey();
            activacion = activacionObj.get(clave).getAsString();
        } else {
            throw new IllegalArgumentException("Tipo inesperado en activación: " + activacionInfo);
        }
        return activacion;
    }
}

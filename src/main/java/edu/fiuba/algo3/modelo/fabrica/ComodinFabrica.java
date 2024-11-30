package edu.fiuba.algo3.modelo.fabrica;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.comodin.Comodin;
import edu.fiuba.algo3.modelo.dtos.ComodinBaseDTO;



public class ComodinFabrica {
    public static Comodin inicializar(ComodinBaseDTO informacion){
        String nombre = informacion.getNombre();
        String descripcion = informacion.getDescripcion();
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
        String activacion = "Hola";
        int puntajeDelComodin = 1;
        int multiplicadorDelComodin = 2;
        return Comodin.con(nombre,descripcion,activacion,puntajeDelComodin,multiplicadorDelComodin);

    }
}

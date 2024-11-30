package edu.fiuba.algo3.modelo.fabrica;

import edu.fiuba.algo3.modelo.dtos.TarotDTO;
import edu.fiuba.algo3.modelo.tarot.Tarot;

public class TarotFabrica {
    public static Tarot inicializar(TarotDTO informacion){
        String nombre = informacion.getNombre();
        String descripcion = informacion.getDescripcion();
        int puntajeDelTarot = informacion.getEfecto().getPuntaje();
        int multiplicadorDelTarot = informacion.getEfecto().getMultiplicador();
        String sobreQueAfecta = informacion.getSobre();
        String ejemplarAAfectar = informacion.getEjemplar();
        return Tarot.con(nombre, descripcion, puntajeDelTarot, multiplicadorDelTarot, sobreQueAfecta, ejemplarAAfectar);
    }
}

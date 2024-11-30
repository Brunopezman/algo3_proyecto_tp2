package edu.fiuba.algo3.modelo.fabrica;

import edu.fiuba.algo3.modelo.dtos.RondaDTO;
import edu.fiuba.algo3.modelo.juego.Ronda;
import edu.fiuba.algo3.modelo.juego.Tienda;

public class RondaFabrica {
    public static Ronda inicializar(RondaDTO infromacion){
        int nro = infromacion.getNro();
        int manos = infromacion.getTurnos();
        int descartes = infromacion.getDescartes();
        int puntajeAObtener = infromacion.getPuntajeASuperar();
        Tienda tienda = TiendaFabrica.inicializar(infromacion.getTienda());
        return new Ronda(nro,manos,descartes,puntajeAObtener,tienda);
    }
}

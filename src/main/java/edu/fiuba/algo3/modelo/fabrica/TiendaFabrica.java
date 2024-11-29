package edu.fiuba.algo3.modelo.fabrica;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.comodin.Comodin;
import edu.fiuba.algo3.modelo.dtos.ComodinDTO;
import edu.fiuba.algo3.modelo.dtos.TarotDTO;
import edu.fiuba.algo3.modelo.dtos.TiendaDTO;
import edu.fiuba.algo3.modelo.juego.Tienda;
import edu.fiuba.algo3.modelo.tarot.Tarot;

import java.util.ArrayList;
import java.util.List;

public class TiendaFabrica {
    public static Tienda inicializar(TiendaDTO informacion){
        //ComodinFabrica fabricaComodin = new ComodinFabrica();

        List<Comodin> comodines = new ArrayList<>();
        for (ComodinDTO comodinParaCargar : informacion.getComodines()){
            Comodin nuevoComodin = ComodinFabrica.inicializar(comodinParaCargar);
            comodines.add(nuevoComodin);
        }
        List<Tarot> tarots = new ArrayList<>();
        for (TarotDTO tarotParaCargar : informacion.getTarots()){
            Tarot nuevoTarot = TarotFabrica.inicializar(tarotParaCargar);
            tarots.add(nuevoTarot);
        }
        Carta nuevaCarta = CartaFabrica.inicializar(informacion.getCarta());
        return new Tienda(comodines,tarots,nuevaCarta);
    }
}

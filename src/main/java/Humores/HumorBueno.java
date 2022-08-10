package Humores;

import Jugadores.Jugador;
import Perks.Perk;

public class HumorBueno extends Humor {

    public void comprarPerk(Perk perk, Jugador jugador) throws Exception {
        if(jugador.tieneDinero(perk.costo())) {
            jugador.realizarCompraDePerk(perk);
        } else {
            jugador.ponerDeMalHumor();
            throw new Exception("Dinero insuficiente");
        }
    }

    public boolean estaDeBuenHumor() {
        return true;
    }
}

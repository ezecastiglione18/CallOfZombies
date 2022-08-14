package Humores;

import Jugadores.Jugador;
import Perks.Perk;

public class HumorBueno extends Humor {
    public String discriminante = "buen humor";

    public void comprarPerk(Perk perk, Jugador jugador) throws Exception {
        if(jugador.tieneDinero(perk.costo())) {
            jugador.realizarCompraDePerk(perk);
        } else {
            this.cambiarHumor(jugador);
            //throw new Exception("Dinero insuficiente");
        }
    }

    @Override
    public void cambiarHumor(Jugador jugador) {
        jugador.ponerDeMalHumor();
    }

    public boolean estaDeBuenHumor() {
        return true;
    }
}

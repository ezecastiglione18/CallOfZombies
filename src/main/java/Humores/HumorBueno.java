package Humores;

import Jugadores.Jugador;
import Perks.Perk;

public class HumorBueno extends Humor {

    public void comprarPerk(Perk perk, Jugador jugador){
        if(jugador.tieneDinero(perk.costo())) {
            jugador.realizarCompraDePerk(perk);
        } else {
            this.cambiarHumor(jugador);
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

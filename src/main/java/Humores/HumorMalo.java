package Humores;

import Jugadores.Jugador;
import Perks.Perk;

public class HumorMalo extends Humor {
    public void comprarPerk(Perk perk, Jugador jugador) throws Exception {
        throw new Exception("No se puede comprar porque el jugador está de mal humor");
    }

    public boolean estaDeBuenHumor() {
        return false;
    }

    @Override
    public void cambiarHumor(Jugador jugador) {
        jugador.ponerDeBuenHumor();
    }
}

package Humores;

import Jugadores.Jugador;
import Perks.Perk;

abstract public class Humor {
    abstract public void comprarPerk(Perk perk, Jugador jugador) throws Exception;

    abstract public boolean estaDeBuenHumor();
}


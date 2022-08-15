package Humores;

import Jugadores.Jugador;
import Perks.Perk;

import javax.persistence.Entity;


abstract public class Humor {
    abstract public void comprarPerk(Perk perk, Jugador jugador) throws Exception;

    abstract public boolean estaDeBuenHumor();

    abstract public void cambiarHumor(Jugador jugador);
}


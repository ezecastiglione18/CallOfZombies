package Humores;

import Jugadores.Jugador;
import Perks.Perk;

import javax.persistence.Entity;

/*@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminante", discriminatorType = DiscriminatorType.STRING)*/
abstract public class Humor {
    public String discriminante;
    abstract public void comprarPerk(Perk perk, Jugador jugador) throws Exception;

    abstract public boolean estaDeBuenHumor();

    abstract public void cambiarHumor(Jugador jugador);
}


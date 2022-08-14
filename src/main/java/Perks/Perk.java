package Perks;
import Jugadores.Jugador;

import javax.persistence.*;

/*@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminante", discriminatorType = DiscriminatorType.STRING)*/
abstract public class Perk {
     public int costo;
     public String discriminante;

     //@Transient
     public int puntosAdicionales;

     public abstract int costo();

     public abstract void sumarPuntosPorMatar(Jugador jugador);
}


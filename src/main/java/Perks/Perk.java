package Perks;
import Jugadores.Jugador;

abstract public class Perk {
     public int costo;

     public int puntosAdicionales;

     public abstract int costo();

     public abstract void sumarPuntosPorMatar(Jugador jugador);
}


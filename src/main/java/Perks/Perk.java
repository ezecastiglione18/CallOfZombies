package Perks;
import Jugadores.Jugador;

abstract public class Perk {
     private int costo;
     private int puntosAdicionales;

     public int costo() {
          return costo;
     }

     public abstract void recompensarKill(Jugador jugador);
}


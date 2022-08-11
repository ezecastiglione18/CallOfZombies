package Perks;

import Jugadores.Jugador;

public class Default extends Perk {
    private int costo = 0;
    public void sumarPuntosPorMatar(Jugador jugador) {
        jugador.sumarPuntos(1);
    }
}

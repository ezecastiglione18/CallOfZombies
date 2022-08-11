package Perks;

import Jugadores.Jugador;

public class Bronce extends Perk {
    private int costo = 700;

    public void sumarPuntosPorMatar(Jugador jugador) {
        jugador.sumarPuntos(5);
    }
}
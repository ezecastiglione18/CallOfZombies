package Perks;

import Jugadores.Jugador;

public class Oro extends Perk {
    private int costo = 3000;

    public void sumarPuntosPorMatar(Jugador jugador) {
        if(jugador.estaDeBuenHumor()) {
            jugador.sumarPuntos(50);
        } else {
            jugador.sumarPuntos(1);
        }
    }
}
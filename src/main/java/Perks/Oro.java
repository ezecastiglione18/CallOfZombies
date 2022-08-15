package Perks;

import Jugadores.Jugador;

public class Oro extends Perk {
    private int costo = 3000;

    @Override
    public int costo() {
        return this.costo;
    }

    public void sumarPuntosPorMatar(Jugador jugador) {
        if(jugador.estaDeBuenHumor()) {
            jugador.sumarPuntos(50);
        } else {
            jugador.sumarPuntos(1);
        }
    }
}
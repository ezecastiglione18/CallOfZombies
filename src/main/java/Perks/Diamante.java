package Perks;

import Jugadores.Jugador;

public class Diamante extends Perk {
    private int costo = 5000;
    public String discriminante = "diamante";

    @Override
    public int costo() {
        return this.costo;
    }

    public void sumarPuntosPorMatar(Jugador jugador) {
        if(jugador.estaDeBuenHumor()) {
            jugador.sumarPuntos(100);
        } else {
            jugador.sumarPuntos(1);
        }
    }
}

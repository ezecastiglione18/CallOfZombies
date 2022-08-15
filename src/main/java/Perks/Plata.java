package Perks;

import Jugadores.Jugador;

public class Plata extends Perk {
    private int costo = 1500;

    @Override
    public int costo() {
        return this.costo;
    }

    public void sumarPuntosPorMatar(Jugador jugador) {
        jugador.sumarPuntos(20);
    }
}

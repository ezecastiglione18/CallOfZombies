package Perks;

import Jugadores.Jugador;

public class Default extends Perk {
    private int costo = 0;
    public String discriminante = "default";

    @Override
    public int costo() {
        return this.costo;
    }

    public void sumarPuntosPorMatar(Jugador jugador) {
        jugador.sumarPuntos(1);
    }
}

package Perks;

import Jugadores.Jugador;

public class Plata extends Perk {
    private int costo = 1500;
    public String discriminante = "plata";

    @Override
    public int costo() {
        return this.costo;
    }

    public void sumarPuntosPorMatar(Jugador jugador) {
        jugador.sumarPuntos(20);
    }
}

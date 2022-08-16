package Perks;

import Jugadores.Jugador;

public class Default extends Perk {
    private static Default instancia = null;

    private int costo = 0;

    public static Default GetInstance() {
        if (instancia == null) {
            instancia = new Default();
        }
        return instancia;
    }

    @Override
    public int costo() {
        return this.costo;
    }

    public void sumarPuntosPorMatar(Jugador jugador) {
        jugador.sumarPuntos(1);
    }
}

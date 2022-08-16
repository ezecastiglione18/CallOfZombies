package Perks;

import Jugadores.Jugador;

public class Plata extends Perk {
    private static Plata instancia = null;
    private int costo = 1500;

    public static Plata GetInstance() {
        if (instancia == null) {
            instancia = new Plata();
        }
        return instancia;
    }

    @Override
    public int costo() {
        return this.costo;
    }

    public void sumarPuntosPorMatar(Jugador jugador) {
        jugador.sumarPuntos(20);
    }
}

package Perks;

import Jugadores.Jugador;

public class Oro extends Perk {
    private static Oro instancia = null;
    private int costo = 3000;

    public static Oro GetInstance() {
        if (instancia == null) {
            instancia = new Oro();
        }
        return instancia;
    }

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
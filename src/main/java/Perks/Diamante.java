package Perks;

import Jugadores.Jugador;

public class Diamante extends Perk {
    private static Diamante instancia = null;
    private int costo = 5000;

    public static Diamante GetInstance() {
        if (instancia == null) {
            instancia = new Diamante();
        }
        return instancia;
    }

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

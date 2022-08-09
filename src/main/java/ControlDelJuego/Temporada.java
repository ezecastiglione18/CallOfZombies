package ControlDelJuego;

import java.util.ArrayList;

public class Temporada {
    private static Temporada instancia = null;
    private ArrayList<String> premios;
    private Float ratioZombies;
    private Float ratioObjetos;

    public static Temporada GetInstance() {
        if (instancia == null) {
            instancia = new Temporada();
        }
        return instancia;
    }

    public int calcularPosicion() {
        // TODO
        return 0;
    }
}
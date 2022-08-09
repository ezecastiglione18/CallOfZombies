package ControlDelJuego;

import Jugadores.Equipo;
import javafx.util.Pair;
import java.util.ArrayList;

public class RepositorioPuntajes {
    private static RepositorioPuntajes instancia = null;
    private ArrayList<Pair<Equipo,Integer>> puntajes;

    public static RepositorioPuntajes GetInstance() {
        if (instancia == null) {
            instancia = new RepositorioPuntajes();
        }
        return instancia;
    }
    // TODO
}
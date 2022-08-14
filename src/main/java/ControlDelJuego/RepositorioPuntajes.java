package ControlDelJuego;

import Jugadores.Equipo;
import javafx.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import static java.util.Collections.reverseOrder;
import static java.util.Comparator.comparing;

public class RepositorioPuntajes {
    private static RepositorioPuntajes instancia = null;
    private ArrayList<Pair<Equipo,Integer>> puntajes;

    public static RepositorioPuntajes GetInstance() {
        if (instancia == null) {
            instancia = new RepositorioPuntajes();
        }
        return instancia;
    }
    public void agregarPartida(Equipo equipo, Integer puntaje){
        Pair<Equipo, Integer> nuevoPuntaje = new Pair<>(equipo, puntaje);
        this.puntajes.add(nuevoPuntaje);
        this.ordenarLista();
    }

    public void ordenarLista(){
        //OPCION 1
        Collections.sort(this.puntajes, Comparator.comparing(dupla -> dupla.getValue()));

        //OPCION 2
        final Comparator<Pair<Equipo, Integer>> c = reverseOrder(comparing(Pair::getValue));
        this.puntajes.stream().sorted(c);
    }
}
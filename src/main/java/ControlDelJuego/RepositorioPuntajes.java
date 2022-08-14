package ControlDelJuego;

import Jugadores.Equipo;
import javafx.util.Pair;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import static java.util.Collections.reverseOrder;
import static java.util.Comparator.comparing;

public class RepositorioPuntajes {
    private static RepositorioPuntajes instancia;
    public ArrayList<Pair<Equipo,Integer>> puntajes = new ArrayList<>();

    public static RepositorioPuntajes GetInstance() {
        if (instancia == null) {
            instancia = new RepositorioPuntajes();
        }
        return instancia;
    }
    public void agregarPartida(Equipo equipo, Integer puntaje){
        try{
            Pair<Equipo, Integer> nuevoPuntaje = new Pair<>(equipo, puntaje);
            this.puntajes.add(nuevoPuntaje);
            this.ordenarLista();
        }
        catch (Exception e){

        }
    }

    public ArrayList<Pair<Equipo, Integer>> getPuntajes(){
        return this.puntajes;
    }

    public void ordenarLista(){
        //OPCION 1
        Collections.sort(this.puntajes, comparing(p -> -p.getValue()));

        //OPCION 2
        //final Comparator<Pair<Equipo, Integer>> c = reverseOrder(comparing(Pair::getValue));
        //this.puntajes.stream().sorted(c);
    }
}
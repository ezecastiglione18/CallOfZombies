package ControlDelJuego;

import Objetos.Objeto;
import Zombies.Zombie;

import java.util.ArrayList;

public class Ronda {
    private static Ronda instancia = null;
    private int numeroDeRonda = 0;
    private ArrayList<Zombie> zombiesDeRonda;
    private ArrayList<Objeto> objetos;

    public static Ronda GetInstance() {
        if (instancia == null) {
            instancia = new Ronda();
        }
        return instancia;
    }

    public void iniciarNuevaRonda() {
        // TODO
    }

    private void crearZombies() {
        // TODO
    }

    private void crearObjetos() {
        // TODO
    }
}
package Objetos;

import Jugadores.Jugador;

abstract public class Objeto {
    NombreDeObjeto nombre;

    abstract public void reparar();

    abstract public void recibirDanio(int valor);

    abstract public int getVidaUtilOriginal();

    abstract public int getCantidadDeObjetos();

    abstract public int getVidaUtil();
}

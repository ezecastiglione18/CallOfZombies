package Objetos;

import Jugadores.Jugador;

public class ObjetoSimple extends Objeto{
    int vidaUtil = 25;
    int vidaUtilOriginal = 25;

    public void reparar(){
        this.vidaUtil = this.vidaUtilOriginal;
    }

    public void recibirDanio(int valor){
        if (this.vidaUtil - valor < 0){
            this.vidaUtil = 0;
        }
        else{
            this.vidaUtil -= valor;
        }
    }

    public int getVidaUtil(){
        return this.vidaUtil;
    }

    public int getVidaUtilOriginal(){
        return this.vidaUtilOriginal;
    }

    public int getCantidadDeObjetos(){
        return 1;
    }
}

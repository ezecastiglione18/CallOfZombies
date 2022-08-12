package Objetos;

import java.util.ArrayList;
import java.util.List;

public class ObjetoComplejo extends Objeto{
    public ArrayList<Objeto> objetos;
    public int vidaUtil;
    public int vidaUtilOriginal;

    public ObjetoComplejo(ArrayList<Objeto> lista, NombreDeObjeto nombreParam){
        super(nombreParam);
        this.objetos = lista;
        this.calcularVidaUtilYOriginal();
    }

    public void calcularVidaUtilYOriginal(){
        for(Objeto objeto : this.objetos){
            this.vidaUtil += objeto.getVidaUtil();
            this.vidaUtilOriginal += objeto.getVidaUtilOriginal();
        }
    }

    public void reparar(){
        this.objetos.forEach(Objeto::reparar);
        this.recalcularVidaUtil();
    }

    public void recalcularVidaUtil(){
        for(Objeto objeto : this.objetos){
            this.vidaUtil += objeto.getVidaUtil();
        }
    }

    public int getVidaUtil(){
        return this.vidaUtil;
    }

    public void recibirDanio(int danio){
        int cantidadDeObjetosTotales = 0;

        for(Objeto objeto : this.objetos){
            cantidadDeObjetosTotales += objeto.getCantidadDeObjetos();
        }

        int danioPorObjeto = danio / cantidadDeObjetosTotales;
        this.objetos.forEach(objeto -> {
            objeto.recibirDanio(danioPorObjeto);
            if(objeto.getVidaUtil() == 0){
                this.objetos.remove(objeto);
                this.recalcularVidaUtil();
            }
        });
    }

    @Override
    public int getVidaUtilOriginal() {
        return this.vidaUtilOriginal;
    }

    public int getCantidadDeObjetos(){
        int retorno = 0;

        for(Objeto objeto : this.objetos){
            retorno += objeto.getCantidadDeObjetos();
        }

        return retorno;
    }
    
}
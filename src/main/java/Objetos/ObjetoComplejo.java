package Objetos;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

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
        //this.objetos.forEach(Objeto::reparar);
        for(Objeto objeto : this.objetos){
           objeto.reparar();
        }
        this.vidaUtil = this.vidaUtilOriginal;
    }

    public void recalcularVidaUtil(){
        for(Objeto objeto : this.objetos){
            this.vidaUtil += objeto.getVidaUtil();
        }
    }

    public int getVidaUtil(){
        int vidaUtilTotal = 0;
        for(Objeto objeto : this.objetos){
            vidaUtilTotal += objeto.getVidaUtil();
        }
        return vidaUtilTotal;
    }

    public void recibirDanio(int danio){
        try{
            int cantidadDeObjetosTotales = this.getCantidadDeObjetos();

            int danioPorObjeto = danio / cantidadDeObjetosTotales;

            int nuevaVidaUtil = 0;

            for(Objeto objeto : this.objetos){
                objeto.recibirDanio(danioPorObjeto);
                if(objeto.getVidaUtil() == 0){
                    this.objetos.remove(objeto);
                }
                nuevaVidaUtil += objeto.getVidaUtil();
                //this.recalcularVidaUtil();
            }
            this.vidaUtil = nuevaVidaUtil;
        }
        catch (Error | ConcurrentModificationException error){
            System.out.println(error);
        }
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
package Objetos;

import java.util.ArrayList;

public class ObjetoComplejo extends Objeto{
    public ArrayList<Objeto> objetos = new ArrayList();

    public int vidaUtil = this.objetos.stream().mapToInt(Objeto::getVidaUtilOriginal).sum();

    public int vidaUtilOriginal = this.objetos.stream().mapToInt(Objeto::getVidaUtilOriginal).sum();

    public void reparar(){
        this.objetos.forEach(Objeto::reparar);
        this.recalcularVidaUtil();
    }

    public void recalcularVidaUtil(){
        this.vidaUtil = this.objetos.stream().mapToInt(Objeto::getVidaUtil).sum();
    }

    public int getVidaUtil(){
        return this.vidaUtil;
    }

    public void recibirDanio(int danio){
        int danioPorObjeto = danio / this.objetos.stream().mapToInt(Objeto::getCantidadDeObjetos).sum();
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
        return this.objetos.size();
    }
    
}
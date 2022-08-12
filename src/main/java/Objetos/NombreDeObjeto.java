package Objetos;

import java.util.ArrayList;
import java.util.Random;

public enum NombreDeObjeto {
    MADERA,
    PIEDRA,
    POLVORA,
    SOGA,
    ORO,
    ARCO_Y_FLECHA,
    LANZA,
    ANTORCHA,
    CATAPULTA ,
    LANZALLAMAS;

    /*public ArrayList<NombreDeObjeto> getTodosLosObjetos(){

        return new ArrayList<>(); //TODO
    }

    public ArrayList<NombreDeObjeto> objetosSimples(){
        return (ArrayList<NombreDeObjeto>) this.getTodosLosObjetos().stream().filter(objeto -> objeto == SOGA || objeto == ORO || objeto == MADERA || objeto == PIEDRA || objeto == POLVORA);
    }

    public ArrayList<NombreDeObjeto> objetosComplejos(){
        return (ArrayList<NombreDeObjeto>) this.getTodosLosObjetos().stream().filter(objeto -> !this.esObjetoSimple(objeto));
    }

    public boolean esObjetoSimple(Object objetoParam){
        return this.objetosSimples().contains(objetoParam);
    }

    public NombreDeObjeto elegirRandomSimple(){
        return this.objetosSimples().get(new Random().nextInt(this.objetosSimples().size()));
    }

    public NombreDeObjeto elegirRandomComplejo(){
        return this.objetosComplejos().get(new Random().nextInt(this.objetosComplejos().size()));
    }*/
}

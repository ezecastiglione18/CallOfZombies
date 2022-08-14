package ObjetosTest;

import Objetos.NombreDeObjeto;
import Objetos.Objeto;
import Objetos.ObjetoComplejo;
import Objetos.ObjetoSimple;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class ObjetosTest {

  @Test
  public void daniarObjetoComplejo(){
    //TODO REVISAR
    Objeto objetoSimple1 = new ObjetoSimple(NombreDeObjeto.ORO);
    Objeto objetoSimple2 = new ObjetoSimple(NombreDeObjeto.SOGA);
    ArrayList<Objeto> listaObjs = new ArrayList<>();
    listaObjs.add(objetoSimple1);
    listaObjs.add(objetoSimple2);
    Objeto objetoComplejo1 = new ObjetoComplejo(listaObjs, NombreDeObjeto.ARCO_Y_FLECHA);

    Objeto objetoSimple3 = new ObjetoSimple(NombreDeObjeto.PIEDRA);

    ArrayList<Objeto> objetosParaComplejo = new ArrayList<>();
    objetosParaComplejo.add(objetoComplejo1);
    objetosParaComplejo.add(objetoSimple3);

    Objeto objetoComplejoTest = new ObjetoComplejo(objetosParaComplejo, NombreDeObjeto.ARCO_Y_FLECHA);
    objetoComplejoTest.recibirDanio(90);

    Integer vidaUtil = objetoComplejoTest.getVidaUtil();
    Assertions.assertEquals(20, vidaUtil);
  }

  @Test
  public void daniarYRepararComplejo(){
    //TODO REVISAR SI ESTA BIEN IMPLEMETADA
    Objeto objetoSimple1 = new ObjetoSimple(NombreDeObjeto.ORO);
    Objeto objetoSimple2 = new ObjetoSimple(NombreDeObjeto.SOGA);
    ArrayList<Objeto> listaObjs = new ArrayList<>();
    listaObjs.add(objetoSimple1);
    listaObjs.add(objetoSimple2);
    Objeto objetoComplejo1 = new ObjetoComplejo(listaObjs, NombreDeObjeto.ARCO_Y_FLECHA);

    Objeto objetoSimple3 = new ObjetoSimple(NombreDeObjeto.PIEDRA);

    ArrayList<Objeto> objetosParaComplejo = new ArrayList<>();
    objetosParaComplejo.add(objetoComplejo1);
    objetosParaComplejo.add(objetoSimple3);

    Objeto objetoComplejoTest = new ObjetoComplejo(objetosParaComplejo, NombreDeObjeto.ARCO_Y_FLECHA);
    Integer vidaUtilOriginal = objetoComplejoTest.getVidaUtilOriginal();

    objetoComplejoTest.recibirDanio(20);
    objetoComplejoTest.reparar();
    Assertions.assertEquals(vidaUtilOriginal, objetoComplejoTest.getVidaUtil());

  }

  @Test
  public void obtenerLaCantidadTotalDeObjetosQueComponenAlComplejo(){
    Objeto objetoSimple1 = new ObjetoSimple(NombreDeObjeto.ORO);
    Objeto objetoSimple2 = new ObjetoSimple(NombreDeObjeto.SOGA);
    ArrayList<Objeto> listaObjs = new ArrayList<>();
    listaObjs.add(objetoSimple1);
    listaObjs.add(objetoSimple2);
    Objeto objetoComplejo1 = new ObjetoComplejo(listaObjs, NombreDeObjeto.ARCO_Y_FLECHA);

    Objeto objetoSimple3 = new ObjetoSimple(NombreDeObjeto.PIEDRA);

    ArrayList<Objeto> objetosParaComplejo = new ArrayList<>();
    objetosParaComplejo.add(objetoComplejo1);
    objetosParaComplejo.add(objetoSimple3);

    Objeto objetoComplejoTest = new ObjetoComplejo(objetosParaComplejo, NombreDeObjeto.ARCO_Y_FLECHA);
    Integer cantidadObjsTotales = objetoComplejoTest.getCantidadDeObjetos();

    Assertions.assertEquals(3, cantidadObjsTotales);
  }
}

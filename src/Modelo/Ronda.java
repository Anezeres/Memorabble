package Modelo;

/**
 *
 * @author Julian Alvarez <alvarez.julian@correounivalle.edu.co>
 * @author Sebastian Cespedes <sebastian.cespedes@correounivalle.edu.co>
 * @author Juan Pablo Ante <juan.pablo.ante@correounivalle.edu.co>
 * 
 */

import java.util.Stack;

public class Ronda {
    private final String[] colores;
    private final  String[] animales;
    private final String[] frutas;

    
    private int numeroPartidas;
    private String palabraActual;
    private String palabraActualAuxiliar;
    private String temaPartida;
    private int posicionDeLetra;
  
    public Ronda() {
          this.frutas = new String[]{"melon", "nispero", "mora", "limon", "durazno", "fresa", "mango", "higo", "pera"};
          this.animales = new String[]{"gato", "foca", "leon", "asno", "gorila", "tigre", "atun", "ganso", "erizo", "canguro"};
          this.colores = new String[]{"gris", "azul", "cian", "cafe", "violeta", "crema", "negro", "lacre", "blanco", "rosa"};

    }
  
  
    public void generarPalabraAuxiliar(){
        palabraActualAuxiliar = "";

      for(int letra = 0; letra<palabraActual.length();letra++){
          palabraActualAuxiliar = palabraActualAuxiliar + "-";
      }
    }
  
    public int generarPosicionAleatoria(){
        int pos;
        int nAleatorio = 10;
        Stack < Integer > pAleatorio = new Stack < Integer > ();


        for (int i = 0; i < nAleatorio ; i++) {
            pos = (int) Math.floor(Math.random() * nAleatorio );
            while (pAleatorio.contains(pos)) {
              pos = (int) Math.floor(Math.random() * nAleatorio );
            }
            pAleatorio.push(pos);
        }    
        int a = pAleatorio.pop();

        return a;
    }

  
    /* Getters and Setters */
    
    public String getFraseActual() {
      return palabraActual;
    }

    public String getTemaRonda() {
        return temaPartida;
    }

    public void setTemaRonda(String temaRonda) {
        this.temaPartida = temaRonda;
    }

    public int getNumeroPartidas() {
        return numeroPartidas;
    }

    public void setNumeroPartidas(int numeroPartidas) {
        this.numeroPartidas = numeroPartidas;
    }
    
    public int getSizePalabraActual(){
        return palabraActual.length();
    }
    
    public String getPalabraActual(){
        return palabraActual;
    }

    public int getPosicionDeLetra() {
        return posicionDeLetra;
    }

    public void setPosicionDeLetra(int posicionDeLetra) {
        this.posicionDeLetra = posicionDeLetra;
    }

    public String getPalabraActualAuxiliar() {
        return palabraActualAuxiliar;
    }

    public void setPalabraActualAuxiliar(String palabraActualAuxiliar) {
        this.palabraActualAuxiliar = palabraActualAuxiliar;
    }
    
    
    
    
    
    
    
    
    
  
  

}

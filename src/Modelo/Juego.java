package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Julian Alvarez <alvarez.julian@correounivalle.edu.co>
 * @author Sebastian Cespedes <sebastian.cespedes@correounivalle.edu.co>
 * @author Juan Pablo Ante <juan.pablo.ante@correounivalle.edu.co>
 * 
 */

public class Juego {
    String[] colores={"Rojo", "Azul", "Amarillo", "Verde", "Morado","Negro","Naranja", "Rosa"};
    String[] figuras={"Circulo", "Cuadrado", "Triangulo", "Hexagono", "Corazon", "Pica", "Diamante", "Trebol"};
    private int x;
    private int y;
    private String Color;
    private String Figura;
    //private int cantidad=3;
  
    public ArrayList<ArrayList<Integer>> coordenadaAleatoria(int cantidad){
        x=0; int rango_x=7;
        y=0; int rango_y=5;
      
        int coordenada_x[] = new int[cantidad];
        int coordenada_y[] = new int[cantidad];
      
        coordenada_x[x]=(int)(Math.random()*rango_x);
        for(x=1; x<cantidad; x++){
            coordenada_x[x]=(int)(Math.random()*rango_x);
            for(int j=0; j<1; j++){
                if(coordenada_x[x]==coordenada_x[j]){
                    x--;
                }
            }
        }
        coordenada_y[y]=(int)(Math.random()*rango_y);
        for(y=1; y<cantidad; y++){
            coordenada_y[y]=(int)(Math.random()*rango_y);
            for(int k=0; k<1; k++){
                if(coordenada_y[y]==coordenada_x[k]){
                    y--;
                }
            }
        }
        
       ArrayList<ArrayList<Integer>> listaDePosiciones = new ArrayList<>();
        
       
      for(int u=0; u<cantidad; u++){
        ArrayList<Integer> posicionActualCreada = new ArrayList<>();
        x = coordenada_x[u];
        y = coordenada_y[u]; 
        posicionActualCreada.add(y + 1);
        posicionActualCreada.add(x + 1);
         
        listaDePosiciones.add(posicionActualCreada);
      }
      
      
      return listaDePosiciones;
    }

    public ArrayList<String> colorAleatorio(int cantidad){
      int i=0, rango=8;
      int arreglo[]=new int [cantidad];
      arreglo[i]=(int)(Math.random()*rango);
      for(i=1; i<cantidad; i++){
          arreglo[i]=(int)(Math.random()*rango);
          for(int k=0; k<1; k++){
              if(arreglo[i]==arreglo[k]){
                  i--;
            }
          }
        }
      
      ArrayList<String> listaColores = new ArrayList<>();
      for(int u=0; u<cantidad; u++){
        listaColores.add(colores[arreglo[u]]);
        Color = colores[arreglo[u]];
      }
      return listaColores;
    }

    public ArrayList<String> figuraAleatoria(int cantidad){
      int i=0,rango=8;
      int arreglo[]=new int [cantidad];
      arreglo[i]=(int)(Math.random()*rango);
      for(i=1; i<cantidad; i++){
          arreglo[i]=(int)(Math.random()*rango);
          for(int k=0; k<1; k++){
              if(arreglo[i]==arreglo[k]){
                  i--;
            }
          }
        }
      
      ArrayList<String> listaFiguras = new ArrayList<>();
      for(int u=0; u<cantidad; u++){
        listaFiguras.add(figuras[arreglo[u]]);
        Figura = figuras[arreglo[u]];
      }
      return listaFiguras;
    }
  
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public String getColor() {
        return Color;
    }

    public String getFigura() {
        return Figura;
    }
    
}

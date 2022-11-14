/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package memorabble;

import Controller.ControllerPrincipal;
import Modelo.Jugador;
import Modelo.ModeloPrincipal;
import Modelo.Juego;
import Vistas.VistaPrincipal;

/**
 *
 * @author RYZEN
 */
public class Memorabble {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   
        VistaPrincipal vista = new VistaPrincipal();
        ModeloPrincipal modelo = new ModeloPrincipal();
        
        ControllerPrincipal controller = new ControllerPrincipal(modelo, vista);
    }
    
}

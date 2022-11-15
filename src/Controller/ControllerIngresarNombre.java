package Controller;

import Modelo.ModeloPrincipal;
import Vistas.VistaJuego;
import Vistas.VistaPrincipal;
import Vistas.VistaIngresarNombre;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Julian Alvarez <alvarez.julian@correounivalle.edu.co>
 * @author Sebastian Cespedes <sebastian.cespedes@correounivalle.edu.co>
 * @author Juan Pablo Ante <juan.pablo.ante@correounivalle.edu.co>
 * 
 */

public class ControllerIngresarNombre {
    
    private ModeloPrincipal modelo;
    private VistaIngresarNombre vistaNombre;
    private static int ventanas = 0;

    public ControllerIngresarNombre(ModeloPrincipal modelo, VistaIngresarNombre vistaTema) {
        this.modelo = modelo;
        this.vistaNombre = vistaTema;
        ventanas = 0;
        
        vistaTema.iniciarComponentesTema();
        vistaTema.configurarVistaTema();
        
        agregarControllers();
    }
    
    public void agregarControllers(){
        
        MouseListenerController controllerMouse = new MouseListenerController();
        KeyListenerController controllerKeyboard = new KeyListenerController();
        
        vistaNombre.addLblCerrarMouseListener(controllerMouse);
        vistaNombre.addLblVolverMouseListener(controllerMouse);
        vistaNombre.addTxtNombreKeyListener(controllerKeyboard);
        
    }
    
    public class KeyListenerController implements KeyListener{

        @Override
        public void keyTyped(KeyEvent event) {
            if(event.getSource() == vistaNombre.getTxtNombre()){
                //System.out.println("Hola mundo");
               
                
                if(vistaNombre.getNombre().length() != 0){
                    
                    vistaNombre.agregarLblIniciar();
                    vistaNombre.eliminarLblIngresarNombre();
                    vistaNombre.addLblIniciarMouseListener(new MouseListenerController());
                }
                
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
                    if(vistaNombre.getNombre().length() == 1){
                        vistaNombre.agregarLblIngresarNombre();
                        vistaNombre.eliminarLblIniciar();
                    }
            }
                   
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
        }
        
    
    }

    
    
    public class MouseListenerController extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent event){
            ventanas++;
            if(ventanas == 1){
                if (event.getSource() == vistaNombre.getLblCerrar()){
                if (JOptionPane.showConfirmDialog(null, "¿Seguro que quieres salir?", "Mensaje", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    vistaNombre.dispose();
             
                }
            }else if(event.getSource() == vistaNombre.getLblIniciar()){
                
                
                vistaNombre.dispose();
                modelo.getJugador().setNombre(vistaNombre.getNombre());
                System.out.println("Hola Mundo");
                VistaJuego vistaJuego = new VistaJuego();
                    
                ControllerJuego controllerJuego = new ControllerJuego(modelo,vistaJuego);
                    
                
                
            }else if(event.getSource() == vistaNombre.getLblVolver()){
                vistaNombre.dispose();
                VistaPrincipal vista = new VistaPrincipal();
                ControllerPrincipal controller = new ControllerPrincipal(modelo, vista);
            }
            }
            
            
            
            
        }
        
        @Override
        public void mouseEntered(MouseEvent event){
            
            
            
        }
        
        @Override
        public void mouseExited(MouseEvent event){
            
        }
   
    }
    
    
    
}

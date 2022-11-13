package Controller;

import Modelo.ModeloPrincipal;
import Vistas.VistaFinal;
import Vistas.VistaPrincipal;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Julian Alvarez <alvarez.julian@correounivalle.edu.co>
 * @author Sebastian Cespedes <sebastian.cespedes@correounivalle.edu.co>
 * @author Juan Pablo Ante <juan.pablo.ante@correounivalle.edu.co>
 * 
 */

public class ControllerFinal {
    
    private final ModeloPrincipal modelo;
    private final VistaFinal vistaFinal;

    public ControllerFinal(ModeloPrincipal modelo, VistaFinal vistaFinal) {
        this.modelo = modelo;
        this.vistaFinal = vistaFinal;
        
        vistaFinal.iniciarComponentesFinal();
        vistaFinal.configurarVistaFinal();
        
        vistaFinal.setNombre(modelo.getJugador().getNombre());
        vistaFinal.setGanadas(modelo.getJugador().getPorcentajeGanadas());
        vistaFinal.setPerdidas(modelo.getJugador().getPorcentajePerdidas());
        vistaFinal.setJugadas(modelo.getJugador().getPartidasJugadas());
        
        agregarControllers();
    }
    
    public void agregarControllers(){
        
        MouseListenerController controllerMouse = new MouseListenerController();
        vistaFinal.addLblVolverMouseListener(controllerMouse);
        vistaFinal.addLblCerrarMouseListener(controllerMouse);
        
    }
    
    public class MouseListenerController extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent event){
            
            if (event.getSource() == vistaFinal.getLblCerrar()){
                if (JOptionPane.showConfirmDialog(null, "¿Seguro que quieres salir?", "Mensaje", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    vistaFinal.dispose();
             
                }
            }else if(event.getSource() == vistaFinal.getLblVolver()){
                terminarPartida();
            }
        }
        
        public void terminarPartida(){
            if (JOptionPane.showConfirmDialog(null, "¿Quieres seguir jugando?", "Mensaje", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                vistaFinal.dispose();
                modelo.getJugador().reiniciarNumeroIntentos();
                modelo.getJugador().reiniciarErrores();
                VistaPrincipal vista = new VistaPrincipal();
                ControllerPrincipal controller = new ControllerPrincipal(modelo, vista);
                            
            }
        }
    
    }
    
}

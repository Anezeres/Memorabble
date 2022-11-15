package Controller;

import Modelo.ModeloPrincipal;
import Vistas.VistaBeneficios;
import Vistas.VistaComoJugar;
import Vistas.VistaPrincipal;
import Vistas.VistaIngresarNombre;
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

public class ControllerPrincipal {
    private ModeloPrincipal modelo;
    private VistaPrincipal vista;

    public ControllerPrincipal(ModeloPrincipal modelo, VistaPrincipal vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        vista.iniciarComponentesLogin();
        vista.configurarVistaLogin();
        
        
        agregarControllers();
          
    }
    
    public void agregarControllers(){
        
        MouseListenerController controllerMouse = new MouseListenerController();
        
        vista.addLblCerrarMouseListener(controllerMouse);
        vista.addLblJugarMouseListener(controllerMouse);
        vista.addLblComoJugarMouseListener(controllerMouse);
        vista.addLblBeneficiosMouseListener(controllerMouse);
    }
    
    public class MouseListenerController extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent event){
            
            if (event.getSource() == vista.getLblCerrar()){
                if (JOptionPane.showConfirmDialog(null, "¿Seguro que quieres salir?", "Mensaje", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    vista.dispose();
             
                }
            }else if(event.getSource() == vista.getJugar()){
                vista.dispose();
                VistaIngresarNombre vistaTema = new VistaIngresarNombre();
                ControllerIngresarNombre controllerTema = new ControllerIngresarNombre(modelo,vistaTema);
           }else if(event.getSource() == vista.getComoJugar()){
                vista.dispose();
                VistaComoJugar vistaComoJugar = new VistaComoJugar();
                ControllerComoJugar controllerComoJugar = new ControllerComoJugar(modelo,vistaComoJugar);
           }else if(event.getSource() == vista.getBeneficios()){
                vista.dispose();
                VistaBeneficios vistaBeneficios = new VistaBeneficios();
                ControllerBeneficios controllerComoJugar = new ControllerBeneficios(modelo,vistaBeneficios);
           }
            
            
        }
   
    }
    
    
    
    
}

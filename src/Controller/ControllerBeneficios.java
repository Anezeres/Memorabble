package Controller;

import Modelo.ModeloPrincipal;
import Vistas.VistaBeneficios;
import Vistas.VistaComoJugar;
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

public class ControllerBeneficios {
    
    private ModeloPrincipal modelo;
    private VistaBeneficios vistaBeneficios;
    
    public ControllerBeneficios(ModeloPrincipal modelo, VistaBeneficios vistaBeneficios) {
        this.modelo = modelo;
        this.vistaBeneficios = vistaBeneficios;
        
        vistaBeneficios.iniciarComponentesComoJugar();
        vistaBeneficios.configurarVistaComoJugar();
        
        agregarControllers();
    }
    
    public void agregarControllers(){
        
        MouseListenerController controllerMouse = new MouseListenerController();
        
        vistaBeneficios.addLblCerrarMouseListener(controllerMouse);
        vistaBeneficios.addLblVolverMouseListener(controllerMouse);
 
    }
    
    public class MouseListenerController extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent event){
            
            if (event.getSource() == vistaBeneficios.getLblCerrar()){
                if (JOptionPane.showConfirmDialog(null, "¿Seguro que quieres salir?", "Mensaje", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    vistaBeneficios.dispose();
             
                }
            }else if(event.getSource() == vistaBeneficios.getLblVolver()){
                vistaBeneficios.dispose();
                VistaPrincipal vista = new VistaPrincipal();
                ControllerPrincipal vistaPrincipal = new ControllerPrincipal(modelo, vista);
            }
        }
    }
    
    
    
}

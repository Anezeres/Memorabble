package Controller;

import Modelo.ModeloPrincipal;
import Vistas.Tarjeta;
import Vistas.VistaJuego;
import Vistas.VistaFinal;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Julian Alvarez <alvarez.julian@correounivalle.edu.co>
 * @author Sebastian Cespedes <sebastian.cespedes@correounivalle.edu.co>
 * @author Juan Pablo Ante <juan.pablo.ante@correounivalle.edu.co>
 * 
 */

public final class ControllerJuego {
    
    private final ModeloPrincipal modelo;
    private final VistaJuego vistaJuego;

    public ControllerJuego(ModeloPrincipal modelo, VistaJuego vistaAhorcado) {
        this.modelo = modelo;
        this.vistaJuego = vistaAhorcado;
        
        vistaAhorcado.iniciarComponentesAhorcado();
        vistaAhorcado.configurarVistaAhorcado();
        
        //modelo.getJugador().setPartidasJugadas(modelo.getJugador().getPartidasJugadas() + 1);
        
        //int sizePalabra = modelo.getRonda().getSizePalabraActual();
        //vistaAhorcado.cambiarFondoSegunSizePalabra(sizePalabra);
        
        vistaAhorcado.setNombre(modelo.getJugador().getNombre());
        vistaAhorcado.setIntentos(modelo.getJugador().getNumeroIntentos());
        
        
        agregarControllers();
    }
    
    public void agregarControllers(){
        
        MouseListenerController controllerMouse = new MouseListenerController();
        vistaJuego.addLblTarjetasMouseListener(controllerMouse);
        
    }
    
    public class MouseListenerController extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent event){
            JLabel cualquierLetraPresionada = vistaJuego.saberSiUnaTarjetaFuePresionada( (JLabel) event.getSource());
            
            
            if (event.getSource() == cualquierLetraPresionada){
                Tarjeta tarjetaPresionada = vistaJuego.saberTarjetaPresionada((JLabel) event.getSource());
                System.out.println("Se precionó");
                System.out.println(tarjetaPresionada.getPosicionTablero());
            }

        }
        
        @Override
        public void mouseExited(MouseEvent event){
            JLabel cualquierLetraIngresada = vistaJuego.saberSiUnaTarjetaFuePresionada( (JLabel) event.getSource());
            
            if (event.getSource() == cualquierLetraIngresada){
                System.out.println("Salió");
                Tarjeta tarjetaPresionada = vistaJuego.saberTarjetaPresionada((JLabel) event.getSource());
                vistaJuego.ponerTarjetInactiva(tarjetaPresionada);
            }
        }
        
        @Override
        public void mouseEntered(MouseEvent event){
            JLabel cualquierLetraIngresada = vistaJuego.saberSiUnaTarjetaFuePresionada( (JLabel) event.getSource());
            
            if (event.getSource() == cualquierLetraIngresada){
                System.out.println("Entré");
                Tarjeta tarjetaPresionada = vistaJuego.saberTarjetaPresionada((JLabel) event.getSource());
                vistaJuego.ponerTarjetActiva(tarjetaPresionada);
            }
        }
        
        
        
        public void terminarPartida(){
            if (JOptionPane.showConfirmDialog(null, "¿Quieres seguir jugando?", "Mensaje", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                vistaJuego.dispose();
                
                modelo.getJugador().reiniciarNumeroIntentos();
                modelo.getJugador().reiniciarErrores();
                
                VistaJuego vistaAhorcado = new VistaJuego();
                ControllerJuego controllerAhorcado = new ControllerJuego(modelo,vistaAhorcado);
                            
            }else{
                vistaJuego.dispose();
                VistaFinal vistaFinal = new VistaFinal();
                ControllerFinal controllerFinal = new ControllerFinal(modelo, vistaFinal);
            }
        }
        
    }
    
    
    
}

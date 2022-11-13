package Controller;

import Modelo.ModeloPrincipal;
import Vistas.Tarjeta;
import Vistas.VistaJuego;
import Vistas.VistaFinal;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
    private ArrayList<Integer> tarjetaActualActiva;

    public ControllerJuego(ModeloPrincipal modelo, VistaJuego vistaAhorcado) {
        this.modelo = modelo;
        this.vistaJuego = vistaAhorcado;
        
        vistaAhorcado.iniciarComponentesAhorcado();
        vistaAhorcado.configurarVistaAhorcado();
        tarjetaActualActiva = new ArrayList<>();
        tarjetaActualActiva.add(1);
        tarjetaActualActiva.add(1);
        
        //modelo.getJugador().setPartidasJugadas(modelo.getJugador().getPartidasJugadas() + 1);
        
        //int sizePalabra = modelo.getRonda().getSizePalabraActual();
        //vistaAhorcado.cambiarFondoSegunSizePalabra(sizePalabra);
        
        vistaAhorcado.setNombre(modelo.getJugador().getNombre());
        vistaAhorcado.setIntentos(modelo.getJugador().getNumeroIntentos());
        
        
        agregarControllers();
    }
    
    public void agregarControllers(){
        
        MouseListenerController controllerMouse = new MouseListenerController();
        KeyListenerController controllerKeyboard = new KeyListenerController();
        
        vistaJuego.addLblTarjetasMouseListener(controllerMouse);
        vistaJuego.addTxtListenerKeyListener(controllerKeyboard);
        
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
            JLabel cualquierTarjetaIngresada = vistaJuego.saberSiUnaTarjetaFuePresionada( (JLabel) event.getSource());
            
            if (event.getSource() == cualquierTarjetaIngresada){
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
                Tarjeta tarjetaIngresada = vistaJuego.saberTarjetaPresionada((JLabel) event.getSource());
                vistaJuego.ponerTarjetActiva(tarjetaIngresada);
                tarjetaActualActiva = tarjetaIngresada.getPosicionTablero();
                
                System.out.println("Tarjeta actual activa: " + tarjetaActualActiva);
                
            }
        }
        
    }
    
    public class KeyListenerController implements KeyListener{
        @Override
        public void keyTyped(KeyEvent event) {

            
            
        }

        @Override
        public void keyPressed(KeyEvent event) {
            switch (event.getKeyCode()) {
                case KeyEvent.VK_UP -> {
                    System.out.println("Arriba");
                    int nuevoY = tarjetaActualActiva.get(0) - 1;
                    if(nuevoY < 1){
                        nuevoY = 5;
                        tarjetaActualActiva.set(0,nuevoY);
                        vistaJuego.ponerTarjetaPosicionActiva(tarjetaActualActiva);
                    }else{
                        tarjetaActualActiva.set(0,nuevoY);
                        vistaJuego.ponerTarjetaPosicionActiva(tarjetaActualActiva);
                    }
                }
                case KeyEvent.VK_DOWN -> {
                    System.out.println("Abajo");
                    int nuevoY = tarjetaActualActiva.get(0) + 1;
                    if(nuevoY > 5){
                        nuevoY = 1;
                        tarjetaActualActiva.set(0,nuevoY);
                        vistaJuego.ponerTarjetaPosicionActiva(tarjetaActualActiva);
                    }else{
                        tarjetaActualActiva.set(0,nuevoY);
                        vistaJuego.ponerTarjetaPosicionActiva(tarjetaActualActiva);
                    }
                    tarjetaActualActiva.set(0,nuevoY);
                    vistaJuego.ponerTarjetaPosicionActiva(tarjetaActualActiva);
                }
                case KeyEvent.VK_LEFT -> {
                    System.out.println("Izquierda");
                    int nuevoX = tarjetaActualActiva.get(1) - 1;
                    if(nuevoX < 1){
                        nuevoX = 7;
                        tarjetaActualActiva.set(1,nuevoX);
                        vistaJuego.ponerTarjetaPosicionActiva(tarjetaActualActiva);
                    }else{
                        tarjetaActualActiva.set(1,nuevoX);
                        vistaJuego.ponerTarjetaPosicionActiva(tarjetaActualActiva);
                    }
                }
                case KeyEvent.VK_RIGHT -> {
                    System.out.println("Derecha");
                    int nuevoX = tarjetaActualActiva.get(1) + 1;
                    if(nuevoX > 7){
                        nuevoX = 1;
                        tarjetaActualActiva.set(1,nuevoX);
                        vistaJuego.ponerTarjetaPosicionActiva(tarjetaActualActiva);
                    }else{
                        tarjetaActualActiva.set(1,nuevoX);
                        vistaJuego.ponerTarjetaPosicionActiva(tarjetaActualActiva);
                    }
                }
                case KeyEvent.VK_SPACE -> {
                    System.out.println("Espacio");
                }
                case KeyEvent.VK_ENTER -> {
                    System.out.println("Enter");
                }
                default -> {
                }
            }
            
        }

        @Override
        public void keyReleased(KeyEvent eevent) {
            
        }
        
    }
    
    
    
}

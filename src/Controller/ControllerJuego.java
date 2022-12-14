package Controller;

import Modelo.ModeloPrincipal;
import Vistas.Tarjeta;
import Vistas.VistaFinal;
import Vistas.VistaJuego;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Julian Alvarez <alvarez.julian@correounivalle.edu.co>
 * @author Sebastian Cespedes <sebastian.cespedes@correounivalle.edu.co>
 * @author Juan Pablo Ante <juan.pablo.ante@correounivalle.edu.co>
 * 
 */

public final class ControllerJuego{
    
    private final ModeloPrincipal modelo;
    private final VistaJuego vistaJuego;
    private ArrayList<Integer> tarjetaActualActiva;
    private ArrayList<Integer> tarjetaCorrecta;
    
    

    public ControllerJuego(ModeloPrincipal modelo, VistaJuego vistaJuego){
        this.modelo = modelo;
        this.vistaJuego = vistaJuego;
        
        modelo.getJugador().comezarTiempo();
        
        vistaJuego.iniciarComponentesAhorcado();
        vistaJuego.configurarVistaAhorcado();
        tarjetaActualActiva = new ArrayList<>();
        tarjetaActualActiva.add(1);
        tarjetaActualActiva.add(1);
        
        vistaJuego.setNombre(modelo.getJugador().getNombre());
        
        agregarControllers();
        
        Robot r = null;
        try {
            r = new Robot();
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException ex) {
            Logger.getLogger(ControllerJuego.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //
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
            
            if(modelo.getJugador().getVidas() != 1){
                if (event.getSource() == cualquierLetraPresionada){
                Tarjeta tarjetaPresionada = vistaJuego.saberTarjetaPresionada((JLabel) event.getSource());
                System.out.println(tarjetaPresionada.getPosicionTablero());
                
                System.out.println("Tarjeta Correcta: " + tarjetaCorrecta);
                
                    if(tarjetaCorrecta.equals(tarjetaPresionada.getPosicionTablero())){
                        modelo.getJugador().setPuntos(modelo.getJugador().getPuntos() + 100);
                        modelo.getJugador().setAciertos(modelo.getJugador().getAciertos() + 1);
                        System.out.println("Vidas Jugador: " + modelo.getJugador().getVidas());
                        System.out.println("Aciertos Jugador: " + modelo.getJugador().getAciertos());
                        vistaJuego.setPuntos(modelo.getJugador().getPuntos());
                    }else{
                        modelo.getJugador().setVidas(modelo.getJugador().getVidas() - 1);
                        vistaJuego.cambiarImagenFondo(modelo.getJugador().getVidas());
                        System.out.println("Vidas Jugador: " + modelo.getJugador().getVidas());
                        System.out.println("Aciertos Jugador: " + modelo.getJugador().getAciertos());
                    }
                }else{
                    
                }
                
                Robot r = null;
                try {
                    r = new Robot();
                    r.keyPress(KeyEvent.VK_ENTER);
                    r.keyRelease(KeyEvent.VK_END);
                } catch (AWTException ex) {
                    Logger.getLogger(ControllerJuego.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
                
            }else{
                modelo.getJugador().terminarTiempo();
                modelo.getJugador().calcularTiempo();
                vistaJuego.dispose();
                VistaFinal vistafinal = new VistaFinal();
                ControllerFinal controller = new ControllerFinal(modelo, vistafinal);
            }
            
            
            
            

        }
        
        @Override
        public void mouseExited(MouseEvent event){
            JLabel cualquierTarjetaIngresada = vistaJuego.saberSiUnaTarjetaFuePresionada( (JLabel) event.getSource());
            
            if (event.getSource() == cualquierTarjetaIngresada){
                System.out.println("Sali??");
                Tarjeta tarjetaPresionada = vistaJuego.saberTarjetaPresionada((JLabel) event.getSource());
                vistaJuego.ponerTarjetInactiva(tarjetaPresionada);
            }
        }
        
        @Override
        public void mouseEntered(MouseEvent event){
            JLabel cualquierLetraIngresada = vistaJuego.saberSiUnaTarjetaFuePresionada( (JLabel) event.getSource());
            
            if (event.getSource() == cualquierLetraIngresada){
                System.out.println("Entr??");
                Tarjeta tarjetaIngresada = vistaJuego.saberTarjetaPresionada((JLabel) event.getSource());
                vistaJuego.ponerTarjetActiva(tarjetaIngresada);
                tarjetaActualActiva = tarjetaIngresada.getPosicionTablero();
                
                System.out.println("Tarjeta actual activa: " + tarjetaActualActiva);
                
            }
        }
        
    }
    
    public class KeyListenerController implements KeyListener{
        private Timer timer;
        
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
                    Robot r = null;
                    try {
                        r = new Robot();
                    } catch (AWTException ex) {
                        Logger.getLogger(ControllerJuego.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        r.keyPress(KeyEvent.VK_ENTER);
                        r.keyRelease(KeyEvent.VK_ENTER);
                                        
 
                }
                case KeyEvent.VK_W -> {
                    try {   

                        Thread.sleep(2000);
                       vistaJuego.limpiarTablero();
                        System.out.println("hola");
                    } catch (Exception e) {
                        System.out.println("e");
                    }  
                    
                    
 
                }
                case KeyEvent.VK_ENTER -> {
                    ArrayList<ArrayList<Integer>> coordenadas = modelo.getJuego().coordenadaAleatoria(5);
                    ArrayList<String> colores = modelo.getJuego().colorAleatorio(5);
                    ArrayList<String> figuras = modelo.getJuego().figuraAleatoria(5);
                    
                    
                    vistaJuego.ponerFichasEnJuego(coordenadas, colores, figuras);
                    vistaJuego.colocarTarjetaCorrecta(coordenadas.get(0), colores.get(0), figuras.get(0));
                    tarjetaCorrecta = coordenadas.get(0);
                    
                    Robot r = null;
                    try {
                        r = new Robot();
                        r.keyPress(KeyEvent.VK_W);
                        r.keyRelease(KeyEvent.VK_W);
                    } catch (AWTException ex) {
                        Logger.getLogger(ControllerJuego.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        
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

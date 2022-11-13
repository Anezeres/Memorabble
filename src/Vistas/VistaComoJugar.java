package Vistas;

import java.awt.event.MouseAdapter;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Julian Alvarez <alvarez.julian@correounivalle.edu.co>
 * @author Sebastian Cespedes <sebastian.cespedes@correounivalle.edu.co>
 * @author Juan Pablo Ante <juan.pablo.ante@correounivalle.edu.co>
 * 
 */

public class VistaComoJugar extends JFrame{
    
    private JLabel lblPaso;
    private JLabel lblCerrar;
    private JLabel lblVolver;
    private JLabel lblSiguiente;
    
    private int pagina;
    
    private JPanel jpContenidoGeneral;

    public VistaComoJugar() {
        this.pagina = 1;
    }
    
    public void configurarVistaComoJugar(){
        setUndecorated(true);
        setVisible(true);
        setSize(1024,640);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void iniciarComponentesComoJugar(){
        configurarContenidoGeneral();
        asignacionImagenesALabels();
        
        /* Configuración imagenes */
        
        posicionarElementos(); 
        ponerCursorActivoALabels();
        
        /* Se agregan labels al contenido general */
        
        agregarElementosAContenidoGeneral();
 
    }
    
    public void cambiarDePagina(){
        pagina++;
        
        
        if(pagina == 4){
            lblSiguiente.setIcon(null);
            lblSiguiente.setBounds(0,0,0,0);
        }
        
        Icon imagenPaso = new ImageIcon("src\\Imagenes\\ComoJugar\\00-ComoJugar"+pagina+"-img.png");
        lblPaso.setIcon(imagenPaso);
    }
    
    /* Metodos para añadir listeners */
    
    public void addLblCerrarMouseListener(MouseAdapter listenControles){
        lblCerrar.addMouseListener(listenControles);
    }
    
    public void addLblVolverMouseListener(MouseAdapter listenControles){
        lblVolver.addMouseListener(listenControles);
    }
    
    public void addLblSiguienteMouseListener(MouseAdapter listenControles){
        lblSiguiente.addMouseListener(listenControles);
    }
    
    /* Getters and Setters */
    
    public JLabel getLblCerrar(){
        return lblCerrar;
    }

    public JLabel getLblVolver() {
        return lblVolver;
    }
    
    public JLabel getLblSiguiente(){
        return lblSiguiente;
    }
    
    /* Metodos repetitivos */
    
    public void asignacionImagenesALabels(){
        /* Cargado de imagenes */
        Icon imagenPaso = new ImageIcon("src\\Imagenes\\ComoJugar\\00-ComoJugar1-img.png");
        Icon imagenCerrar = new ImageIcon("src\\Imagenes\\04-Cerrar-img.png");
        Icon imagenVolver = new ImageIcon("src\\Imagenes\\13-Volver-img.png");
        Icon imagenSiguiente = new ImageIcon("src\\Imagenes\\25-Siguiente-img.png");
        
        lblPaso = new JLabel(imagenPaso);
        lblCerrar = new JLabel(imagenCerrar);
        lblVolver = new JLabel(imagenVolver);
        lblSiguiente = new JLabel(imagenSiguiente);
    }
    
    public void ponerCursorActivoALabels(){
        lblCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSiguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); 
    }
    
    public void configurarContenidoGeneral(){
        jpContenidoGeneral = new JPanel();
        jpContenidoGeneral.setBounds(0,0,1024,640);
        jpContenidoGeneral.setLayout(null);
        add(jpContenidoGeneral);
    }   
    
    public void posicionarElementos(){
        lblPaso.setBounds(0,0,1024,640);
        lblCerrar.setBounds(930,10,240,80);
        lblSiguiente.setBounds(930,430,240,80);
        lblVolver.setBounds(-150,10,240,80); 
    }
    
    public void agregarElementosAContenidoGeneral(){
        jpContenidoGeneral.add(lblCerrar);
        jpContenidoGeneral.add(lblVolver);
        jpContenidoGeneral.add(lblSiguiente);
        jpContenidoGeneral.add(lblPaso);
    }
    
    
    
}

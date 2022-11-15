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

public class VistaBeneficios extends JFrame{
    
    private JLabel lblBeneficios;
    private JLabel lblCerrar;
    private JLabel lblVolver;
    
    private JPanel jpContenidoGeneral;
    
    public VistaBeneficios() {
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
    
    /* Metodos para añadir listeners */
    
    public void addLblCerrarMouseListener(MouseAdapter listenControles){
        lblCerrar.addMouseListener(listenControles);
    }
    
    public void addLblVolverMouseListener(MouseAdapter listenControles){
        lblVolver.addMouseListener(listenControles);
    }
    
    /* Getters and Setters */
    
    public JLabel getLblCerrar(){
        return lblCerrar;
    }

    public JLabel getLblVolver() {
        return lblVolver;
    }
    
    
    /* Metodos repetitivos */
    
    public void asignacionImagenesALabels(){
        /* Cargado de imagenes */
        Icon imagenBeneficios = new ImageIcon("src\\Imagenes\\26-Beneficios-img.png");
        Icon imagenCerrar = new ImageIcon("src\\Imagenes\\04-Cerrar-img.png");
        Icon imagenVolver = new ImageIcon("src\\Imagenes\\13-Volver-img.png");
        
        lblBeneficios = new JLabel(imagenBeneficios);
        lblCerrar = new JLabel(imagenCerrar);
        lblVolver = new JLabel(imagenVolver);
    }
    
    public void ponerCursorActivoALabels(){
        lblCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
    }
    
    public void configurarContenidoGeneral(){
        jpContenidoGeneral = new JPanel();
        jpContenidoGeneral.setBounds(0,0,1024,640);
        jpContenidoGeneral.setLayout(null);
        add(jpContenidoGeneral);
    }   
    
    public void posicionarElementos(){
        lblBeneficios.setBounds(0,0,1024,640);
        lblCerrar.setBounds(930,10,240,80);
        lblVolver.setBounds(-150,10,240,80); 
    }
    
    public void agregarElementosAContenidoGeneral(){
        jpContenidoGeneral.add(lblCerrar);
        jpContenidoGeneral.add(lblVolver);
        jpContenidoGeneral.add(lblBeneficios);
    }
    
}

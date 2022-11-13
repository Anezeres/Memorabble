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

public class VistaPrincipal extends JFrame{
    
    private JLabel lblTitle;
    private JLabel lblComoJugar;
    private JLabel lblJugar;
    private JLabel lblBeneficios;
    private JLabel lblCerrar;
    
    private JPanel jpContenidoGeneral;

    public VistaPrincipal() {
    }
    
    public void configurarVistaLogin(){
        setUndecorated(true);
        setVisible(true);
        setSize(1024,640);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void iniciarComponentesLogin(){
        configurarContenidoGeneral();
        asignacionImagenesALabels();
        
        
        /* Configuración imagenes */
        
        posicionarElementos();
        ponerCursorActivoALabels();
        
        /* Se agregan labels al contenido general */
        
        agregarElementosAContenidoGeneral();

    }
    
    public void addLblJugarMouseListener(MouseAdapter listenControles){
        lblJugar.addMouseListener(listenControles);
    }
    
    public void addLblBeneficiosMouseListener(MouseAdapter listenControles){
        lblBeneficios.addMouseListener(listenControles);
    }
    
    public void addLblComoJugarMouseListener(MouseAdapter listenControles){
        lblComoJugar.addMouseListener(listenControles);
    }
    
    public void addLblCerrarMouseListener(MouseAdapter listenControles){
        lblCerrar.addMouseListener(listenControles);
    }
    
    /* Getters and Setters */
    
    public JLabel getLblCerrar(){
        return lblCerrar;
    }
    
    public JLabel getJugar(){
        return lblJugar;
    }
    
    public JLabel getComoJugar(){
        return lblComoJugar;
    }
    
    public JLabel getBeneficios(){
        return lblBeneficios;
    }
    
    /* Metodos repetitivos */
    
    public void asignacionImagenesALabels(){
        /* Cargado de imagenes */
        Icon imagenTitlePrincipal = new ImageIcon("src\\Imagenes\\00-Memorabble-img.png");
        Icon imagenComoJugar = new ImageIcon("src\\Imagenes\\01-ComoJugar-img.png");
        Icon imagenJugar = new ImageIcon("src\\Imagenes\\02-Jugar-img.png");
        Icon imagenBeneficios = new ImageIcon("src\\Imagenes\\03-Beneficios-img.png");
        Icon imagenCerrar = new ImageIcon("src\\Imagenes\\04-Cerrar-img.png");
        
        /* Inicializacion de imagenes */
        
        lblTitle = new JLabel(imagenTitlePrincipal);
        lblComoJugar = new JLabel(imagenComoJugar);
        lblJugar = new JLabel(imagenJugar);
        lblBeneficios = new JLabel(imagenBeneficios);
        lblCerrar = new JLabel(imagenCerrar);
    }
    
    public void ponerCursorActivoALabels(){
        lblCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblJugar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBeneficios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblComoJugar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
    }
    
    public void configurarContenidoGeneral(){
        jpContenidoGeneral = new JPanel();
        jpContenidoGeneral.setBounds(0,0,1024,640);
        jpContenidoGeneral.setLayout(null);
        add(jpContenidoGeneral);
    }
    
    public void posicionarElementos(){
        lblTitle.setBounds(0,0,1024,640);
        lblComoJugar.setBounds(50,525,240,80);
        lblJugar.setBounds(50,325,240,80);
        lblBeneficios.setBounds(50,425,240,80);
        lblCerrar.setBounds(930,10,240,80);
    }
    
    public void agregarElementosAContenidoGeneral(){
        jpContenidoGeneral.add(lblComoJugar);
        jpContenidoGeneral.add(lblCerrar);
        jpContenidoGeneral.add(lblJugar);
        jpContenidoGeneral.add(lblBeneficios);
        jpContenidoGeneral.add(lblTitle);
    }
    
    
    
}



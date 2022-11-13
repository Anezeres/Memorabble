package Vistas;

import java.awt.Color;
import java.awt.Font;
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

public class VistaFinal extends JFrame{
    
    private JLabel lblFinal;
    private JLabel lblCerrar;
    private JLabel lblVolver;
    
    private JLabel lblJugadas;
    private JLabel lblPerdidas;
    private JLabel lblGanadas;
    private JLabel lblNombre;
    
    private JPanel jpContenidoGeneral;

    public VistaFinal() {
    }
    
    public void configurarVistaFinal(){
        setUndecorated(true);
        setVisible(true);
        setSize(1024,640);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void iniciarComponentesFinal(){
        configurarContenidoGeneral(); 
        asignacionImagenesALabels();
        
        
        configurarLabelsDeTexto();
        
        /* Configuración imagenes */
        
        posicionarElementos();
        
        ponerCursorActivoALabels();
        
        agregarElementosAContenidoGeneral();
        
    }
    
    public void addLblCerrarMouseListener(MouseAdapter listenControles){
        lblCerrar.addMouseListener(listenControles);
    }
    
    public void addLblVolverMouseListener(MouseAdapter listenControles){
        lblVolver.addMouseListener(listenControles);
    }
    
    public void setGanadas(double nuevoNombre){
        lblGanadas.setText(String.valueOf(nuevoNombre));
    }
    
    public void setPerdidas(double nuevoNombre){
        lblPerdidas.setText(String.valueOf(nuevoNombre));
    }
    
    public void setJugadas(double nuevoNombre){
        lblJugadas.setText(String.valueOf(nuevoNombre));
    }
    
    public void setNombre(String nuevoNombre){
        if(nuevoNombre.length() > 10){
            lblNombre.setText(nuevoNombre.substring(0,11));
        }else{
            lblNombre.setText(nuevoNombre);
        }
    }
    
    public JLabel getLblCerrar(){
        return lblCerrar;
    }

    public JLabel getLblVolver() {
        return lblVolver;
    }
    
    /* Metodos repetitivos */
    
    public void asignacionImagenesALabels(){
        /* Cargado de imagenes */
        
        Icon imagenFinal = new ImageIcon("src\\Imagenes\\27-Final-img.gif");
        Icon imagenVolver = new ImageIcon("src\\Imagenes\\13-Volver-img.gif");
        Icon imagenCerrar = new ImageIcon("src\\Imagenes\\04-Cerrar-img.gif");
        
        /* Inicializacion de imagenes */
        
        lblCerrar = new JLabel(imagenCerrar);
        lblVolver = new JLabel(imagenVolver);
        lblFinal = new JLabel(imagenFinal);
        
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
        lblNombre.setBounds(250, 230 , 500, 50);
        lblJugadas.setBounds(465, 330 , 500, 50);
        lblGanadas.setBounds(531, 430 , 500, 50);
        lblPerdidas.setBounds(531, 530 , 500, 50);
        lblFinal.setBounds(0,0,1024,640);
        lblCerrar.setBounds(930,10,240,80);
        lblVolver.setBounds(-150,10,240,80);
    }
    
    public void agregarElementosAContenidoGeneral(){
        jpContenidoGeneral.add(lblNombre);
        jpContenidoGeneral.add(lblCerrar);
        jpContenidoGeneral.add(lblVolver);
        jpContenidoGeneral.add(lblGanadas);
        jpContenidoGeneral.add(lblPerdidas);
        jpContenidoGeneral.add(lblJugadas);
        jpContenidoGeneral.add(lblFinal);
    }
    
    public void configurarLabelsDeTexto(){
        lblGanadas = new JLabel();
        lblJugadas = new JLabel();
        lblPerdidas = new JLabel();
        lblNombre = new JLabel();
        
        lblNombre.setForeground(Color.WHITE);
        lblNombre.setFont(new Font("arial", Font.BOLD, 30));
        lblPerdidas.setForeground(Color.WHITE);
        lblPerdidas.setFont(new Font("arial", Font.BOLD, 30));
        lblJugadas.setForeground(Color.WHITE);
        lblJugadas.setFont(new Font("arial", Font.BOLD, 30));
        lblGanadas.setForeground(Color.WHITE);
        lblGanadas.setFont(new Font("arial", Font.BOLD, 30));
    }
    
    
    
}

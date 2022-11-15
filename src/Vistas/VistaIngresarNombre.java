package Vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Julian Alvarez <alvarez.julian@correounivalle.edu.co>
 * @author Sebastian Cespedes <sebastian.cespedes@correounivalle.edu.co>
 * @author Juan Pablo Ante <juan.pablo.ante@correounivalle.edu.co>
 * 
 */

public class VistaIngresarNombre extends JFrame{
    
    private JLabel lblTema;
    private JLabel lblCerrar;
    private JLabel lblVolver;
    private JLabel lblIniciar;
    private JLabel lblIngresaNombre;
    
    private JTextField txtNombre;
    
    private JPanel jpContenidoGeneral;
    
    private boolean animalesActivo = false;
    private boolean coloresActivo = false;
    private boolean frutasActivo = false;

    public VistaIngresarNombre() {
    }
    
    public void configurarVistaTema(){
        setUndecorated(true);
        setVisible(true);
        setSize(1024,640);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void iniciarComponentesTema(){
        configurarContenidoGeneral();
        asignacionImagenesALabels();
        
        /* Nombre */
        
        configurarEntradaDeTexto();
        
        /* Configuración imagenes */
        
        posicionarElementos(); 
        ponerCursorActivoALabels();
        
        /* Se agregan labels al contenido general */
        
        agregarElementosAContenidoGeneral();
            
    }
    
    /* Metodos que cambiar las imagenes de color */
    
    public void agregarLblIniciar(){
        Icon imagenIniciar = new ImageIcon("src\\Imagenes\\11-Iniciar-img.png");
        lblIniciar.setIcon(imagenIniciar);    
    }
    
    public void agregarLblIngresarNombre(){
        Icon imagenIngresaNombre = new ImageIcon("src\\Imagenes\\14-IngresaNombre-img.png");
        lblIngresaNombre.setIcon(imagenIngresaNombre);  
    }
    
    public void eliminarLblIniciar(){
        lblIniciar.setIcon(null);
    }
    
    public void eliminarLblIngresarNombre(){
        lblIngresaNombre.setIcon(null);
    }
    
    public String getNombre(){
        return txtNombre.getText();
    }
    
    
    /* Metodos para añadir listeners */
    
    public void addLblCerrarMouseListener(MouseAdapter listenControles){
        lblCerrar.addMouseListener(listenControles);
    }
    
    public void addLblVolverMouseListener(MouseAdapter listenControles){
        lblVolver.addMouseListener(listenControles);
    }

    
    public void addLblIniciarMouseListener(MouseAdapter listenControles){
        lblIniciar.addMouseListener(listenControles);
    }
    
    public void addTxtNombreKeyListener(KeyListener listenControles){
        txtNombre.addKeyListener(listenControles);
    }
    
    /* Getters and Setters */
    
    public JLabel getLblCerrar(){
        return lblCerrar;
    }

    public JLabel getLblVolver() {
        return lblVolver;
    }
    
    public JLabel getLblIniciar(){
        return lblIniciar;
    }

    public boolean isAnimalesActivo() {
        return animalesActivo;
    }

    public boolean isColoresActivo() {
        return coloresActivo;
    }

    public boolean isFrutasActivo() {
        return frutasActivo;
    }

    public void setAnimalesActivo(boolean animalesActivo) {
        this.animalesActivo = animalesActivo;
    }

    public void setColoresActivo(boolean coloresActivo) {
        this.coloresActivo = coloresActivo;
    }

    public void setFrutasActivo(boolean frutasActivo) {
        this.frutasActivo = frutasActivo;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }
    
    
    
    
    /* Metodos repetitivos */
    
    public void asignacionImagenesALabels(){
        /* Cargado de imagenes */
        
        Icon imagenCerrar = new ImageIcon("src\\Imagenes\\04-Cerrar-img.png");
        Icon imagenTema = new ImageIcon("src\\Imagenes\\12-SeleccionarTema-img.png");
        Icon imagenVolver = new ImageIcon("src\\Imagenes\\13-Volver-img.png");
        
        /* Inicializacion de imagenes */
        
        lblCerrar = new JLabel(imagenCerrar);
        lblVolver = new JLabel(imagenVolver);
        lblTema = new JLabel(imagenTema);
        lblIngresaNombre = new JLabel();
        lblIniciar = new JLabel();
        
    }
    
    public void ponerCursorActivoALabels(){
        lblCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblIniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }
    
    public void configurarContenidoGeneral(){
        jpContenidoGeneral = new JPanel();
        jpContenidoGeneral.setBounds(0,0,1024,640);
        jpContenidoGeneral.setLayout(null);
        add(jpContenidoGeneral);
    }   
    
    public void posicionarElementos(){
        lblTema.setBounds(0,0,1024,640);
        lblCerrar.setBounds(930,10,240,80);
        lblVolver.setBounds(-150,10,240,80);
        lblIngresaNombre.setBounds(30,530,240,80);
        lblIniciar.setBounds(760,530,240,80);
    }
    
    public void agregarElementosAContenidoGeneral(){
        jpContenidoGeneral.add(txtNombre);
        jpContenidoGeneral.add(lblCerrar);
        jpContenidoGeneral.add(lblVolver);
        jpContenidoGeneral.add(lblIngresaNombre); 
        jpContenidoGeneral.add(lblIniciar);  
        jpContenidoGeneral.add(lblTema);
    }
    
    public void configurarEntradaDeTexto(){
        txtNombre = new JTextField();
        
        txtNombre.setBounds(410, 280, 470, 80);
        txtNombre.setHorizontalAlignment(JTextField.CENTER);
        txtNombre.setBorder(null);
        txtNombre.setForeground(Color.GRAY);
        txtNombre.setFont(new Font("arial", Font.BOLD, 30)); 
        
    }
    
    
    
}

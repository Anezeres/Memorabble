package Vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
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

public class VistaJuego extends JFrame{
    private JPanel jpContenidoGeneral;
    
    //private JLabel lblAhorcado;
    private JLabel lblFondoJuego;
    private JLabel lblNombre;
    private JLabel lblPuntos;
        
    private JLabel lblFichaInactiva;
    private JLabel lblFichaActiva;
    
    private ArrayList<Tarjeta> tarjetas = new ArrayList();

    
    private final Icon[] imagenesLetrasActivas;
    private final Icon[] imagenesLetrasInactivas;
    private final Icon[] imagenesLetrasCorrectas;
    
    
    
    private final JLabel[] lblLetras;
    

    public VistaJuego() {
        this.imagenesLetrasActivas = new Icon[26];
        this.imagenesLetrasInactivas = new Icon[26];
        this.imagenesLetrasCorrectas = new Icon[26];
        this.lblLetras = new JLabel[26];
    }
    
    public void configurarVistaAhorcado(){
        setUndecorated(true);
        setVisible(true);
        setSize(1024,640);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void iniciarComponentesAhorcado(){
        configurarContenidoGeneral();
        asignacionImagenesALabels();
        
        configurarLabelsDeTexto();
        
        /* Configuración imagenes */
        
        crearTarjetas();
        indicarPosicionLetras();
        posicionarElementos();
        
        ponerCursorActivoTarjetas();
        
        /* Se agregan labels al contenido general */
        
        agregarElementosAContenidoGeneral();
    }
    
    public void indicarPosicionLetras(){
        /* Primeras 9 Tarjetas */
        realizarBuclePosicionamiento(0, 7, 108);
        
        /* Segundas 7 letras */
        realizarBuclePosicionamiento(7, 14,210);
        
        /* Terceras 7 letras */
        realizarBuclePosicionamiento(14, 21,312);
        
        /* Ultimas 5 letras */
        realizarBuclePosicionamiento(21, 28,414);
        
        
        realizarBuclePosicionamiento(28, 35,516);
        
    }
    
    public void realizarBuclePosicionamiento(int letraInicial, int letraFinal, int altura){
        /*
        for(int i = letraInicial; i<letraFinal;i++){
            lblFichaInactiva.setBounds(posicionInicial, altura, 90, 90);
            posicionInicial = posicionInicial + 99;
        }
        */
        int posicionInicial = 66;
        for (int i = letraInicial; i<letraFinal;i++) {
            tarjetas.get(i).getImagenTarjeta().setBounds(posicionInicial, altura, 90, 90);
            posicionInicial = posicionInicial + 100;
        }
    }
    
    public void crearTarjetas(){
        for(int i = 1; i<6; i++){
            for(int j = 1; j<8 ;j++){
                System.out.print("[" + i+"]" + "["+ j +"]          ");
                Tarjeta nuevaTarjeta = new Tarjeta(i, j);
                tarjetas.add(nuevaTarjeta);
            }
            System.out.println("");
        }
    }
    
    
    
    public void ponerCursorActivoTarjetas(){
        for(Tarjeta tarjeta: tarjetas){
            tarjeta.getImagenTarjeta().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        }
    }
    



    
   /* Listener de cada letra */
   
    public void addLblTarjetasMouseListener(MouseAdapter listenControles){
        for (Tarjeta tarjeta: tarjetas) {
            tarjeta.getImagenTarjeta().addMouseListener(listenControles);
        }
    }
    
    
    public JLabel saberSiUnaTarjetaFuePresionada(JLabel tarjetaPreguntada){
        
        JLabel tarjetaResultante = null;
        for (Tarjeta tarjeta: tarjetas) {
            if(tarjeta.getImagenTarjeta() == tarjetaPreguntada){
                tarjetaResultante = tarjetaPreguntada;
            }
        }
        return tarjetaResultante;
    }
    
    
    public Tarjeta saberTarjetaPresionada(JLabel tarjetaPreguntada){
        
        Tarjeta tarjetaResultante = null;
        for (Tarjeta tarjeta: tarjetas) {
            if(tarjeta.getImagenTarjeta() == tarjetaPreguntada){
                tarjetaResultante = tarjeta;
            }
        }
        
        return tarjetaResultante;
    }
    
    
    
    public void ponerTarjetActiva(Tarjeta tarjetaIngresada){

        
        for (Tarjeta tarjeta: tarjetas) {
            if(tarjeta == tarjetaIngresada){
                tarjeta.cambiarActivo();
            }
        }
    }
    
    public void ponerTarjetInactiva(Tarjeta tarjetaIngresada){

        
        for (Tarjeta tarjeta: tarjetas) {
            if(tarjeta == tarjetaIngresada){
                tarjeta.cambiarInactivo();
            }
        }
    }
    
    /*
    public void ponerLetraCorrecta(char letra){
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        for(int i = 0; i<letras.length() ; i++){
            if(letra == letras.charAt(i)){
                lblLetras[i].setIcon(imagenesLetrasCorrectas[i]);
            }
        }
    }
    
    public void agregarLetraSeleccionada(int posicion, int sizePalabra, JLabel letraSeleccionada){
        int posicionInicial = 0;
        
        ponerLetraCorrecta(saberLetraPresionada(letraSeleccionada));
        switch (sizePalabra) {
            case 4 -> posicionInicial = 523;
            case 5 -> posicionInicial = 491;
            case 6 -> posicionInicial = 450;
            case 7 -> posicionInicial = 410;
            default -> {
            }
        }
        if(posicion == -1){
            System.out.println("Ignora la letra");
        }else{
            for(int i = 1; i<posicion + 1;i++){
            if(i == posicion){
                JLabel nuevaLetraSeleccion = new JLabel(letraSeleccionada.getIcon());
                nuevaLetraSeleccion.setBounds(posicionInicial, 126, 73, 73);
                jpContenidoGeneral.add(nuevaLetraSeleccion,10,10);
            }
            posicionInicial = posicionInicial + 83;
            }
        }
    }
    
    public void cambiarFondoSegunSizePalabra(int vidas){
        Icon imagenFondo = new ImageIcon("src\\Imagenes\\Fondo\\24-FondoJuego"+vidas+"-img.png");
        lblFondoJuego.setIcon(imagenFondo);
    }
    */
    
    public void setNombre(String nuevoNombre){
        if(nuevoNombre.length() > 10){
            lblNombre.setText(nuevoNombre.substring(0,11));
        }else{
            lblNombre.setText(nuevoNombre);
        }
    }
    
    public void setIntentos(int numeroIntentos){
        lblPuntos.setText(String.valueOf(numeroIntentos));
    }
    
    
    /* Metodos repetitivos */
    
    public void asignacionImagenesALabels(){
        /* Cargado de imagenes */
        Icon imagenTarjetaInactiva = new ImageIcon("src\\Imagenes\\Tarjetas\\00-TarjetaInactiva-img.png");
        
        
        Icon imagenFondo = new ImageIcon("src\\Imagenes\\24-FondoJuego3-img.png");
        lblFichaInactiva = new JLabel(imagenTarjetaInactiva);
        lblFondoJuego = new JLabel(imagenFondo);
        
    }
    
    public void configurarLabelsDeTexto(){
        lblNombre = new JLabel();
        lblPuntos = new JLabel("0");
        
        lblNombre.setForeground(Color.WHITE);
        lblNombre.setFont(new Font("arial", Font.BOLD, 30));
        lblPuntos.setForeground(Color.WHITE);
        lblPuntos.setFont(new Font("arial", Font.BOLD, 30));    
    }
    
    public void configurarContenidoGeneral(){
        jpContenidoGeneral = new JPanel();
        jpContenidoGeneral.setBounds(0,0,1024,640);
        jpContenidoGeneral.setLayout(null);
        add(jpContenidoGeneral);
    }   
    
    public void posicionarElementos(){
        lblNombre.setBounds(160, 11 , 500, 50);
        lblPuntos.setBounds(500, 11 , 500, 50);
        lblFichaInactiva.setBounds(66, 108 , 90, 90);
        lblFondoJuego.setBounds(0,0,1024,640);
    }
    
    public void agregarElementosAContenidoGeneral(){
        //jpContenidoGeneral.add(lblFichaInactiva);
        
        agregarTarjetasTablero();
        jpContenidoGeneral.add(lblPuntos);
        jpContenidoGeneral.add(lblNombre);
        jpContenidoGeneral.add(lblFondoJuego);
    }
    
    public void agregarTarjetasTablero(){
        for (Tarjeta tarjeta : tarjetas) {
            jpContenidoGeneral.add(tarjeta.getImagenTarjeta());
        }
    }
    
    

    
}

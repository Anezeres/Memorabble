/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;

import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author RYZEN
 */
public class Tarjeta extends JFrame{
    private int posicionX;
    private int posicionY;
    private JLabel imagenTarjeta;

    public Tarjeta(int posicionX, int posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        Icon imagenTarjetaInactiva = new ImageIcon("src\\Imagenes\\Tarjetas\\00-TarjetaInactiva-img.png");
        this.imagenTarjeta = new JLabel(imagenTarjetaInactiva);
    }
    
    
    public void cambiarActivo(){
        Icon imagenTarjetaActiva = new ImageIcon("src\\Imagenes\\Tarjetas\\00-TarjetaActiva-img.png");
        imagenTarjeta.setIcon(imagenTarjetaActiva);
    }
    
    public void cambiarInactivo(){
        Icon imagenTarjetaInactiva = new ImageIcon("src\\Imagenes\\Tarjetas\\00-TarjetaInactiva-img.png");
        imagenTarjeta.setIcon(imagenTarjetaInactiva);
    }

    public JLabel getImagenTarjeta() {
        return imagenTarjeta;
    }
    
    public ArrayList getPosicionTablero(){
        ArrayList<Integer> coordenada = new ArrayList();
        coordenada.add(posicionX);
        coordenada.add(posicionY);
        
        return coordenada;     
    }
    
    public void cambiarTarjetaConFigura(String figura, String color){
        Icon imagen = new ImageIcon("src\\Imagenes\\"+figura+"\\"+color+".png");
        imagenTarjeta.setIcon(imagen);
    }
    

    
    
    
    
}

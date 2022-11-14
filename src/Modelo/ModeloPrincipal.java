package Modelo;

/**
 *
 * @author Julian Alvarez <alvarez.julian@correounivalle.edu.co>
 * @author Sebastian Cespedes <sebastian.cespedes@correounivalle.edu.co>
 * @author Juan Pablo Ante <juan.pablo.ante@correounivalle.edu.co>
 * 
 */

public class ModeloPrincipal {
    
    private Jugador jugador;
    private Juego juego;

    public ModeloPrincipal() {
        this.jugador = new Jugador();
        this.juego = new Juego();

    }
    
    /* Getters and Setters  */

    public Jugador getJugador() {
        return jugador;
    }

    public Juego getJuego(){
      return juego;
    }
    
    
    
    
}

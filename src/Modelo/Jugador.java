package Modelo;

/**
 *
 * @author Julian Alvarez <alvarez.julian@correounivalle.edu.co>
 * @author Sebastian Cespedes <sebastian.cespedes@correounivalle.edu.co>
 * @author Juan Pablo Ante <juan.pablo.ante@correounivalle.edu.co>
 * 
 */

public class Jugador {
    
    private String nombre;
    
    private int conteoErrores;
    private int numeroIntentos;
    
    private int partidasJugadas;
    private int partidasPerdidas;
    private int partidasGanadas;
    
    private double porcentajeGanadas;
    private double porcentajePerdidas;


    public Jugador() {
        numeroIntentos = 10;

    }

    public int getConteoErrores() {
        return conteoErrores;
    }
    
    public void setConteoErrores(int inicio) {
        conteoErrores = inicio;
    }
    
    public void reiniciarErrores(){
        conteoErrores = 0;
    }
    
    public void sumarConteoErrores() {
        conteoErrores++;
    }
    
    public void setNombre(String nombreNuevo){
        nombre = nombreNuevo;
    }
    
    public String getNombre(){
        return nombre;
    }

    public int getNumeroIntentos() {
        return numeroIntentos;
    }
    
    public void reiniciarNumeroIntentos() {
        numeroIntentos = 10;
    }

    public void restarNumeroIntentos() {
        numeroIntentos--;
    }

    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    public void setPartidasJugadas(int partidasJugadas) {
        this.partidasJugadas = partidasJugadas;
    }

    public int getPartidasPerdidas() {
        return partidasPerdidas;
    }

    public void setPartidasPerdidas(int partidasPerdidas) {
        this.partidasPerdidas = partidasPerdidas;
    }

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    public double getPorcentajeGanadas() {
        double porcentajeGanadas1 =((partidasGanadas/(partidasGanadas + partidasPerdidas))*100 );
        return porcentajeGanadas1;
    }


    public double getPorcentajePerdidas() {
        double porcentajePerdidas1 = (((partidasPerdidas/(partidasGanadas + partidasPerdidas)))*100 );
        return porcentajePerdidas1;
    }

    
    

    @Override
    public String toString() {
        return "\nPorcentaje Ganadas: " + getPorcentajeGanadas() +" \nPorcentaje perdidas: "+ getPorcentajePerdidas() + "\npartidasJugadas=" + partidasJugadas + ","
                + " \npartidasPerdidas=" + partidasPerdidas + ","
                + " \npartidasGanadas=" + partidasGanadas + '}';
        
    }
    
    
    
    
    
    
    
}

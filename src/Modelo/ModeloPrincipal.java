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
    private Ronda ronda;

    public ModeloPrincipal(Jugador jugador, Ronda ronda) {
        this.jugador = jugador;
        this.ronda = ronda;
    }
    
    public boolean validarLetraIngresada(char letra) {
        boolean resultadoConsulta;
        int index = ronda.getFraseActual().indexOf(letra);
        
        System.out.println("La letra ingresada es: " + letra);

        ronda.setPosicionDeLetra(index);
        if(index != -1){
            resultadoConsulta = false;
            remplazarCaracterFraseAuxiliar(index);
            
        }else {
            resultadoConsulta = true;
            jugador.sumarConteoErrores();
            jugador.restarNumeroIntentos();
            
        }
        return resultadoConsulta;
    }
    
    

    public void remplazarCaracterFraseAuxiliar(int index){ 
        String primeraPartePalabraAux = ronda.getPalabraActualAuxiliar().substring(0, index);
        char letraQueSeIngresa = ronda.getPalabraActual().charAt(index);
        String parteRestantePalabraAux = ronda.getPalabraActualAuxiliar().substring(index + 1);
        
        ronda.setPalabraActualAuxiliar(primeraPartePalabraAux + letraQueSeIngresa + parteRestantePalabraAux);
        System.out.println("Palabra Auxiliar: " + ronda.getPalabraActualAuxiliar());
    }
    
    public boolean validarFraseCompleta(){
        return ronda.getPalabraActualAuxiliar().contains(ronda.getFraseActual());
    }

    /* Getters and Setters */
    
    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Ronda getRonda() {
        return ronda;
    }

    public void setRonda(Ronda ronda) {
        this.ronda = ronda;
    }
    
    
    
}
